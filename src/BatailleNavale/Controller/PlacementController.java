package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.*;

public class PlacementController extends AbstractController implements ActionListener, MouseListener
{
    private PlacementView view;

    private Bateau bateau;
    private Joueur joueur;
    private boolean orientation = true;

    private Color couleur;

	public PlacementController(PlacementView view)
	{
        this.view = view;
	}

    public void control()
    {
        if(!fenetre.getModele().getJoueurCourant().bateauxPlaces())
        {
            if(fenetre.getModele().getJoueurCourant() instanceof Ordinateur)
            {
                fenetre.getModele().getJoueurCourant().placementAleatoireFlotte();
                fenetre.getModele().joueurSuivant();
                fenetre.changerVue(view);
            }
        } 
        else
        {
            fenetre.changerVue(new JeuView());
        }
    }

    public void actionPerformed(ActionEvent arg0)
    {
        if(arg0.getSource() == view.getBoutonOrientation())
        {
            orientation = !(orientation);
        }
    }

    public Position getPosCase(MouseEvent event)
    {
        Grille grille = view.getGrille();
        for(int i=0; i<grille.getTaille(); i++)
            for(int j=0; j<grille.getTaille(); j++)
                if(event.getSource() == grille.getCase(i, j))
                    return new Position(i, j);
        return null;
    }

    public void mouseEntered(MouseEvent event)
    {
        Position pos = getPosCase(event);
        Grille grille = view.getGrille();

        bateau = fenetre.getModele().getJoueurCourant().getBateauxNonPlaces()[0];

        Placement placement = new Placement(new Position(pos.getCoord_X()+1, pos.getCoord_Y()+1), !orientation);

        for(int i=0; i<bateau.getTaille(); i++)
        {   
            int x = pos.getCoord_X() + (orientation?0:i);
            int y = pos.getCoord_Y() + (orientation?i:0);

            if((grille.getTaille()) > x && (grille.getTaille() > y))     
            {

                Case bouton = grille.getCase(x, y);
                bouton.afficherBateau(bateau, orientation, i);
                if(fenetre.getModele().getJoueurCourant().getChampDeBataille().placementAutorise(placement, bateau))
                    bouton.setBackground(Color.green);
                else
                    bouton.setBackground(Color.red);
            }
        }
    }

    public void mouseExited(MouseEvent event)
    {
        fenetre.update();
    }

    public void mouseClicked(MouseEvent event)
    {
        Position pos = getPosCase(event);
        Grille grille = view.getGrille();

        Placement placement = new Placement(new Position(pos.getCoord_X()+1, pos.getCoord_Y()+1), !orientation);
       
       if(fenetre.getModele().getJoueurCourant().getChampDeBataille().placementAutorise(placement, bateau))
        {
            fenetre.getModele().getJoueurCourant().placerBateau(bateau, placement);
            if(fenetre.getModele().getJoueurCourant().bateauxPlaces())
            {
                fenetre.getModele().joueurSuivant();
                if(fenetre.getModele().getJoueurCourant().bateauxPlaces())
                    if(estConnecte())
                    {
                        fenetre.changerVue(new MessageView("En attente du tir de l'adversaire..."));

                        Thread placer = new Thread() {
                            public void run() 
                            {
                                envoyerModele();
                                
                                recevoirModele();
                                    
                                fenetre.changerVue(new JeuView());
                            }
                        };

                        placer.start();
                    }
                    else 
                    {
                        fenetre.changerVue(new MessageView("Début de la partie !", new JeuView(), false));
                    }
                else
                {
                    if(estConnecte())
                    {
                        fenetre.changerVue(new MessageView("Attente placement..."));
                        
                        Thread placer = new Thread() {
                            public void run() 
                            {
                                           
                                envoyerModele();    
                                
                                recevoirModele();

                                fenetre.changerVue(new JeuView());
                            }
                        };

                        placer.start();
                    }
                }    
            }
            else
            {
                fenetre.changerVue(view);
            }              
        }
        else
        {
            fenetre.changerVue(new MessageView("Mauvais placement !", view, true));
        } 
    }

    public void mouseReleased(MouseEvent event){}  
    public void mousePressed(MouseEvent event){}
}

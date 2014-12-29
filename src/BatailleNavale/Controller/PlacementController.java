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

    private static boolean orientation = true;

    private Bateau bateau;
    private Joueur joueur;

    private Color couleur;

	public PlacementController(PlacementView view)
	{
        this.view = view;
	}

    public void control()
    {
        if(!fenetre.getModele().getJoueurCourant().bateauxPlaces())
        {
            view.afficherNomBateau("<html>* Placement du " + fenetre.getModele().getJoueurCourant().getBateauxNonPlaces()[0].getNom()+" *</html>");

            if(fenetre.getModele().getJoueurCourant() instanceof Ordinateur)
            {
                fenetre.getModele().getJoueurCourant().placementAleatoireFlotte();
                fenetre.getModele().joueurSuivant();
                fenetre.changerVue(view);
            }
            else
            {
                view.getBoutonOrientation().setVisible(true);
                view.getBoutonValider().setVisible(false);
            }
        } 
        else
        {
            view.afficherNomBateau("<html>* Tous vos bateaux<br/> sont placés ! *</html>");

            view.getBoutonOrientation().setVisible(false);
            view.getBoutonValider().setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent arg0)
    {
        if(arg0.getSource() == view.getBoutonOrientation())
        {
            orientation = !(orientation);
        }
        else if(arg0.getSource() == view.getBoutonAuto())
        {
           autoPlacement();            
        }
        else if(arg0.getSource() == view.getBoutonAnnuler())
        {
            annulerPlacement();
        }
        else if(arg0.getSource() == view.getBoutonValider())
        {
            validerPlacement();
        }
    }

    public void validerPlacement()
    {
        if(fenetre.getModele().getJoueurCourant().bateauxPlaces())
        {
            fenetre.getModele().joueurSuivant();

            if(estConnecte())
            {
                if(fenetre.getModele().getJoueurCourant().bateauxPlaces())
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
            else
            {
                boolean ok = true;
                for(int i=0; i<fenetre.getModele().getJoueurs().length; i++)
                    if(!fenetre.getModele().getJoueurs()[i].bateauxPlaces())
                        ok = false;

                if(ok)
                    fenetre.changerVue(new MessageView("Début de la partie !", new JeuView(), false));
                else
                    fenetre.changerVue(new PlacementView());
            }
        }
    }

    public void annulerPlacement()
    {
        for(int i=0; i<fenetre.getModele().getJoueurCourant().getBateaux().length; i++)
            fenetre.getModele().getJoueurCourant().retirerBateau(fenetre.getModele().getJoueurCourant().getBateaux()[i]);
       
        fenetre.changerVue(new PlacementView());
    }

    public void autoPlacement()
    {
        annulerPlacement();
        fenetre.getModele().getJoueurCourant().placementAleatoireFlotte();
        fenetre.changerVue(new PlacementView());
    }

    public void mouseClicked(MouseEvent event)
    {
        Case gcase = (Case) event.getSource();

        Placement placement = new Placement(new Position(gcase.getI(), gcase.getJ()), !orientation);
       
       if(fenetre.getModele().getJoueurCourant().getChampDeBataille().placementAutorise(placement, bateau))
        {
            fenetre.getModele().getJoueurCourant().placerBateau(bateau, placement);
            fenetre.changerVue(new PlacementView());
        }
        else
            fenetre.changerVue(new MessageView("Mauvais placement !", view, true));
    }

    public void mouseEntered(MouseEvent event)
    {
        if(!fenetre.getModele().getJoueurCourant().bateauxPlaces())
        {
            Case gcase = (Case) event.getSource();
            Grille grille = view.getGrille();

            bateau = fenetre.getModele().getJoueurCourant().getBateauxNonPlaces()[0];

            Placement placement = new Placement(new Position(gcase.getI(), gcase.getJ()), !orientation);

            for(int i=0; i<bateau.getTaille(); i++)
            {   
                int x = gcase.getI() + (orientation?0:i) - 1;
                int y = gcase.getJ() + (orientation?i:0) - 1;

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
    }

    public void mouseExited(MouseEvent event)
    {
        fenetre.changerVue(new PlacementView());
    }

    public void mouseReleased(MouseEvent event){}  
    public void mousePressed(MouseEvent event){}
}

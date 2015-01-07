package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.*;

/**
 * Classe <code> PlacementController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class PlacementController extends AbstractController implements ActionListener, MouseListener
{
    /**
     *  La vue a controler
     */
    private PlacementView view;

    /**
     *  Orientation du bateau a placer
     */
    private static boolean orientation = true;

    /**
     *  Bateau a placer
     */
    private Bateau bateau;

    /**
     * Construit un <code>PlacementController</code> a partir d'une PlacementView
     * @param view vue a controler
     */
	public PlacementController(PlacementView view)
	{
        this.view = view;
	}

    /**
     *  Controle de la vue 
     */
    public void control()
    {
        boolean ok = true;
        for(int i=0; i<fenetre.getModele().getJoueurs().length; i++)
            if(!fenetre.getModele().getJoueurs()[i].bateauxPlaces())
                ok = false;

        if(ok && (fenetre.getModele().getJoueurCourant() instanceof Ordinateur))
            fenetre.changerVue(new JeuView());
        
        if(!fenetre.getModele().getJoueurCourant().bateauxPlaces())
        {
            view.afficherNomBateau("<html><br/>Placement du <br/>" + fenetre.getModele().getJoueurCourant().getBateauxNonPlaces()[0].getNom()+"</html>");

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
            view.afficherNomBateau("<html><br/>Tous vos bateaux<br/> sont placés !</html>");

            view.getBoutonOrientation().setVisible(false);
            view.getBoutonValider().setVisible(true);
        }
    }

    /**
     *  Les differentes actions a executer selon les boutons utilises
     */
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

package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;

/**
 * Classe <code> JoueurController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class JoueurController extends AbstractController implements ActionListener
{
    /**
     *  La vue a controler
     */
    private JoueurView view;

    /**
     * Construit un <code>JoueurController</code> a partir d'une JoueurView
     * @param view vue a controler
     */
    public JoueurController(JoueurView view)
    {
        this.view = view;
    }
    
    /**
     *  Les differentes actions a executer selon les boutons utilises
     */
    public void actionPerformed(ActionEvent arg0) 
    {
        if(arg0.getSource() == view.getBoutonAjouterJoueur())
        {
            if(view.getNbJoueurs()>=4)
                fenetre.changerVue(new MessageView("<html>Nombre maximun de joueurs atteint.</html>", view, true));
            else
                view.ajouterJoueur();
        }
        else if(arg0.getSource() == view.getBoutonSupprimerJoueur())
        {
            if(view.getNbJoueurs()<=2)
                fenetre.changerVue(new MessageView("<html>Il faut au minimun deux joueurs.</html>", view, true));
            else
                view.supprimerJoueur();
        }
        else if(arg0.getSource() == view.getBoutonValider())
        {
            int nb_joueur = view.getNbJoueurs();
            Joueur j = null;

            for(int i=0; i<nb_joueur; i++)
            {
                if(view.getTypeJoueur(i).equals("Humain"))
                
                    j = new Humain("Joueur " + (i+1), fenetre.getModele().getOptions().getTailleGrille());

                else
                    j = new Ordinateur("Joueur " + (i+1), fenetre.getModele().getOptions().getTailleGrille(), fenetre.getModele().getOptions().getNiveauIA());

                fenetre.getModele().ajouterJoueur(j);
                fenetre.getModele().ajouterBateaux(j);
            }

            fenetre.changerVue(new PlacementView());
        }
    }
}

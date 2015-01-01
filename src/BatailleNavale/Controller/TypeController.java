package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;

/**
 * Classe <code> TypeController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class TypeController extends AbstractController implements ActionListener
{
    /**
     *  La vue a controler
     */
    private TypeView view;

    /**
     * Construit un <code>TypeController</code> a partir d'une TypeView
     * @param view vue a controler
     */
    public TypeController(TypeView view)
    {
        this.view = view;
    }

    /**
     *  Les differentes actions a executer selon les boutons utilises
     */
    public void actionPerformed(ActionEvent arg0) 
    {
    	if(arg0.getSource() == view.getBoutonClassique())
    	{
            fenetre.getModele().setTypePartie(TypePartie.CLASSIQUE);
    	}
    	else if(arg0.getSource() == view.getBoutonRadar())
    	{
    		fenetre.getModele().setTypePartie(TypePartie.RADAR);
    	}
    	else if(arg0.getSource() == view.getBoutonArtillerie())
    	{
    		fenetre.getModele().setTypePartie(TypePartie.ARTILLERIE);
    	}
        else if(arg0.getSource() == view.getBoutonAlerte())
        {
            fenetre.getModele().setTypePartie(TypePartie.ALERTE);
        }
    	else if(arg0.getSource() == view.getBoutonRetour())
    	{	
    		fenetre.changerVue(new ChoixModeView());
    	}

        if(estConnecte())
        {
            Humain h1 = new Humain("Joueur 1", fenetre.getModele().getOptions().getTailleGrille());
            Humain h2 = new Humain("Joueur 2", fenetre.getModele().getOptions().getTailleGrille());

            fenetre.getModele().ajouterJoueur(h1);
            fenetre.getModele().ajouterJoueur(h2);

            fenetre.getModele().ajouterBateaux(h1); 
            fenetre.getModele().ajouterBateaux(h2);

            fenetre.changerVue(new PlacementView());
        } 
        else
        {
            fenetre.changerVue(new JoueurView());
        }
	}
}

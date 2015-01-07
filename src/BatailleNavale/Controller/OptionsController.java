
package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.View.*;

import javax.swing.JOptionPane;

import java.awt.event.*;
import java.util.ArrayList;

/**
 * Classe <code> OptionsController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class OptionsController extends AbstractController implements ActionListener
{
    /**
     *  La vue a controler
     */
    private OptionsView view;

    /**
     *  Choix de l'utilisateur
     */
	private int choix;

    /**
     * Construit un <code>OptionsController</code> a partir d'une OptionsView
     * @param view vue a controler
     */
	public OptionsController(OptionsView view)
	{
		this.view = view;
	}

    /**
     *  Les differentes actions a executer selon les boutons utilises
     */
    public void actionPerformed(ActionEvent arg0) 
    {
        if(arg0.getSource() == view.getBoutonJouer())
        {
            if(modifierOptions())
                    fenetre.changerVue(new ChoixModeView());
                else
                    fenetre.changerVue(new MessageView("Impossible de valider les options.", view, true));
        }
        else if(arg0.getSource() == view.getBoutonRetour())
        {
            choix = fenetre.afficherChoixMessage("Sauvegarder les modifications ?", "Attention");
            if(choix == JOptionPane.YES_OPTION)
                if(modifierOptions())
                    fenetre.changerVue(new AccueilView());
                else
                   fenetre.changerVue(new MessageView("Impossible de valider les options.", view, true));
            else if(choix == JOptionPane.NO_OPTION)
                fenetre.changerVue(new AccueilView());
        }
    } 
    
    /**
     *  On modifie les options dans le modele
     */
	public boolean modifierOptions()
	{
        Difficulte check = Difficulte.FACILE;
        ArrayList<Bateau> flotte = new ArrayList<Bateau>();
        if(view.getBoutonCuirasse().getState())
            flotte.add(new Cuirasse());
        if(view.getBoutonCuirasse2().getState())
            flotte.add(new Cuirasse());
        if(view.getBoutonZodiac().getState())
            flotte.add(new Zodiac());
        if(view.getBoutonSousMarin().getState())
            flotte.add(new SousMarin());
        if(view.getBoutonPorteAvion().getState())
            flotte.add(new PorteAvion());

        if(view.getBoutonFacile().isSelected())
            check = Difficulte.FACILE;
        else if(view.getBoutonMoyen().isSelected())
            check = Difficulte.MOYEN;
        else if(view.getBoutonDifficile().isSelected())
            check = Difficulte.DIFFICILE;

        if(flotte.size()>1)
        {
            fenetre.getModele().getOptions().setFlotte(flotte.toArray(new Bateau[flotte.size()]));
            fenetre.getModele().getOptions().setTailleGrille((int) view.getSpinner().getValue());
            fenetre.getModele().getOptions().setNiveauIA(check);
            return true;
        } 
        else
        {
            return false;
        }        
	} 
}

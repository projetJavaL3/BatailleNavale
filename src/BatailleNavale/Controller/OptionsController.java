
package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.View.*;

import javax.swing.JOptionPane;

import java.awt.event.*;
import java.util.ArrayList;

public class OptionsController extends AbstractController implements ActionListener
{
	private int choix;
	private OptionsView view;

	public OptionsController(OptionsView view)
	{
		this.view = view;
	}

	public boolean modifierOptions()
	{
        int check = 1;
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
            check = 1;
        else if(view.getBoutonMoyen().isSelected())
            check = 2;
        else if(view.getBoutonDifficile().isSelected())
            check = 3;

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
}

package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

/**
 * Classe <code> AccueilController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class AccueilController extends AbstractController implements ActionListener
{
    /**
     *  La vue a controler 
     */
    private AccueilView view;

    /**
     * Construit un <code>AccueilController</code> a partir d'une AccueilView
     * @param view vue a controler
     */
	public AccueilController(AccueilView view)
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
    		fenetre.changerVue(new ChoixModeView());
    	}
    	else if(arg0.getSource() == view.getBoutonOptions())
    	{
    		fenetre.changerVue(new OptionsView());
    	}
    	else if(arg0.getSource() == view.getBoutonCredits())
    	{
    		fenetre.changerVue(new CreditsView());
    	}
	} 
}

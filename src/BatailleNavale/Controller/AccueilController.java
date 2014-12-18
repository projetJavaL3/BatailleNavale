package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class AccueilController extends AbstractController implements ActionListener
{
    private AccueilView view;

	public AccueilController(AccueilView view)
	{
       this.view = view;
	}

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

package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class AccueilController extends AbstractController implements ActionListener
{

	public AccueilController(MainView view, Modele modele)
	{
		super(view, modele);
	}

    public void actionPerformed(ActionEvent arg0) 
    {
    	AccueilView container = (AccueilView) view.getContainer();
    	if(arg0.getSource() == container.getBoutonJouer())
    	{
    		view.changerVue(new TypeView(view, modele));
    	}
    	else if(arg0.getSource() == container.getBoutonOptions())
    	{
    		view.changerVue(new OptionsView(view, modele));
    	}
    	else if(arg0.getSource() == container.getBoutonCredits())
    	{
    		view.changerVue(new CreditsView(view, modele));
    	}
	}  
}

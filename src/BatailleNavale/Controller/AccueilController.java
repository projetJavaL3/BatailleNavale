package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class AccueilController extends AbstractController implements ActionListener
{
    private AccueilView view;

	public AccueilController(AccueilView view, Modele modele)
	{
        super(view.getFenetre(), modele);
		this.view = view;
	}

    public void actionPerformed(ActionEvent arg0) 
    {
    	if(arg0.getSource() == view.getBoutonJouer())
    	{
    		fenetre.changerVue(new TypeView(fenetre, modele));
    	}
    	else if(arg0.getSource() == view.getBoutonOptions())
    	{
    		fenetre.changerVue(new OptionsView(fenetre, modele));
    	}
    	else if(arg0.getSource() == view.getBoutonCredits())
    	{
    		fenetre.changerVue(new CreditsView(fenetre, modele));
    	}
	}  
}

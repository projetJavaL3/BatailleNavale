package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class ChoixModeController extends AbstractController implements ActionListener
{
    private ChoixModeView view;

	public ChoixModeController(ChoixModeView view)
	{
		this.view = view;
	}

    public void actionPerformed(ActionEvent arg0) 
    {
    	if(arg0.getSource() == view.getBoutonLocal())
    	{
    		fenetre.changerVue(new TypeView());
    	}
    	else if(arg0.getSource() == view.getBoutonReseau())
    	{
    		fenetre.changerVue(new ModeReseauView());
    	}
    	else if(arg0.getSource() == view.getBoutonRetour())
    	{
    		fenetre.changerVue(new AccueilView());
    	}
	}  
}

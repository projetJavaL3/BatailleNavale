
package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class OptionsController extends AbstractController implements ActionListener
{
	private OptionsView view;

	public OptionsController(OptionsView view, Modele modele)
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
    		else if(arg0.getSource() == view.getBoutonRetour())
    		{
    			fenetre.changerVue(new AccueilView(fenetre, modele));
    		}
    	
	}  
}

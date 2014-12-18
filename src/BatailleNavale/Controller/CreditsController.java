package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class CreditsController extends AbstractController implements ActionListener
{
	private CreditsView view;

	public CreditsController(CreditsView view)
	{
		this.view = view;
	}

    public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == view.getBoutonBrady())
		{
			view.getPanneauBrady().setVisible(!view.getPanneauBrady().isVisible());
		}
		else if(arg0.getSource() == view.getBoutonMaxime())
		{
			view.getPanneauMaxime().setVisible(!view.getPanneauMaxime().isVisible());
		}
		else if(arg0.getSource() == view.getBoutonTheo())
		{
			view.getPanneauTheo().setVisible(!view.getPanneauTheo().isVisible());
		}
		else if(arg0.getSource() == view.getBoutonYanis())
		{
			view.getPanneauYanis().setVisible(!view.getPanneauYanis().isVisible());
		}
		else if(arg0.getSource() == view.getBoutonRetour())
		{
			fenetre.changerVue(new AccueilView());
		}			
    }  
}

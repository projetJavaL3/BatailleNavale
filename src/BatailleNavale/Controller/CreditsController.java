package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

/**
 * Classe <code> CreditsController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class CreditsController extends AbstractController implements ActionListener
{
	/**
	 *	La vue a controler 
	 */
	private CreditsView view;

    /**
     * Construit un <code>CreditsController</code> a partir d'une CreditsView
     * @param view vue a controler
     */
	public CreditsController(CreditsView view)
	{
		this.view = view;
	}

    /**
     *  Les differentes actions a executer selon les boutons utilises
     */
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

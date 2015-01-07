package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

/**
 * Classe <code> AideController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class AideController extends AbstractController implements ActionListener
{
	/**
	 *	La vue a controler 
	 */
	private AideView view;
	
	/**
     	 * Construit un <code>AideController</code> a partir d'une AideView
    	 * @param view vue a controler
     	 */
	public AideController(AideView view)
	{
		this.view = view;
	}

	/**
     *  Les differentes actions a executer selon les boutons utilises
     */
    public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getSource() == view.getBoutonClassique())
		{
			view.getPanneauClassique().setVisible(!view.getPanneauClassique().isVisible());
		}
		else if(arg0.getSource() == view.getBoutonRadar())
		{
			view.getPanneauRadar().setVisible(!view.getPanneauRadar().isVisible());
		}
		else if(arg0.getSource() == view.getBoutonArtillerie())
		{
			view.getPanneauArtillerie().setVisible(!view.getPanneauArtillerie().isVisible());
		}
		else if(arg0.getSource() == view.getBoutonAlerte())
		{
			view.getPanneauAlerte().setVisible(!view.getPanneauAlerte().isVisible());
		}
		else if(arg0.getSource() == view.getBoutonRetour())
		{
			fenetre.changerVue(new AccueilView());
		}			
    }  
}

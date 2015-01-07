package BatailleNavale.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BatailleNavale.Model.Modele;
import BatailleNavale.View.AccueilView;
import BatailleNavale.View.Fenetre;
import BatailleNavale.View.FinView;

/**
 * Classe <code> CreditsController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class FinController extends AbstractController implements ActionListener
{
	/**
	 * La vue a controler 
	 */
	private FinView view;

	/**
	 *	Choix de l'utilisateur 
	 */
	private int choix;
	
	/**
     * Construit un <code>CreditsController</code> a partir d'une CreditsView
     * @param view vue a controler
     */
	public FinController(FinView view)
	{
		this.view = view;
	}
	
	/**
     *  Les differentes actions a executer selon les boutons utilises
     */
	public void actionPerformed(ActionEvent arg0) 
	{
	  	if(arg0.getSource() == view.getMenuPrincipal())
	   	{
	   		fenetre.changerVue(new AccueilView());
	   	}
	   	else if(arg0.getSource() == view.getBoutonQuitter())
	   	{
	   		MenuController.quitter();
	  	}
	}	
}

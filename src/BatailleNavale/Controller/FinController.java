package BatailleNavale.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BatailleNavale.Model.Modele;
import BatailleNavale.View.AccueilView;
import BatailleNavale.View.Fenetre;
import BatailleNavale.View.FinView;

public class FinController extends AbstractController implements ActionListener
{
	private FinView view;
	private int choix;
	
	public FinController(FinView view)
	{
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
	  	if(arg0.getSource() == view.getMenuPrincipal())
	   	{
	   		fenetre.changerVue(new AccueilView());
	   	}
	   	else if(arg0.getSource() == view.getBoutonQuitter())
	   	{
	   		quitter();
	  	}
	}	

	public void quitter()
	{
		choix = fenetre.afficherChoixMessage("Etes-vous sur de vouloir quitter le jeu ?", "Attention");
	    if(choix == JOptionPane.YES_OPTION)
	        System.exit(0);
	}
}

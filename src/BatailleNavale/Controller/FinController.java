package BatailleNavale.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BatailleNavale.Model.Modele;
import BatailleNavale.View.AccueilView;
import BatailleNavale.View.Fenetre;
import BatailleNavale.View.FinView;

public class FinController extends AbstractController implements ActionListener {

	private FinView view;
	private int choix;
	
	public FinController(FinView view, Modele modele){
		super(view.getFenetre(), modele);
		this.view=view;
	}
	
	 public void actionPerformed(ActionEvent arg0) 
	    {
	    	if(arg0.getSource() == view.getMenuPrincipal())
	    	{
	    		fenetre.changerVue(new AccueilView(fenetre, modele));
	    	}
	    	else if(arg0.getSource() == view.getBoutonQuitter())
	    	{
	    		choix = fenetre.afficherChoixMessage("Etes-vous sur de vouloir quitter Bataille Navale?", "Attention");
	            if(choix == JOptionPane.YES_OPTION)
	                System.exit(0);
	    	}
		}
	
}

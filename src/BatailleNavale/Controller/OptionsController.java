
package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.Checkbox;

import java.awt.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OptionsController extends AbstractController implements ActionListener,ItemListener
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
	
	public void itemStateChanged(ItemEvent event)
	{	
		/*if (view.getBoutonPortesAvions().getState() == true) 
		{	
          		System.out.println("Portes Avions selectionner " );
       		}*/	
		int state = event.getStateChange();
		if (event.getItemSelectable() == view.getBoutonPortesAvions() && state == ItemEvent.SELECTED)
		{
				System.out.println("Portes Avions selectionné " );
		}
		else if(event.getItemSelectable() == view.getBoutonSousMarin() && state == ItemEvent.SELECTED)
		{
				System.out.println("Sous Marins selectionné " );
		}
		else if(event.getItemSelectable() == view.getBoutonCuirassée() && state == ItemEvent.SELECTED)
		{
				System.out.println("Cuirassé furtif selectionné " );
		}
		else if(event.getItemSelectable() == view.getBoutonCuirassée2() && state == ItemEvent.SELECTED)
		{
				System.out.println("Cuirassé furtif 2 selectionné " );
		}
		else if(event.getItemSelectable() == view.getBoutonZodiac() && state == ItemEvent.SELECTED)
		{
				System.out.println("Zodiac selectionné " );
		}
		else if(event.getItemSelectable() == view.getBoutonFacile() && state == ItemEvent.SELECTED)
		{
				fenetre.afficherMessage("Ca va être easy !" , "Mode Facile" );
		}
		else if(event.getItemSelectable() == view.getBoutonMoyen() && state == ItemEvent.SELECTED)
		{
				fenetre.afficherMessage("Tu devrais t'en sortir ! " , "Mode Moyen");
		}
		else if(event.getItemSelectable() == view.getBoutonDifficile() && state == ItemEvent.SELECTED)
		{
				fenetre.afficherMessage("Ca va être chaud !","Mode Difficile" );
		}
      }	
		
	public void mouseReleased(MouseEvent event){}  
    	public void mousePressed(MouseEvent event){}
   	public void mouseClicked(MouseEvent event){}
}

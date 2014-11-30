package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import javax.swing.JPanel;
import java.awt.Color;

import java.awt.Font;

import java.awt.event.*;

public class AccueilController extends AbstractController implements MouseListener
{

	public AccueilController(MainView view, Modele modele)
	{
		super(view, modele);
	}

    public void mouseClicked(MouseEvent event) 
    {
    	AccueilView container = (AccueilView) view.getContainer();
    	if(event.getSource() == container.getBoutonJouer())
    	{
    		view.changerVue(new TypeView(view, modele));
    	}
    	else if(event.getSource() == container.getBoutonOptions())
    	{
    		view.changerVue(new OptionsView(view, modele));
    	}
    	else if(event.getSource() == container.getBoutonCredits())
    	{
    		view.changerVue(new CreditView(view, modele));
    	}
	}

    public void mouseEntered(MouseEvent event)
    {
    	AccueilView container = (AccueilView) view.getContainer();
    	if(event.getSource() == container.getBoutonJouer())
    	{
    		container.getBoutonJouer().setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 22));
			container.getBoutonJouer().setBounds(510,240,200,60);
    	}
    	else if(event.getSource() == container.getBoutonOptions())
    	{
    		container.getBoutonOptions().setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 22));
			container.getBoutonOptions().setBounds(510,330,200,60);
    	}
    	else if(event.getSource() == container.getBoutonCredits())
    	{
    		container.getBoutonCredits().setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 22));
			container.getBoutonCredits().setBounds(510,420,200,60);
    	}
    }

	public void mouseExited(MouseEvent event)
	{
		AccueilView container = (AccueilView) view.getContainer();
    	if(event.getSource() == container.getBoutonJouer())
    	{
    		container.getBoutonJouer().setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 14));
			container.getBoutonJouer().setBounds(500,240,200,60);
    	}
    	else if(event.getSource() == container.getBoutonOptions())
    	{
    		container.getBoutonOptions().setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 14));
			container.getBoutonOptions().setBounds(500, 330, 200, 60);
    	}
    	else if(event.getSource() == container.getBoutonCredits())
    	{
    		container.getBoutonCredits().setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 14));
			container.getBoutonCredits().setBounds(500, 420, 200, 60);
    	}
	}

	public void mousePressed(MouseEvent event){}
	public void mouseReleased(MouseEvent event){}     
}

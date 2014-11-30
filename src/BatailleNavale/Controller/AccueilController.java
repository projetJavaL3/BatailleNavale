package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

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
    		view.changerVue(new CreditsView(view, modele));
    	}
	}

    public void mouseEntered(MouseEvent event)
    {
    	((Bouton) event.getSource()).mouseIn();
    }

	public void mouseExited(MouseEvent event)
	{
		((Bouton) event.getSource()).mouseOut();
	}

	public void mousePressed(MouseEvent event){}
	public void mouseReleased(MouseEvent event){}     
}

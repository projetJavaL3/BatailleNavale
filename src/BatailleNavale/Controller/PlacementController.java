package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class PlacementController extends AbstractController implements MouseListener
{
    private PlacementView view;
    private boolean orientation = true;

	public PlacementController(PlacementView view, Modele modele)
	{
        super(view.getFenetre(), modele);
		this.view = view;
	}

    public void mouseEntered(MouseEvent event)
    {
        
    }

    public void mouseExited(MouseEvent event)
    {

    }

    public void mouseReleased(MouseEvent event){}  
    public void mousePressed(MouseEvent event){}
    public void mouseClicked(MouseEvent event){}
}

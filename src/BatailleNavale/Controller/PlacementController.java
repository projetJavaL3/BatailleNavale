package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.*;

public class PlacementController extends AbstractController implements ActionListener, MouseListener
{
    private PlacementView view;
    private boolean orientation = false;
    private int tailleBateau = 4;

    private Color couleur;

	public PlacementController(PlacementView view, Modele modele)
	{
        super(view.getFenetre(), modele);
		this.view = view;
	}

    public void actionPerformed(ActionEvent arg0)
    {
        if(arg0.getSource() == view.getBoutonOrientation())
        {
            orientation = !orientation;
        }
    }

    public Position getPosCase(MouseEvent event)
    {
        Grille grille = view.getGrille();
        for(int i=0; i<grille.getTaille(); i++)
            for(int j=0; j<grille.getTaille(); j++)
                if(event.getSource() == grille.getCase(i, j))
                    return new Position(i, j);
        return null;
    }

    public void mouseEntered(MouseEvent event)
    {
        Position pos = getPosCase(event);
        Grille grille = view.getGrille();
        for(int i=0; i<tailleBateau; i++)
        {   
            int x = pos.getCoord_X() + (orientation?i:0);
            int y = pos.getCoord_Y() + (orientation?0:i);

            if((grille.getTaille()) > x && (grille.getTaille() > y))     
            {
                JButton bouton = grille.getCase(x, y);
                couleur = bouton.getBackground();
                bouton.setBackground(new Color(220,220,220));
            }
        }
    }

    public void mouseExited(MouseEvent event)
    {
        Position pos = getPosCase(event);
        Grille grille = view.getGrille();

        for(int i=0; i<tailleBateau; i++)
        {   
            int x = pos.getCoord_X() + (orientation?i:0);
            int y = pos.getCoord_Y() + (orientation?0:i);

            if((grille.getTaille()) > x && (grille.getTaille() > y))     
            {
                JButton bouton = grille.getCase(x, y);
                bouton.setEnabled(true);
                bouton.setBackground(couleur);
            }
        }
    }

    public void mouseReleased(MouseEvent event){}  
    public void mousePressed(MouseEvent event){}
    public void mouseClicked(MouseEvent event){}
}

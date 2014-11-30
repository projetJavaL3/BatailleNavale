package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import javax.swing.JPanel;
import java.awt.Color;

import java.awt.Font;

import java.awt.event.*;

public class TypeController extends AbstractController implements MouseListener
{

	public TypeController(MainView view, Modele modele)
	{
		super(view, modele);
	}

    public void mouseClicked(MouseEvent event) 
    {
    	TypeView container = (TypeView) view.getContainer();
    	if(event.getSource() == container.getBoutonClassique())
    	{
    		// action à faire lorsque l'on clique sur le bouton classique
            view.afficherMessage("Vous allez commencer une partie classique !", "Début de partie");
    	}
    	else if(event.getSource() == container.getBoutonRadar())
    	{
    		// action à faire lorsque l'on clique sur le bouton radar
            view.afficherMessage("Vous allez commencer une partie radar !", "Début de partie");
    	}
    	else if(event.getSource() == container.getBoutonArtillerie())
    	{
    		// action à faire lorsque l'on clique sur le bouton artillerie
            view.afficherMessage("Vous allez commencer une partie artillerie !", "Début de partie");
    	}
        else if(event.getSource() == container.getBoutonAlerte())
        {
            // action à faire lorsque l'on clique sur le bouton alerte
            view.afficherMessage("Vous allez commencer une partie alerte !", "Début de partie");
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

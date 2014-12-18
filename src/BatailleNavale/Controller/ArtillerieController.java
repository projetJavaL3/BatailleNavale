package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;
import javax.swing.JButton;
import java.awt.Color;

public class ArtillerieController extends JeuController
{
	public ArtillerieController(JeuView view)
	{
		super(view);
	}

	public void mouseClicked(MouseEvent event)
	{
		Case gcase = (Case) event.getSource();
		gcase.setBackground(couleur);
 		view.getGrilleEnnemi().removeController(this);
 		loop(gcase.getJ());
 		key_pret = true;
	}

	public void keyTyped(KeyEvent e)
	{
		if(key_pret)
		{
			animation.stop();
			tirerSurEnnemi(posX, posY, fenetre.getModele().getJoueurCourant().getAdversairesEnVie()[view.getIndiceAdversaire()], false);   
			view.getGrilleEnnemi().addController(this);
			key_pret = false;
		}
	}
}
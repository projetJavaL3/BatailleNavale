package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class AlerteController extends JeuController
{
	public AlerteController(JeuView view)
	{
		super(view);
	}

	public void mouseClicked(MouseEvent event)
	{
		if(fenetre.getModele().getJoueurCourant() instanceof Humain)
		{
			Case gcase = (Case) event.getSource();
			gcase.deselectionner();
	 		view.getGrilleEnnemi().removeController(this);
	 		lancerAnimation(gcase.getJ());
	 		key_pret = true;
	 	}
	}

	public void keyTyped(KeyEvent e)
	{
		if(key_pret)
		{
			animation.stop();
			tirerSurEnnemi(posX, posY, fenetre.getModele().getJoueurCourant().getAdversairesEnVie()[view.getIndiceAdversaire()], true);   
			view.getGrilleEnnemi().addController(this);
			key_pret = false;
		}
	}
}
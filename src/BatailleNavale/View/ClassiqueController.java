package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class ClassiqueController extends JeuController
{

	public ClassiqueController(JeuView view)
	{
		super(view);
	}

	public void mouseClicked(MouseEvent event)
	{
		Case gcase = (Case) event.getSource();
		tirerSurEnnemi(gcase.getI(), gcase.getJ(), fenetre.getModele().getJoueurCourant().getAdversairesEnVie()[view.getIndiceAdversaire()], false);
	}
}
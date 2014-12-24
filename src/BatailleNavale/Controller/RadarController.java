package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class RadarController extends JeuController
{
	public RadarController(JeuView view)
	{
		super(view);
	}

	public void mouseClicked(MouseEvent event)
	{
		Case gcase = (Case) event.getSource();
		if(fenetre.getModele().getJoueurCourant() instanceof Humain)
			tirerSurEnnemi(gcase.getI(), gcase.getJ(), fenetre.getModele().getJoueurCourant().getAdversairesEnVie()[view.getIndiceAdversaire()], true);
	}
}
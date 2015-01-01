package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;

/**
 * Classe <code> RadarController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class RadarController extends JeuController
{
	/**
     * Construit un <code>RadarController</code> a partir d'une JeuView
     * @param view vue a controler
     */
	public RadarController(JeuView view)
	{
		super(view);
	}

	/**
	 *	Action a executer lors du click sur une case
	 */
	public void mouseClicked(MouseEvent event)
	{
		Case gcase = (Case) event.getSource();
		if(fenetre.getModele().getJoueurCourant() instanceof Humain)
			tirerSurEnnemi(gcase.getI(), gcase.getJ(), fenetre.getModele().getJoueurCourant().getAdversairesEnVie()[view.getIndiceAdversaire()], true);
	}
}
package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;

/**
 * Classe <code> ClassiqueController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class ClassiqueController extends JeuController
{

    /**
     * Construit un <code>ClassiqueController</code> a partir d'une JeuView
     * @param view vue a controler
     */
	public ClassiqueController(JeuView view)
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
			tirerSurEnnemi(gcase.getI(), gcase.getJ(), fenetre.getModele().getJoueurCourant().getAdversairesEnVie()[view.getIndiceAdversaire()], false);
	}
}
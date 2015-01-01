package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;
import javax.swing.JButton;
import java.awt.Color;

/**
 * Classe <code> ArtillerieController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class ArtillerieController extends JeuController
{
	/**
     * Construit un <code>ArtillerieController</code> a partir d'une JeuView
     * @param view vue a controler
     */
	public ArtillerieController(JeuView view)
	{
		super(view);
	}

	/**
	 *	Action a executer lors du click sur une case
	 */
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

	/**
	 *	Action a exectuer lors de l'appuie sur une touche
	 */
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
package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Controller.*;

public class PlacementView extends AbstractView 
{
	private PlacementController controleur;

	private Grille grille;

	public PlacementView(Fenetre fenetre, Modele modele)
	{
		super(fenetre, modele);
		this.controleur = new PlacementController(this, modele);
		initPanel();
	}

	public void initPanel()
	{
		this.setLayout(null);

		this.grille = new Grille(10, modele.getJoueurCourant(), true);
		this.grille.setBounds(67, 187, 316, 357);
		this.grille.addController(controleur);
		
		this.add(grille);
	}
}
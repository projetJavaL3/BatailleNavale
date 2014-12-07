package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.awt.event.*;

public class PlacementView extends AbstractView 
{
	private PlacementController controleur;

	private Grille grille;
	private Bouton bouton_orientation;

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
		this.grille.setBounds(67, 150, 316, 357);
		this.grille.addController(controleur);

		this.bouton_orientation = new Bouton("Changer orientation");
		this.bouton_orientation.setBounds(400, 200, 250, 70);
		this.bouton_orientation.addActionListener(controleur);

		this.add(grille);
		this.add(bouton_orientation);
	}

	public Grille getGrille()
	{
		return this.grille;
	}

	public Bouton getBoutonOrientation()
	{
		return this.bouton_orientation;
	}
}
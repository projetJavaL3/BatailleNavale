package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import javax.swing.JLabel;
import java.awt.event.*;

public class PlacementView extends AbstractView 
{
	private PlacementController controleur;

	private Grille grille;
	private Label label;
	private Bouton bouton_orientation = new Bouton("Changer orientation");

	public PlacementView()
	{
		super();
		this.controleur = new PlacementController(this);
	}

	public void initPanel()
	{
		this.removeAll();

		this.label = new Label("A vous de placer vos bateaux " + fenetre.getModele().getJoueurCourant().getNom() + "!", 16);
		this.label.setBounds(67, 50, 300, 50);

		this.grille = new Grille(fenetre.getModele().getOptions().getTailleGrille(), fenetre.getModele().getJoueurCourant(), true);
		this.grille.addController(controleur);
		this.grille.setBounds(67, 150, 320, 320);

		this.bouton_orientation.setBounds(100, 500, 250, 70);

		this.add(label);
		this.add(grille);
		this.add(bouton_orientation);

		controleur.control();
	}

	public void addListeners()
	{
		this.bouton_orientation.addActionListener(controleur);
	}

	public void removeListeners()
	{
		this.bouton_orientation.removeActionListener(controleur);		
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
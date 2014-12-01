package BatailleNavale.View;

import BatailleNavale.Controller.*;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;

import java.util.Observer;
import java.util.Observable;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;


public class JeuView extends AbstractView implements Observer
{		
	private JeuController controleur;

	private Joueur joueur_courant, ennemi;
	private Joueur[] adversaires;
	private Tir[] tirs;
	
	private JComboBox<Joueur> selection_adversaire = new JComboBox<Joueur>();
	private Grille grille_joueur;
	private Grille grille_ennemi;
	private JLabel lblMaFlotte, lblFlotteEnnemi, lblScore, lblAction;

	public JeuView(Fenetre fenetre, Modele modele)
	{	
		super(fenetre, modele);
		controleur = new ClassiqueController(this, modele);
		modele.addObserver(this);
		initPanel();
	}
	
	public void initPanel()
	{	
		this.removeAll();

		this.setLayout(null);

		joueur_courant = modele.getJoueurCourant();
		adversaires = joueur_courant.getAdversaires();

		selection_adversaire = new JComboBox<Joueur>(adversaires);
		selection_adversaire.setBounds(700, 155, 119, 24);

		ennemi = adversaires[selection_adversaire.getSelectedIndex()];
		tirs = joueur_courant.getTirsSurJoueur();

		grille_joueur = new Grille(10, joueur_courant, true);
		grille_joueur.setBounds(67, 187, 316, 357);
		
		grille_ennemi = new Grille(10, ennemi, false);
		grille_ennemi.addController(controleur);
		grille_ennemi.setBounds(504, 187, 316, 357);

		lblMaFlotte = new JLabel(joueur_courant.getNom());
		lblMaFlotte.setBounds(67, 160, 200, 15);
		
		lblFlotteEnnemi  = new JLabel("Flotte ennemi:");
		lblFlotteEnnemi.setBounds(504, 160, 142, 15);
		
		lblScore = new JLabel("Score: XXXpts");
		lblScore.setBounds(67, 556, 184, 15);
		
		lblAction = new JLabel("Selectionner un adversaire et une position sur son champs de bataille: ");
		lblAction.setBounds(67, 87, 614, 24);

		this.add(lblAction);
		this.add(lblMaFlotte);
		this.add(lblFlotteEnnemi);
		this.add(lblScore);

		this.add(selection_adversaire);

		this.add(grille_joueur);
		this.add(grille_ennemi);

		selection_adversaire.addItemListener(controleur);

		this.repaint();
	}

	public Grille getGrilleEnnemi()
	{
		return this.grille_ennemi;
	}

	public JComboBox getSelectionAdversaire()
	{
		return selection_adversaire;
	}

	public void update(Observable obs, Object o)
	{
		initPanel();
		lblMaFlotte.setText("*" + modele.getJoueurCourant().getNom() + "*");
		this.revalidate();
	}
}

package BatailleNavale.View;

import BatailleNavale.Controller.*;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;

import java.util.Observer;
import java.util.Observable;

import java.awt.Color;
import java.awt.GridLayout;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import java.awt.event.*;

public class JeuView extends AbstractView implements ItemListener, Observer
{		
	private JeuController controleur;

	private Joueur joueur_courant, ennemi;
	private Joueur[] adversaires;
	private Tir[] tirs;
	
	private int indice = 0;

	private JComboBox<Joueur> selection_adversaire = new JComboBox<Joueur>();
	private Grille grille_joueur;
	private Grille grille_ennemi;
	private JLabel lblMaFlotte, lblFlotteEnnemi, lblAction;

	public JeuView()
	{	
		super();

		switch(fenetre.getModele().getTypePartie())
		{
			case CLASSIQUE:
				controleur = new ClassiqueController(this);
				break;

			case RADAR:
				controleur = new RadarController(this);
				break;

			case ARTILLERIE:
				controleur = new ArtillerieController(this);
				break;

			case ALERTE:
				controleur = new AlerteController(this);
				break;
		}
	}
	
	public void initPanel()
	{	
		controleur.control();

		this.removeAll();
		
		joueur_courant = fenetre.getModele().getJoueurCourant();
		adversaires = joueur_courant.getAdversairesEnVie();

		selection_adversaire = new JComboBox<Joueur>(adversaires);
		selection_adversaire.setSelectedIndex(indice);
		selection_adversaire.setBounds(700, 155, 119, 24);

		ennemi = adversaires[selection_adversaire.getSelectedIndex()];
		tirs = joueur_courant.getTirsSurJoueur();

		grille_joueur = new Grille(fenetre.getModele().getOptions().getTailleGrille(), joueur_courant, (joueur_courant instanceof Humain));
		grille_joueur.setBounds(67, 187, 320, 320);
		
		grille_ennemi = new Grille(fenetre.getModele().getOptions().getTailleGrille(), ennemi, false);
		grille_ennemi.setBounds(504, 187, 320, 320);

		lblMaFlotte = new JLabel(joueur_courant.getNom() + " " + ((joueur_courant instanceof Ordinateur)?"[Ordinateur]":""));
		lblMaFlotte.setBounds(67, 160, 200, 15);
		
		lblFlotteEnnemi  = new JLabel(ennemi.getNom() + " " + ((ennemi instanceof Ordinateur)?"[Ordinateur]":""));
		lblFlotteEnnemi.setBounds(504, 160, 200, 15);
		
		lblAction = new JLabel("Selectionner un adversaire et une position sur son champs de bataille: ");
		lblAction.setBounds(67, 87, 614, 24);

		this.add(lblAction);
		this.add(lblMaFlotte);
		this.add(lblFlotteEnnemi);

		if(adversaires.length>1)
			this.add(selection_adversaire);

		this.add(grille_joueur);
		this.add(grille_ennemi);
	}

	public void addListeners()
	{
		grille_ennemi.addController(controleur);
		selection_adversaire.addItemListener(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(controleur);
	}

	public void removeListeners()
	{
		grille_ennemi.removeController(controleur);
		this.removeKeyListener(controleur);
		selection_adversaire.removeItemListener(this);
	}

	public Grille getGrilleEnnemi()
	{
		return this.grille_ennemi;
	}

	public int getIndiceAdversaire()
	{
		return this.indice;
	}

	public void setIndiceAdversaire(int indice)
	{
		this.indice = indice;
	}

	public void itemStateChanged(ItemEvent e)
	{
		int num = selection_adversaire.getSelectedIndex();
		setIndiceAdversaire(num);
		this.initPanel();
	}     

	public void update(Observable obs, Object o)
	{				
		initPanel();
		this.revalidate();
		this.repaint();
	}
}

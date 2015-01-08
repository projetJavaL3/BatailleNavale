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
import java.awt.Font;
import java.awt.Color;

import java.awt.event.*;

/** 
 * Classe <code> JeuView </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class JeuView extends AbstractView implements Observer
{		
	/**
	 *	Controleur de la vue
	 */
	private JeuController controleur;

	private Joueur joueur_courant, ennemi;
	private Joueur[] adversaires;
	private Tir[] tirs;
	
	private int indice = 0;
	private String type_partie = "";

	private JComboBox<Joueur> selection_adversaire = new JComboBox<Joueur>();
	private Grille grille_joueur;
	private Grille grille_ennemi;
	private JLabel lblMaFlotte, lblFlotteEnnemi, lblAction;

	/**
     * Construit une <code>JeuView</code> 
     */
	public JeuView()
	{	
		super();

		switch(fenetre.getModele().getTypePartie())
		{
			case CLASSIQUE:
				type_partie = "Classique";
				controleur = new ClassiqueController(this);
				break;

			case RADAR:
				type_partie = "Radar";
				controleur = new RadarController(this);
				break;

			case ARTILLERIE:
				type_partie = "Artillerie";
				controleur = new ArtillerieController(this);
				break;

			case ALERTE:
				type_partie = "Alerte";
				controleur = new AlerteController(this);
				break;
		}
	}

	/**
	 *	Initialise les composants de la vue
	 */
	public void initPanel()
	{	
		this.removeAll();

		controleur.control();
		
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
		
		lblAction = new JLabel("Partie : " + type_partie);
		lblAction.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 32));
		lblAction.setBounds(67, 87, 614, 24);

		this.add(lblAction);
		this.add(lblMaFlotte);
		this.add(lblFlotteEnnemi);

		if(adversaires.length>1)
			this.add(selection_adversaire);

		this.add(grille_joueur);
		this.add(grille_ennemi);
	}

	/**
	 *	Ajoute les Listeners a la vue
	 */
	public void addListeners()
	{
		this.requestFocusInWindow();
		grille_ennemi.addController(controleur);
		selection_adversaire.addItemListener(controleur);
		this.addKeyListener(controleur);
	}

	/** 
	 *	Supprime les Listeners a la vue
	 */
	public void removeListeners()
	{
		grille_ennemi.removeController(controleur);
		selection_adversaire.removeItemListener(controleur);
		this.removeKeyListener(controleur);
	}

	/**
	 *	@return grilleEnnemi
	 */
	public Grille getGrilleEnnemi()
	{
		return this.grille_ennemi;
	}

	/**
	 *	@return selectionAdversaire
	 */
	public JComboBox getSelection()
	{
		return this.selection_adversaire;
	}

	/**
	 *	@return indiceAdversaire
	 */
	public int getIndiceAdversaire()
	{
		return this.indice;
	}

	/**
	 *	Modifie l'indice de l'adversaire selectionne
	 */
	public void setIndiceAdversaire(int indice)
	{
		this.indice = indice;
	}

	/**
	 *	Mets a jour la vue
	 */
	public void update(Observable obs, Object o)
	{				
		initPanel();
		this.revalidate();
		this.repaint();
	}
}

package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.util.Observer;
import java.util.Observable;
import java.util.EventListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import java.awt.Checkbox;

import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;

import java.util.EventListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.GridLayout;

public class AideView extends AbstractView
{
	/**
	 *	Controleur de la vue
	 */
	private AideController controleur;

	private final JLabel titre = new JLabel("A Propose de la Bataille Navale ");

	private final Bouton b_classique = new Bouton("Mode Classique");
	private final Bouton b_radar = new Bouton("Mode Radar");
	private final Bouton b_artillerie = new Bouton("Mode Artillerie");
	private final Bouton b_alerte = new Bouton("Mode Alerte");
	private final Bouton b_retour = new Bouton("Retour");
	
	private final Panneau p_classique = new Panneau();
	private final Panneau p_radar = new Panneau();
	private final Panneau p_artillerie = new Panneau();
	private final Panneau p_alerte = new Panneau();
	
	public AideView()
	{	
		super();
		this.controleur = new AideController(this);
	}
	
	public void initPanel()
	{		
		this.removeAll();
		
		titre.setBounds(120, 30, 700, 50);
		titre.setForeground(Color.BLACK);
		titre.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 40));

		b_classique.setBounds(20, 120, 200, 80);
		b_radar.setBounds(20, 240, 200, 80);
		b_artillerie.setBounds(20, 380, 200, 80);
		b_alerte.setBounds(20, 500, 200, 80);
		b_retour.setBounds(780,550,100,50);
		
		p_classique.setBounds(280, 110, 500, 95);
		p_classique.add(new JLabel("<html>Mode Classique : <br/>"+
					"Chaque joueur essaye de deviner la position des navires ennemis et<br/>"+ 
					"tenter des les couler<html>")) ;
		p_classique.setVisible(false);

		
		p_radar.setBounds(280 ,240, 500, 95);
		p_radar.add(new JLabel("<html>Mode Radar : <br/>" +
				"Similaire au mode Classique, mais après chaque tir manqué,<br/>"+ 
				"une indication de la distance jusqu’à la cible la plus proche est donnée<html>"));
		p_radar.setVisible(false);

		p_artillerie.setBounds(280, 370, 500, 95);
		p_artillerie.add(new JLabel("<html>Mode Artillerie : <br/>"+
					"Similaire au mode Classique à l’exception du mode de sélection des coordonnées.Le joueur sélectionne d’abord la coordonnée verticale de la cible.Les numéros de la coordonnée horizontale de la cible apparaissent alors l’un après l’autre (en boucle). Le joueur doit alors valider la deuxième coordonnée au bon moment<html>"));
		p_artillerie.setVisible(false);

		p_alerte.setBounds(280, 500, 500, 95);
		p_alerte.add(new JLabel("<html>Mode Alerte : <br/>" +
					"Mélange des 3 modes précédents. Les 2 coordonnées de la cibles sont sélectionnées en mode artillerie et à chaque tir manqué, une indication de la <br/>" +
					"distance jusqu’à la cible la plus proche est donnée (mode radar).<html>"));       
		p_alerte.setVisible(false);              

		this.add(titre);
		this.add(b_classique);
		this.add(b_radar);
		this.add(b_artillerie);
		this.add(b_alerte);
		this.add(b_retour);
		this.add(p_classique);
		this.add(p_radar);
		this.add(p_artillerie);
		this.add(p_alerte);

		
		
	}

   	/**
	 *	Ajoute les Listeners a la vue
	 */	
	public void addListeners()
	{
		b_classique.addActionListener(controleur);
		b_radar.addActionListener(controleur);
		b_artillerie.addActionListener(controleur);
		b_alerte.addActionListener(controleur);
	}

    	/**
	 *	Supprime les Listeners a la vue
	 */	
	public void removeListeners()
	{
		b_classique.removeActionListener(controleur);
		b_radar.removeActionListener(controleur);
		b_artillerie.removeActionListener(controleur);
		b_alerte.removeActionListener(controleur);
	}
	
	/**
	 *	@return le Bouton b_retour
	 */
	public Bouton getBoutonRetour()
	{
		return b_retour;
	}
	
	/**
	 *	@return le Bouton b_classique
	 */
	public Bouton getBoutonClassique()
	{
		return b_classique;
	}
	
	/**
	 *	@return le Bouton b_radar
	 */
	public Bouton getBoutonRadar()
	{
		return b_radar;
	}
	
	/**
	 *	@return le Bouton b_artillerie
	 */
	public Bouton getBoutonArtillerie()
	{
		return b_artillerie;
	}
	
	/**
	 *	@return le Bouton b_alerte
	 */
	public Bouton getBoutonAlerte()
	{
		return b_alerte;
	}	
	
	/**
	 *	@return le Panneau p_classique
	 */
	public Panneau getPanneauClassique()
	{
		return p_classique;
	}
	
	/**
	 *	@return le Panneau b_radar
	 */
	public Panneau getPanneauRadar()
	{
		return p_radar;
	}
	
	/**
	 *	@return le Panneau p_artillerie
	 */
	public Panneau getPanneauArtillerie()
	{
		return p_artillerie;
	}
	
	/**
	 *	@return le Panneau p_alerte
	 */
	public Panneau getPanneauAlerte()
	{
		return p_alerte;
	}						
	



}

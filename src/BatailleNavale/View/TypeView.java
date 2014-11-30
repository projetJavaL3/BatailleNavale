package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Controller.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.Color;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TypeView extends AbstractView
{		
	private TypeController controleur;

	private final Bouton b_classique = new Bouton("Classique");
	private final Bouton b_radar = new Bouton("Radar");
	private final Bouton b_artillerie = new Bouton("Artillerie");
	private final Bouton b_alerte = new Bouton("Alerte");

	public TypeView(MainView view, Modele modele)
	{	
		super(view, modele);
		this.controleur = new TypeController(view, modele);
		initPanel();
	}
	
	public void initPanel()
	{	
		this.panel.setLayout(null);

		JLabel type_label = new JLabel("Sélectionner le type de partie:");
		type_label.setBounds(100,80,250,40);
		this.panel.add(type_label);

		//setBounds(Coordonée x, Coordonee y, Largeur du composant, Hauteur du composant)
		b_classique.setBounds(280, 130, 330, 65);
		b_radar.setBounds(280, 230, 330, 65);
		b_artillerie.setBounds(280, 330, 330, 65);
		b_alerte.setBounds(280, 430, 330, 65);
		
		b_classique.addMouseListener(controleur);
		b_radar.addMouseListener(controleur);
		b_artillerie.addMouseListener(controleur);
		b_alerte.addMouseListener(controleur);

		this.panel.add(b_classique);
		this.panel.add(b_radar);
		this.panel.add(b_artillerie);
		this.panel.add(b_alerte);	
		
	}

	public Bouton getBoutonClassique()
	{
		return b_classique;
	}

	public Bouton getBoutonRadar()
	{
		return b_radar;
	}
	
	public Bouton getBoutonArtillerie()
	{
		return b_artillerie;
	}

	public Bouton getBoutonAlerte()
	{
		return b_alerte;
	}

	public void update(Observable obs, Object o){}
}

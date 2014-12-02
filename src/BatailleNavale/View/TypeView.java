package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Controller.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JLabel;

public class TypeView extends AbstractView
{		
	private TypeController controleur;

	private final Bouton b_classique = new Bouton("Classique");
	private final Bouton b_radar = new Bouton("Radar");
	private final Bouton b_artillerie = new Bouton("Artillerie");
	private final Bouton b_alerte = new Bouton("Alerte");
	private final Bouton b_retour = new Bouton("Retour");
	private final JLabel type_label = new JLabel("Sélectionner le type de partie:");

	public TypeView(Fenetre fenetre, Modele modele)
	{	
		super(fenetre, modele);
		this.controleur = new TypeController(this, modele);
		initPanel();
	}
	
	public void initPanel()
	{	
		this.setLayout(null);

		type_label.setBounds(100,80,250,40);

		b_classique.setBounds(280, 130, 330, 65);
		b_radar.setBounds(280, 230, 330, 65);
		b_artillerie.setBounds(280, 330, 330, 65);
		b_alerte.setBounds(280, 430, 330, 65);
		b_retour.setBounds(10,560,100,50);
		
		b_classique.addActionListener(controleur);
		b_radar.addActionListener(controleur);
		b_artillerie.addActionListener(controleur);
		b_alerte.addActionListener(controleur);
		b_retour.addActionListener(controleur);

		this.add(type_label);
		this.add(b_classique);
		this.add(b_radar);
		this.add(b_artillerie);
		this.add(b_alerte);
		this.add(b_retour);	
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
	
	public Bouton getBoutonRetour()
	{
		return b_retour;
	}
}

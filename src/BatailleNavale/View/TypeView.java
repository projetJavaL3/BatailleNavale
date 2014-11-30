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
	private final JLabel type_label = new JLabel("Sélectionner le type de partie:");

	public TypeView(MainView view, Modele modele)
	{	
		super(view, modele);
		this.controleur = new TypeController(view, modele);
		initPanel();
	}
	
	public void initPanel()
	{	
		this.panel.setLayout(null);

		type_label.setBounds(100,80,250,40);

		b_classique.setBounds(280, 130, 330, 65);
		b_radar.setBounds(280, 230, 330, 65);
		b_artillerie.setBounds(280, 330, 330, 65);
		b_alerte.setBounds(280, 430, 330, 65);
		
		b_classique.addActionListener(controleur);
		b_radar.addActionListener(controleur);
		b_artillerie.addActionListener(controleur);
		b_alerte.addActionListener(controleur);

		this.panel.add(type_label);
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

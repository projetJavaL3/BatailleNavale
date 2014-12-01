package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;


public class AccueilView extends AbstractView
{
	private AccueilController controleur;

	private JLabel texte, texte2;
	private final Bouton b_jouer = new Bouton("Jouer");
	private final Bouton b_options = new Bouton("Options");
	private final Bouton b_credits = new Bouton("Crédits");

	public AccueilView(Fenetre fenetre, Modele modele)
	{
		super(fenetre, modele, "images/fond_accueil.jpg");
		this.controleur = new AccueilController(this, modele);
		initPanel();
	}

	public void initPanel()
	{
		this.setLayout(null);
		
		texte = new JLabel("Bataille");
		texte.setFont(new Font("Impact", Font.ITALIC , 100));
		texte.setForeground(new Color(50,50,50));
		texte.setBounds(120,60, 450, 80);

		texte2 = new JLabel("Navale");
		texte2.setFont(new Font("Impact", Font.ITALIC , 100)); //Impact
		texte2.setForeground(new Color(50,50,50));
		texte2.setBounds(450, 80, 400, 80);
		
		b_jouer.setBounds(500,280,200,60);
		b_options.setBounds(500, 360, 200, 60);
		b_credits.setBounds(500, 440, 200, 60);
		
		b_jouer.addActionListener(controleur);
		b_options.addActionListener(controleur);
		b_credits.addActionListener(controleur);

		this.add(texte);
		this.add(texte2);
		this.add(b_jouer);
		this.add(b_options);
		this.add(b_credits);
	}

	public Bouton getBoutonJouer()
	{
		return b_jouer;
	}

	public Bouton getBoutonCredits()
	{
		return b_credits;
	}

	public Bouton getBoutonOptions()
	{
		return b_options;
	}

}

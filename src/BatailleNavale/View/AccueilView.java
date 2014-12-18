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

	private final JLabel titre = new JLabel("Bataille");
	private final JLabel titre2 = new JLabel("Navale");
	private final Bouton b_jouer = new Bouton("Jouer");
	private final Bouton b_options = new Bouton("Options");
	private final Bouton b_credits = new Bouton("Crédits");

	public AccueilView()
	{
		super("images/fond_accueil.jpg");
		this.controleur = new AccueilController(this);
	}

	public void initPanel()
	{
		this.removeAll();
		
		titre.setFont(new Font("Impact", Font.ITALIC , 100));
		titre.setForeground(new Color(50,50,50));
		titre.setBounds(120,60, 450, 80);

		titre2.setFont(new Font("Impact", Font.ITALIC , 100));
		titre2.setForeground(new Color(50,50,50));
		titre2.setBounds(450, 80, 400, 80);
		
		b_jouer.setBounds(500,280,200,60);
		b_options.setBounds(500, 360, 200, 60);
		b_credits.setBounds(500, 440, 200, 60);

		this.add(titre);
		this.add(titre2);
		this.add(b_jouer);
		this.add(b_options);
		this.add(b_credits);
	}

	public void addListeners()
	{
		b_jouer.addActionListener(controleur);
		b_options.addActionListener(controleur);
		b_credits.addActionListener(controleur);
	}

	public void removeListeners()
	{
		b_jouer.removeActionListener(controleur);
		b_options.removeActionListener(controleur);
		b_credits.removeActionListener(controleur);
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

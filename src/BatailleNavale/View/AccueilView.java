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

	public AccueilView(MainView view, Modele modele)
	{
		super(view, modele, "images/fond_accueil.jpg");
		this.controleur = new AccueilController(view, modele);
		initPanel();
	}

	public void initPanel()
	{
		this.panel.setLayout(null);
		
		texte = new JLabel("Bataille");
		texte.setFont(new Font("Impact", Font.ITALIC, 50));
		texte.setForeground(new Color(50,50,50));
		texte.setBounds(280,60, 400, 70);

		texte2 = new JLabel("Navale");
		texte2.setFont(new Font("Impact", Font.ITALIC, 50));
		texte2.setForeground(new Color(50,50,50));
		texte2.setBounds(440, 80, 400, 70);
		
		b_jouer.setBounds(500,240,200,60);
		b_options.setBounds(500, 330, 200, 60);
		b_credits.setBounds(500, 420, 200, 60);
		
		b_jouer.addActionListener(controleur);
		b_options.addActionListener(controleur);
		b_credits.addActionListener(controleur);

		this.panel.add(texte);
		this.panel.add(texte2);
		this.panel.add(b_jouer);
		this.panel.add(b_options);
		this.panel.add(b_credits);
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

	public void update(Observable obs, Object o){}

}

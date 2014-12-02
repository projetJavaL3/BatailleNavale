package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Checkbox;
import java.awt.GridLayout;

import java.awt.Font;
import java.awt.Color;


public class OptionsView extends AbstractView
{
	private OptionsController controleur;	
	
	private final JLabel texte = new JLabel ("Sélectionner vos Bateaux : ");
	private final Checkbox check1 = new Checkbox("Porte-avions");
	private final Checkbox check2 = new Checkbox("Sous-marin nucléaire");
	private final Checkbox check3 = new Checkbox("Cuirassés furtifs");
	private final Checkbox check4 = new Checkbox("Cuirassés furtifs");
	private final Checkbox check5 = new Checkbox("Zodiac de troupes d’interventions");
	private final Bouton b_jouer = new Bouton("Jouer");
	private final Bouton b_retour = new Bouton("Retour");

	public OptionsView(Fenetre fenetre, Modele modele)
	{	
		super(fenetre, modele);
		this.controleur = new OptionsController(this, modele);
		initPanel();
	}
	
	public void initPanel()
	{		
		this.setLayout(null);
		
		texte.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 30));
		texte.setForeground(Color.white);
		texte.setBounds(240,10, 500, 50);
		
		check1.setBounds(200, 70, 500, 90);
		check1.setBackground(Color.black);
		check1.setForeground(Color.white);
		check1.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 18));
		
		check2.setBounds(200,160, 500, 90);
		check2.setBackground(Color.black);
		check2.setForeground(Color.white);
		check2.setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 18));
		
		check3.setBounds(200,250, 500, 100);
		check3.setBackground(Color.black);
		check3.setForeground(Color.white);
		check3.setFont(new Font("DejaVu Serif Condensed", Font.BOLD | Font.ITALIC, 18));
		
		check4.setBounds(200,350, 500, 100);
		check4.setBackground(Color.black);
		check4.setForeground(Color.white);
		check4.setFont(new Font("Liberation Sans", Font.BOLD | Font.ITALIC, 18));

		check5.setBounds(200,450, 500, 90);
		check5.setBackground(Color.black);
		check5.setForeground(Color.white);
		check5.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));

		b_retour.setBounds(10,560,100,50);
		b_jouer.setBounds(790,560,100,50);
		
		b_jouer.addActionListener(controleur);
		b_retour.addActionListener(controleur);
		
		this.add(texte);
		this.add(check1);
		this.add(check2);
		this.add(check3);
		this.add(check4);
		this.add(check5);
		this.add(b_jouer);
		this.add(b_retour);
	}

	public Bouton getBoutonJouer()
	{
		return b_jouer;
	}

	public Bouton getBoutonRetour()
	{
		return b_retour;
	}
}

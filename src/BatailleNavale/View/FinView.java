package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.*;
import javax.swing.JOptionPane;

/** 
 * Classe <code> FinView </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class FinView extends AbstractView
{	
	/**
	 *	Controleur de la vue
	 */
	private FinController controleur;
	
	private JLabel texte, texte1;

	private final Bouton b_menuprincipal = new Bouton("Menu Principal");
	private final Bouton b_boutonquitter = new Bouton("Quitter le jeu");

	/**
     * Construit une <code>FinView</code> 
     */
	public FinView()
	{
		super();
		this.controleur = new FinController(this);
	}

	/**
	 *	Initialise les composants de la vue
	 */
	public void initPanel()
	{
		this.removeAll();

		texte = new JLabel("Fin du jeu");
		texte.setFont(new Font("Impact", Font.ITALIC , 80));
		texte.setForeground(new Color(50,50,50));
		texte.setBounds(280,60, 450, 80);
		
		texte1 = new JLabel("Victoire : " + fenetre.getModele().getJoueurCourant().getNom());
		texte1.setFont(new Font("Impact", Font.PLAIN , 25));
		texte1.setForeground(new Color(50,50,50));
		texte1.setBounds(220,180, 450, 80);
		
		b_menuprincipal.setBounds(250,380,200,60);
		b_boutonquitter.setBounds(480,380,200,60);
		this.add(texte);
		this.add(texte1);
		this.add(b_menuprincipal);
		this.add(b_boutonquitter);
	}

	/**
	 *	Ajoute les Listeners a la vue
	 */
	public void addListeners()
	{
		b_menuprincipal.addActionListener(controleur);
		b_boutonquitter.addActionListener(controleur);
	}

	/** 
	 *	Supprime les Listeners a la vue
	 */
	public void removeListeners()
	{
		b_menuprincipal.removeActionListener(controleur);
		b_boutonquitter.removeActionListener(controleur);
	}

	/**
	 *	@return boutonMenuPrincipal
	 */
	public Bouton getMenuPrincipal()
	{
		return b_menuprincipal;
	}
	
	/**
	 *	@return boutonQuitter
	 */
	public Bouton getBoutonQuitter()
	{
		return b_boutonquitter;
	}
}

package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AccueilView extends AbstractView
{
	private AbstractController controleur;

	private JLabel texte;
	private JButton bouton1, bouton2, bouton3;

	public AccueilView(MainView view, Modele modele)
	{
		super(view, modele);
		this.controleur = new ClassiqueController(view, modele);
		initPanel();
	}

	public void initPanel()
	{
		texte = new JLabel("Bienvenue dans la Bataille Navale");
		
		bouton1 = new JButton("Commencer partie");
		bouton2 = new JButton("Options");
		bouton3 = new JButton("Crédits");

		this.panel.add(texte, BorderLayout.NORTH);
		this.panel.add(bouton1, BorderLayout.CENTER);
		this.panel.add(bouton2, BorderLayout.CENTER);
		this.panel.add(bouton3, BorderLayout.CENTER);
		
	}

	public void update(Observable obs, Object o){}

}
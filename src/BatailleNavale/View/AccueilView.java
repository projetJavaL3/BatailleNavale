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
	private JButton bouton;

	public AccueilView(MainView view, Modele modele)
	{
		super(view, modele);
		this.controleur = new ClassiqueController(view, modele);
		initPanel();
	}

	public void initPanel()
	{
		texte = new JLabel("Attente du début de la partie");
		
		bouton = new JButton("Déclencher partie");

		this.panel.add(texte, BorderLayout.CENTER);
		this.panel.add(bouton, BorderLayout.SOUTH);
		
	}

	public void update(Observable obs, Object o)
	{
		texte.setText("Partie lancé avec succes");
	}
}
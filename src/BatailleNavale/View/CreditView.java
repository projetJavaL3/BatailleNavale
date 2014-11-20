package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.util.Observable;

import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditView extends AbstractView
{
	public CreditView(MainView view, Modele modele)
	{	
		super(view, modele);
		initPanel();
	}
	
	public void initPanel()
	{
		
		JTextField text = new JTextField("Projet de Bataille Navale réalisé par 4 élèves de L3 à l'Université d'Evry" );
		this.panel.add(text);
	}

	public void update(Observable obs, Object o){}
}

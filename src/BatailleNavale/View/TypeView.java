package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Component;

import java.awt.Dimension;

public class TypeView extends AbstractView
{		
	public TypeView(MainView view, Modele modele)
	{	
		super(view, modele);
		initPanel();
	}
	
	public void initPanel()
	{	
		JButton b_classique = new JButton("Classique");
		JButton b_radar = new JButton("Radar");
		JButton b_artillerie = new JButton("Artillerie");
		JButton b_alerte = new JButton("Alerte");

		//On initialise notre Layout à null pour pouvoir appliquer la méthode setBounds()
		this.panel.setLayout(null);
		
		//setBounds(Coordonée x, Coordonee y, Largeur du composant, Hauteur du composant)
		b_classique.setBounds(10, 100, 160, 50);
		b_radar.setBounds(175, 100, 170, 50);
		b_artillerie.setBounds(350, 100, 170, 50);
		b_alerte.setBounds(525, 100, 165, 50);
		
		this.panel.add(b_classique);
		this.panel.add(b_radar);
		this.panel.add(b_artillerie);
		this.panel.add(b_alerte);
		
		JComboBox<String> combobox = new JComboBox<String>();

		combobox.addItem("Selectionner le nombre de Joueurs");
		for(int i = 0 ; i<=10 ; i++)
		{
			combobox.addItem("" + i);
		}
	
		combobox.setBounds(5,240,690,30);		
		
		JButton b_suivant = new JButton("Suivant");
		b_suivant.setBounds(300 , 470 , 100 , 40);
		
		this.panel.add(b_suivant);
		this.panel.add(combobox);

	}

	public void update(Observable obs, Object o){}
}

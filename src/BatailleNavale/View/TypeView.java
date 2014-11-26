package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.Color;

import java.awt.BorderLayout;
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
		JLabel type_label = new JLabel("Sélectionner le type de partie:");
		type_label.setBounds(5,60,250,40);
		type_label.setForeground(new Color(255,255,255));
		this.panel.add(type_label);

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
		
		JLabel combobox_label = new JLabel("Sélectionner le nombre de joueurs:");
		JComboBox<Integer> combobox = new JComboBox<Integer>();

		combobox_label.setBounds(5,200,250,40);
		combobox_label.setForeground(new Color(255,255,255));
		this.panel.add(combobox_label);
		for(int i = 2 ; i<=10 ; i++)
			combobox.addItem(i);
			
		combobox.setBounds(5,240,690,30);		
		
		JButton b_suivant = new JButton("Suivant");
		b_suivant.setBounds(300 , 470 , 100 , 40);
		
		this.panel.add(b_suivant);
		this.panel.add(combobox);

	}

	public void update(Observable obs, Object o){}
}

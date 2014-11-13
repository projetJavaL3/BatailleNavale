package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.Dimension;

public abstract class TypeView extends AbstractView
{
	public TypeView()
	{	
		super(view ,modele);
	}
	
	public void initPanel()
	{	
		JButton bouton1 = new JButton("Classique");
		JButton bouton2 = new JButton("Radar");
		JButton bouton3 = new JButton("Artillerie");
		JButton bouton4 = new JButton("Alerte");

		getPanel().setLayout(new BoxLayout(panneau, BoxLayout.Y_AXIS));
		
		getPanel().add(bouton1);
		getPanel().add(bouton2);
		getPanel().add(bouton3);
		getPanel().add(bouton4);
		getPanel().add(bouton5);
	}


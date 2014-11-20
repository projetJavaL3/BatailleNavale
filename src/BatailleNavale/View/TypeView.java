package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.Dimension;

public class TypeView extends AbstractView
{
	public TypeView(MainView view, Modele modele)
	{	
		super(view, modele);
	}
	
	public void initPanel()
	{	
		JButton bouton1 = new JButton("Classique");
		JButton bouton2 = new JButton("Radar");
		JButton bouton3 = new JButton("Artillerie");
		JButton bouton4 = new JButton("Alerte");

		this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		this.panel.add(bouton1);
		this.panel.add(bouton2);
		this.panel.add(bouton3);
		this.panel.add(bouton4);
	}

	public void update(Observable obs, Object o){}
}

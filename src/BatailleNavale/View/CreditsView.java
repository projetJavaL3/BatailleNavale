package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JTextField;

public class CreditsView extends AbstractView
{
	public CreditsView(MainView view, Modele modele)
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

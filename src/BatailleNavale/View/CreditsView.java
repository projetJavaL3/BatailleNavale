package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JTextField;

public class CreditsView extends AbstractView
{
	public CreditsView(Fenetre fenetre, Modele modele)
	{	
		super(fenetre, modele);
		initPanel();
	}
	
	public void initPanel()
	{		
		JTextField text = new JTextField("Projet de Bataille Navale réalisé par 4 élèves de L3 à l'Université d'Evry" );
		this.add(text);
	}
}

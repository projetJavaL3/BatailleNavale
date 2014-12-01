package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JTextField;

import java.awt.Checkbox;
import java.awt.GridLayout;


public class OptionsView extends AbstractView
{
	private final Checkbox check1 = new Checkbox("Porte-avions");
	private final Checkbox check2 = new Checkbox("Sous-marin nucléaire");
	private final Checkbox check3 = new Checkbox("Cuirassés furtifs");
	private final Checkbox check4 = new Checkbox("Cuirassés furtifs");
	private final Checkbox check5 = new Checkbox("Zodiac de troupes d’interventions");

	public OptionsView(Fenetre fenetre, Modele modele)
	{	
		super(fenetre, modele);
		initPanel();
	}
	
	public void initPanel()
	{		
		this.setLayout(new GridLayout(5, 1));
		
		this.add(check1);
		this.add(check2);
		this.add(check3);
		this.add(check4);
		this.add(check5);
	}
}

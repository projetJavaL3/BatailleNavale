package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.util.Observable;

import javax.swing.JTextField;

import java.awt.Checkbox;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsView extends AbstractView
{
	public OptionsView(MainView view, Modele modele)
	{	
		super(view, modele);
		initPanel();
	}
	
	public void initPanel()
	{
		Checkbox check1 = new Checkbox("Porte-avions");
		Checkbox check2 = new Checkbox("Sous-marin nucléaire");
		Checkbox check3 = new Checkbox("Cuirassés furtifs");
		Checkbox check4 = new Checkbox("Cuirassés furtifs");
		Checkbox check5 = new Checkbox("Zodiac de troupes d’interventions");
		
		this.panel.setLayout(new GridLayout(5, 1));
		
		this.panel.add(check1);
		this.panel.add(check2);
		this.panel.add(check3);
		this.panel.add(check4);
		this.panel.add(check5);
	}

	public void update(Observable obs, Object o){}
}

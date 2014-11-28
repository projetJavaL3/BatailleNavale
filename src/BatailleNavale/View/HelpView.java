package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.util.Observable;

import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpView extends AbstractView
{
	public HelpView(MainView view, Modele modele)
	{	
		super(view, modele);
		initPanel();
	}
	
	public void initPanel()
	{
		
		JTextField text1 = new JTextField("Si vos aveez besoin d'aide, demande a Yanis Boukari. \nEt si ya vraiment un probleme debrouille toi!!!" );
		this.panel.add(text1);
	}

	public void update(Observable obs, Object o){}
}

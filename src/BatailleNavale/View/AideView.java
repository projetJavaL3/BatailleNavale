package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JTextField;

public class AideView extends AbstractView
{
	public AideView(Fenetre fenetre, Modele modele)
	{	
		super(fenetre, modele);
		initPanel();
	}
	
	public void initPanel()
	{		
		JTextField text1 = new JTextField("Si vos avez besoin d'aide, demande a Yanis Boukari. \nEt si ya vraiment un probleme debrouille toi!!!" );
		this.add(text1);
	}
}

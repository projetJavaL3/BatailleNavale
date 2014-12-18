package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Controller.*;

import javax.swing.JLabel;

public class ModeReseauView extends AbstractView
{		

	private ModeReseauController controleur;

	private final JLabel type_label = new JLabel("Sélectionner le type de partie:");
	private final Bouton b_creer = new Bouton("Créer une partie");
	private final Bouton b_rejoindre = new Bouton("Rejoindre une partie");
	private final Bouton b_retour = new Bouton("Retour");

	public ModeReseauView()
	{	
		super();
		this.controleur = new ModeReseauController(this);
	}
	
	public void initPanel()
	{	
		this.removeAll();

		type_label.setBounds(100,80,250,40);

		b_creer.setBounds(280, 230, 330, 65);
		b_rejoindre.setBounds(280, 330, 330, 65);
		b_retour.setBounds(10,520,100,50);

		this.add(type_label);
		this.add(b_creer);
		this.add(b_rejoindre);
		this.add(b_retour);	
	}

	public void addListeners()
	{
		this.b_creer.addActionListener(controleur);
		this.b_rejoindre.addActionListener(controleur);
		this.b_retour.addActionListener(controleur);
	}

	public void removeListeners()
	{
		this.b_creer.removeActionListener(controleur);
		this.b_rejoindre.removeActionListener(controleur);
		this.b_retour.removeActionListener(controleur);
	}

	public Bouton getBoutonCreer()
	{
		return b_creer;
	}

	public Bouton getBoutonRejoindre()
	{
		return b_rejoindre;
	}

	public Bouton getBoutonRetour()
	{
		return b_retour;
	}
}
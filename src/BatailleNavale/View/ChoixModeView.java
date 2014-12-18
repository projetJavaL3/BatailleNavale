package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Controller.*;

import javax.swing.JLabel;

public class ChoixModeView extends AbstractView
{		
	private ChoixModeController controleur;

	private final JLabel type_label = new JLabel("Sélectionner le type de partie:");
	private final Bouton b_local = new Bouton("Jouer en local");
	private final Bouton b_reseau = new Bouton("Jouer en réseau");
	private final Bouton b_retour = new Bouton("Retour");

	public ChoixModeView()
	{	
		super();
		this.controleur = new ChoixModeController(this);
	}
	
	public void initPanel()
	{	
		this.removeAll();

		type_label.setBounds(100,80,250,40);

		b_local.setBounds(280, 230, 330, 65);
		b_reseau.setBounds(280, 330, 330, 65);
		b_retour.setBounds(10,520,100,50);

		this.add(type_label);
		this.add(b_local);
		this.add(b_reseau);
		this.add(b_retour);	
	}

	public void addListeners()
	{
		this.b_local.addActionListener(controleur);
		this.b_reseau.addActionListener(controleur);
		this.b_retour.addActionListener(controleur);
	}

	public void removeListeners()
	{
		this.b_local.removeActionListener(controleur);
		this.b_reseau.removeActionListener(controleur);
		this.b_retour.removeActionListener(controleur);		
	}

	public Bouton getBoutonLocal()
	{
		return b_local;
	}

	public Bouton getBoutonReseau()
	{
		return b_reseau;
	}

	public Bouton getBoutonRetour()
	{
		return b_retour;
	}
}

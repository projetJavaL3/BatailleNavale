package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Controller.*;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

/** 
 * Classe <code> ModeReseauView </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class ModeReseauView extends AbstractView
{		
	/**
	 *	Controleur de la vue
	 */
	private ModeReseauController controleur;

	private final JLabel type_label = new JLabel("Sélectionner le type de partie:");
	private final Bouton b_creer = new Bouton("Créer une partie");
	private final Bouton b_rejoindre = new Bouton("Rejoindre une partie");
	private final Bouton b_retour = new Bouton("Retour");

    /**
     *  Construit une <code>ModeReseauView</code>
     */
	public ModeReseauView()
	{	
		super();
		this.controleur = new ModeReseauController(this);
	}

	/**
	 *	Initialise les composants de la vue
	 */	
	public void initPanel()
	{	
		this.removeAll();

		type_label.setBounds(150, 50, 700, 50);
		type_label.setForeground(Color.BLACK);
		type_label.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 40));

		b_creer.setBounds(280, 230, 330, 65);
		b_rejoindre.setBounds(280, 330, 330, 65);
		b_retour.setBounds(10, 550, 100, 50);

		this.add(type_label);
		this.add(b_creer);
		this.add(b_rejoindre);
		this.add(b_retour);	
	}

	/**
	 *	Ajoute les Listeners a la vue
	 */
	public void addListeners()
	{
		this.b_creer.addActionListener(controleur);
		this.b_rejoindre.addActionListener(controleur);
		this.b_retour.addActionListener(controleur);
	}

	/** 
	 *	Supprime les Listeners a la vue
	 */
	public void removeListeners()
	{
		this.b_creer.removeActionListener(controleur);
		this.b_rejoindre.removeActionListener(controleur);
		this.b_retour.removeActionListener(controleur);
	}

	/**
	 *	@return boutonCreer
	 */
	public Bouton getBoutonCreer()
	{
		return b_creer;
	}

	/**
	 *	@return boutonRejoindre
	 */
	public Bouton getBoutonRejoindre()
	{
		return b_rejoindre;
	}

	/**
	 *	@return boutonRetour
	 */
	public Bouton getBoutonRetour()
	{
		return b_retour;
	}
}

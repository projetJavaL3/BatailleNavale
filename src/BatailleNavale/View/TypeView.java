package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Controller.*;

import javax.swing.JLabel;

/** 
 * Classe <code> TypeView </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class TypeView extends AbstractView
{		
	/**
	 *	Controleur de la vue
	 */
	private TypeController controleur;

	private final Bouton b_classique = new Bouton("Classique");
	private final Bouton b_radar = new Bouton("Radar");
	private final Bouton b_artillerie = new Bouton("Artillerie");
	private final Bouton b_alerte = new Bouton("Alerte");
	private final Bouton b_retour = new Bouton("Retour");
	private final JLabel type_label = new JLabel("Sélectionner le type de partie:");

    /**
     *  Construit une <code>TypeView</code>
     */
	public TypeView()
	{	
		super();
		this.controleur = new TypeController(this);
	}

	/**
	 *	Initialise les composants de la vue
	 */	
	public void initPanel()
	{	
		this.removeAll();

		type_label.setBounds(100,80,250,40);

		b_classique.setBounds(280, 130, 330, 65);
		b_radar.setBounds(280, 230, 330, 65);
		b_artillerie.setBounds(280, 330, 330, 65);
		b_alerte.setBounds(280, 430, 330, 65);
		b_retour.setBounds(10,520,100,50);

		this.add(type_label);
		this.add(b_classique);
		this.add(b_radar);
		this.add(b_artillerie);
		this.add(b_alerte);
		this.add(b_retour);	
	}

	/**
	 *	Ajoute les Listeners a la vue
	 */
	public void addListeners()
	{
		b_classique.addActionListener(controleur);
		b_radar.addActionListener(controleur);
		b_artillerie.addActionListener(controleur);
		b_alerte.addActionListener(controleur);
		b_retour.addActionListener(controleur);
	}

	/** 
	 *	Supprime les Listeners a la vue
	 */
	public void removeListeners()
	{
		b_classique.removeActionListener(controleur);
		b_radar.removeActionListener(controleur);
		b_artillerie.removeActionListener(controleur);
		b_alerte.removeActionListener(controleur);
		b_retour.removeActionListener(controleur);
	}

	/**
	 *	@return boutonClassique
	 */
	public Bouton getBoutonClassique()
	{
		return b_classique;
	}

	/**
	 *	@return boutonRadar
	 */
	public Bouton getBoutonRadar()
	{
		return b_radar;
	}

	/**
	 *	@return boutonArtillerie
	 */
	public Bouton getBoutonArtillerie()
	{
		return b_artillerie;
	}

	/**
	 *	@return boutonAlerte
	 */
	public Bouton getBoutonAlerte()
	{
		return b_alerte;
	}

	/**
	 *	@return boutonRetour
	 */
	public Bouton getBoutonRetour()
	{
		return b_retour;
	}
}

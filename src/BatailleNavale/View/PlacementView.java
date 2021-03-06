package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.event.*;

/** 
 * Classe <code> PlacementView </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class PlacementView extends AbstractView 
{
	/**
	 *	Controleur de la vue
	 */
	private PlacementController controleur;

	private Grille grille;
	private Label label;
	private Panneau pan_bateau = new Panneau();
	private final Bouton bouton_orientation = new Bouton("Changer orientation");
	private final Bouton bouton_auto = new Bouton("Placement auto");
	private final Bouton bouton_valider = new Bouton("Valider");
	private final Bouton bouton_annuler = new Bouton("Annuler");

    /**
     *  Construit une <code>PlacementView</code> 
     */
	public PlacementView()
	{
		super();
		this.controleur = new PlacementController(this);
	}

	/**
	 *	Initialise les composants de la vue
	 */
	public void initPanel()
	{
		this.removeAll();

		this.label = new Label("A vous de placer vos bateaux " + fenetre.getModele().getJoueurCourant().getNom() + "!", 16);
		this.label.setBounds(67, 50, 300, 50);

		this.grille = new Grille(fenetre.getModele().getOptions().getTailleGrille(), fenetre.getModele().getJoueurCourant(), true);
		this.grille.addController(controleur);
		this.grille.setBounds(67, 150, 320, 320);

		this.bouton_orientation.setBounds(200, 500, 250, 70);
		this.bouton_annuler.setBounds(650,250,125,70);
		this.bouton_valider.setBounds(650,350,125,70);
		this.bouton_auto.setBounds(500,500,250,70);
		this.pan_bateau.setBounds(450, 250, 150, 70);

		this.add(label);
		this.add(grille);
		this.add(pan_bateau);
		this.add(bouton_orientation);
		this.add(bouton_auto);
		this.add(bouton_valider);
		this.add(bouton_annuler);

		controleur.control();
	}

	public void afficherNomBateau(String nom)
	{
		pan_bateau.removeAll();
		pan_bateau.setLayout(new FlowLayout());
		pan_bateau.add(new JLabel(nom), "Center");
		pan_bateau.revalidate();
	}

	/**
	 *	Ajoute les Listeners a la vue
	 */
	public void addListeners()
	{
		this.bouton_orientation.addActionListener(controleur);
		this.bouton_auto.addActionListener(controleur);
		this.bouton_valider.addActionListener(controleur);
		this.bouton_annuler.addActionListener(controleur);
	}

	/** 
	 *	Supprime les Listeners a la vue
	 */
	public void removeListeners()
	{
		this.bouton_orientation.removeActionListener(controleur);
		this.bouton_auto.removeActionListener(controleur);	
		this.bouton_valider.removeActionListener(controleur);	
		this.bouton_annuler.removeActionListener(controleur);	
	}

	/**
	 *	@return grille
	 */
	public Grille getGrille()
	{
		return this.grille;
	}

	/**
	 *	@return boutonOrientation
	 */
	public Bouton getBoutonOrientation()
	{
		return this.bouton_orientation;
	}

	/**
	 *	@return boutonAuto
	 */
	public Bouton getBoutonAuto()
	{
		return this.bouton_auto;
	}

	/**
	 *	@return boutonValider
	 */
	public Bouton getBoutonValider()
	{
		return this.bouton_valider;
	}

	/**
	 *	@return boutonAnnuler
	 */
	public Bouton getBoutonAnnuler()
	{
		return this.bouton_annuler;
	}
}
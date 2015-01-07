package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.util.Observer;
import java.util.Observable;
import java.util.EventListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import java.awt.Checkbox;

import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;

import java.util.EventListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.GridLayout;

/** 
 * Classe <code> OptionsView </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class OptionsView extends AbstractView
{
	/**
	 *	Controleur de la vue
	 */
	private OptionsController controleur;
	
	private boolean[] coches = new boolean[5];

	private final Panneau pan = new Panneau();
	private final Panneau pan2 = new Panneau();
	private final Panneau pan3 = new Panneau();
	
	private final JLabel texte = new JLabel (" Sélectionner vos bateaux : ");
	private final JLabel texte2 = new JLabel (" Sélectionner la taille des grilles : ");
	private final JLabel texte3 = new JLabel (" Sélectionner le niveau de l'IA : ");
	private final JLabel texte_options = new JLabel ("Options : ");
	
	private final JRadioButton rb_facile = new JRadioButton("Facile :");
	private final JRadioButton rb_moyen = new JRadioButton("Moyen : ");
	private final JRadioButton rb_difficile = new JRadioButton("Difficile :");
	
	private final ButtonGroup bg = new ButtonGroup();
	private final Checkbox check1 = new Checkbox("Porte-avions", true);
	private final Checkbox check2 = new Checkbox("Sous-marin nucléaire", true);
	private final Checkbox check3 = new Checkbox("Cuirassé furtif", true);
	private final Checkbox check4 = new Checkbox("Cuirassé furtif", true);
	private final Checkbox check5 = new Checkbox("Zodiac de troupes d’interventions", true);
	
	private final JSpinner spinner = new JSpinner();
	
	private final Bouton b_jouer = new Bouton("Jouer");
	private final Bouton b_retour = new Bouton("Retour");	

    /**
     *  Construit une <code>OptionsView</code> 
     */
	public OptionsView()
	{	
		super();	
		this.controleur = new OptionsController(this);
	}

	/**
	 *	Initialise les composants de la vue
	 */	
	public void initPanel()
	{		
		this.removeAll();

		texte_options.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 30));
		texte_options.setBounds(340, 20, 500, 50);

		texte.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 15));
		texte2.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 15));
		texte3.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 15));

		spinner.setModel(new SpinnerNumberModel(fenetre.getModele().getOptions().getTailleGrille(), 10, 20 , 1));
		
		switch(fenetre.getModele().getOptions().getNiveauIA())
		{
			case FACILE:
				rb_facile.setSelected(true);
				break;
			case MOYEN:
				rb_moyen.setSelected(true);
				break;
			case DIFFICILE:
				rb_difficile.setSelected(true);
				break;
		}
		
		pan.setLayout(new GridLayout(6, 1));
		pan.setBounds(50, 110, 400, 410); 
		
		pan2.setLayout(null);
		pan2.setBounds(480, 110, 360, 150);
		
		pan3.setLayout(null);
		pan3.setBounds(480, 300, 360, 220);
		
		texte2.setBounds(10, 10, 400, 20);
		spinner.setBounds(150, 50, 60, 40);
		
		texte3.setBounds(10,10,300,20);
		rb_facile.setBounds(20,50,100,20);
		rb_facile.setBackground(null);
		rb_moyen.setBounds(20 , 100,100,20);
		rb_moyen.setBackground(null);
		rb_difficile.setBounds(20,150,100,20);
		rb_difficile.setBackground(null);
		
		b_retour.setBounds(10,520,100,50);
		b_jouer.setBounds(790,560,100,50);
		
		bg.add(rb_facile);
		bg.add(rb_moyen);
		bg.add(rb_difficile);

		check1.setFocusable(false);
		check2.setFocusable(false);
		check3.setFocusable(false);
		check4.setFocusable(false);
		check5.setFocusable(false);

		getCoches();

		check1.setState(coches[0]);
		check2.setState(coches[1]);
		check3.setState(coches[2]);
		check4.setState(coches[3]);
		check5.setState(coches[4]);

		pan.add(texte);
		pan.add(check1);
		pan.add(check2);
		pan.add(check3);
		pan.add(check4);
		pan.add(check5);

		pan2.add(texte2);
		pan2.add(spinner);
		
		pan3.add(texte3);
		pan3.add(rb_facile);
		pan3.add(rb_moyen);
		pan3.add(rb_difficile);
		
		this.add(texte_options);
		this.add(pan);
		this.add(pan2);
		this.add(pan3);
		this.add(b_jouer);
		this.add(b_retour);
	}
	
	/**
	 *	Ajoute les Listeners a la vue
	 */
	public void addListeners()
	{
		b_jouer.addActionListener(controleur);
		b_retour.addActionListener(controleur);
	}

	/** 
	 *	Supprime les Listeners a la vue
	 */
	public void removeListeners()
	{
		b_jouer.removeActionListener(controleur);
		b_retour.removeActionListener(controleur);
	}

	/**
	 *	@return boutonJouer
	 */
	public Bouton getBoutonJouer()
	{
		return b_jouer;
	}

	/**
	 *	@return boutonRetour
	 */
	public Bouton getBoutonRetour()
	{
		return b_retour;
	}
	
	/**
	 *	@return jrbFacile
	 */
	public JRadioButton getBoutonFacile()
	{
		return rb_facile;
	}

	/**
	 *	@return jrbMoyen
	 */
	public JRadioButton getBoutonMoyen()
	{
		return rb_moyen;
	}

	/**
	 *	@return jrbDifficile
	 */
	public JRadioButton getBoutonDifficile()
	{
		return rb_difficile;
	}

	/**
	 *	@return checkPorteAvion
	 */
	public Checkbox getBoutonPorteAvion()
	{
		return check1;
	}

	/**
	 *	@return checkSousMarin
	 */
	public Checkbox getBoutonSousMarin()
	{
		return check2;
	}

	/**
	 *	@return checkCuirasse
	 */
	public Checkbox getBoutonCuirasse()
	{
		return check3;
	}

	/**
	 *	@return checkCuirasse2
	 */
	public Checkbox getBoutonCuirasse2()
	{
		return check4;
	}
	
	/**
	 *	@return checkZodiac
	 */
	public Checkbox getBoutonZodiac()
	{
		return check5;
	}

	/**
	 *	@return spinnner
	 */
	public JSpinner getSpinner()
	{
		return spinner;
	}
	
	/**
	 *	Determine quels bateaux sont coches 
	 */
	public void getCoches()
	{
		Bateau[] bateaux = fenetre.getModele().getOptions().getFlotte();
		int cpt = 0;
		for(int i=0; i<5; i++)
			coches[i] = false;

		for(int i=0; i<bateaux.length; i++)
		{
			if(bateaux[i] instanceof Cuirasse && cpt==1)
				coches[3] = true;
			if(bateaux[i] instanceof Zodiac)
				coches[4] = true;
			if(bateaux[i] instanceof PorteAvion)
				coches[0] = true;
			if(bateaux[i] instanceof SousMarin)
				coches[1] = true;
			if(bateaux[i] instanceof Cuirasse && cpt==0)
			{
				cpt++;
				coches[2] = true;
			}
		}
	}
}

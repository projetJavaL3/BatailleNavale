package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.util.Observer;
import java.util.Observable;

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

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class OptionsView extends AbstractView
{
	private OptionsController controleur;
	private OptionsController listener ;
	
	private JPanel pan = new JPanel();
	private JPanel pan2 = new JPanel();
	private JPanel pan3 = new JPanel();
	
	private final JLabel texte = new JLabel ("Sélectionner vos Bateaux : ");
	private final JLabel texte2 = new JLabel ("Sélectionner la taille du Champs de Bataille : ");
	private final JLabel texte3 = new JLabel ("Sélectionner le niveau de l'IA : ");
	private final JLabel texte_options = new JLabel ("Options : ");
	
	private final JRadioButton rb_facile = new JRadioButton("Facile :");
	private final JRadioButton rb_moyen = new JRadioButton("Moyen : ");
	private final JRadioButton rb_difficile = new JRadioButton("Difficile :");
	
	private final Checkbox check1 = new Checkbox("Porte-avions" ,true);
	private final Checkbox check2 = new Checkbox("Sous-marin nucléaire" ,true);
	private final Checkbox check3 = new Checkbox("Cuirassés furtifs" ,true);
	private final Checkbox check4 = new Checkbox("Cuirassés furtifs",true);
	private final Checkbox check5 = new Checkbox("Zodiac de troupes d’interventions", true);
	
	private final Bouton b_jouer = new Bouton("Jouer");
	private final Bouton b_retour = new Bouton("Retour");

	private final JSpinner spinner = new JSpinner();
	
	private final ButtonGroup bg = new ButtonGroup();

	public OptionsView(Fenetre fenetre, Modele modele)
	{	
		super(fenetre, modele);
		this.controleur = new OptionsController(this, modele);
		initPanel();
	}
	
	public void initPanel()
	{		
		this.setLayout(null);
		
		//Texte Options
		texte_options.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 30));
		texte_options.setForeground(Color.white);
		texte_options.setBounds(340, 20, 500, 50);
		//Texte Selectionner vos Bateaux
		texte.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 15));
		texte.setForeground(Color.white);
		texte.setBounds(50,80, 500, 15);
		//Texte Selectionner la taille du Champs de Bataille
		texte2.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 15));
		texte2.setForeground(Color.white);
		texte2.setBounds(500,80, 500, 50);
		//Texte Sélectionner le niveau de l'IA
		texte3.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 15));
		texte3.setForeground(Color.white);
		//texte3.setBounds(500,280, 500, 50);
		
		check1.setBackground(Color.black); // new Color(0,0,0,125));
		check1.setForeground(Color.white);
		check1.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 18));
		
		check2.setBackground(Color.black);
		check2.setForeground(Color.white);
		check2.setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 18));
		
		check3.setBackground(Color.black);
		check3.setForeground(Color.white);
		check3.setFont(new Font("DejaVu Serif Condensed", Font.BOLD | Font.ITALIC, 18));
		
		check4.setBackground(Color.black);
		check4.setForeground(Color.white);
		check4.setFont(new Font("Liberation Sans", Font.BOLD | Font.ITALIC, 18));

		check5.setBackground(Color.black);
		check5.setForeground(Color.white);
		check5.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		
		spinner.setBackground(Color.black);
		spinner.setForeground(Color.green);
		spinner.setModel(new SpinnerNumberModel(10, 10, 20, 1));
		
		rb_facile.setBackground(Color.black);
		rb_facile.setForeground(Color.white);
		
		rb_moyen.setBackground(Color.black);
		rb_moyen.setForeground(Color.white);
		
		rb_difficile.setBackground(Color.black);
		rb_difficile.setForeground(Color.white);

		b_retour.setBounds(10,560,100,50);
		b_jouer.setBounds(790,560,100,50);
		
		pan.setLayout(null);
		pan.setBackground(Color.black);
		pan.setBounds(50, 110, 400, 410); 
		
		pan2.setLayout(null);
		pan2.setBackground(Color.black);
		pan2.setBounds(480,110,360,150);
		
		pan3.setLayout(null);
		pan3.setBackground(Color.black);
		pan3.setBounds(480,300,360,220);
		
		check1.setBounds(10, 20, 400, 90);
		check2.setBounds(10,80, 400, 90);
		check3.setBounds(10,150, 400, 90);
		check4.setBounds(10,240, 400, 90);
		check5.setBounds(10,310, 400, 80);
		texte.setBounds(10,10,300,10);
		
		spinner.setBounds(150, 50, 60, 40);
		texte2.setBounds(10,10,400,20);
		
		rb_facile.setBounds(20,50,100,20);
		rb_moyen.setBounds(20 , 100,100,20);
		rb_difficile.setBounds(20,150,100,20);
		texte3.setBounds(10,10,300,20);
		
		check1.setName("c1");
		b_jouer.addActionListener(controleur);
		b_retour.addActionListener(controleur);
		check1.addItemListener(listener);
		/*check1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int state = arg0.getStateChange();
			    if (state == ItemEvent.SELECTED)
					System.out.println("Porte Avion selectionné ");
			}
			});*/
		//check1.addItemListener(controleur);
		
		bg.add(rb_facile);
		bg.add(rb_moyen);
		bg.add(rb_difficile);
		
		pan.add(check1);
		pan.add(check2);
		pan.add(check3);
		pan.add(check4);
		pan.add(check5);
		pan.add(texte);
		pan2.add(spinner);
		pan2.add(texte2);
		pan3.add(rb_facile);
		pan3.add(rb_moyen);
		pan3.add(rb_difficile);
		pan3.add(texte3);
		
		this.add(texte_options);
		this.add(b_jouer);
		this.add(b_retour);
		this.add(pan);
		this.add(pan2);
		this.add(pan3);
	}

	public Bouton getBoutonJouer()
	{
		return b_jouer;
	}

	public Bouton getBoutonRetour()
	{
		return b_retour;
	}
	
	public JRadioButton getBoutonFacile()
	{
		return rb_facile;
	}
	
	public JRadioButton getBoutonMoyen()
	{
		return rb_moyen;
	}
	
	public JRadioButton getBoutonDifficile()
	{
		return rb_difficile;
	}
	
	public Checkbox getBoutonPortesAvions()
	{
		return check1;
	}
	
	public Checkbox getBoutonSousMarin()
	{
		return check2;
	}
	
	public Checkbox getBoutonCuirassée()
	{
		return check3;
	}
	
	public Checkbox getBoutonCuirassée2()
	{
		return check4;
	}
	
	public Checkbox getBoutonZodiac()
	{
		return check5;
	}
	
	public JSpinner getTailleChampDeBataille()
	{
		return spinner;
	}
}

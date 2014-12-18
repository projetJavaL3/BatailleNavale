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

public class AdresseView extends AbstractView
{
	private AdresseController controleur;

	private final Panneau pan = new Panneau();

	private final JLabel texte_options = new JLabel ("Options : ");
	
	private final JSpinner spinner1 = new JSpinner();
	private final JSpinner spinner2 = new JSpinner();
	private final JSpinner spinner3 = new JSpinner();
	private final JSpinner spinner4 = new JSpinner();

	private final Bouton b_valider = new Bouton("Valider");
	private final Bouton b_retour = new Bouton("Retour");	


	public AdresseView()
	{	
		super();
		this.controleur = new AdresseController(this);
	}
	
	public void initPanel()
	{		
		this.removeAll();

		texte_options.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 30));
		texte_options.setBounds(340, 20, 500, 50);

		spinner1.setModel(new SpinnerNumberModel(192, 0, 255 , 1));
		spinner2.setModel(new SpinnerNumberModel(168, 0, 255 , 1));
		spinner3.setModel(new SpinnerNumberModel(0, 0, 255 , 1));
		spinner4.setModel(new SpinnerNumberModel(0, 0, 255 , 1));
		
		pan.setLayout(new GridLayout(1, 4));
		pan.setBounds(350, 250, 300, 80);
		pan.add(spinner1);
		pan.add(spinner2);
		pan.add(spinner3);
		pan.add(spinner4);

		this.add(pan);

		b_retour.setBounds(10,520,100,50);
		b_valider.setBounds(790,520,100,50);

		this.add(b_valider);
		this.add(b_retour);
	}
	
	public void addListeners()
	{
		this.b_valider.addActionListener(controleur);
		this.b_retour.addActionListener(controleur);
	}

	public void removeListeners()
	{
		this.b_valider.removeActionListener(controleur);
		this.b_retour.removeActionListener(controleur);
	}

	public Bouton getBoutonValider()
	{
		return b_valider;
	}

	public Bouton getBoutonRetour()
	{
		return b_retour;
	}
	
	public JSpinner getSpinner1()
	{
		return spinner1;
	}
	
	public JSpinner getSpinner2()
	{
		return spinner2;
	}

	public JSpinner getSpinner3()
	{
		return spinner3;
	}
	
	public JSpinner getSpinner4()
	{
		return spinner4;
	}
}

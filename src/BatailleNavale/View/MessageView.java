package BatailleNavale.View;

import BatailleNavale.Controller.*;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;

import java.util.Observer;
import java.util.Observable;

import java.awt.Color;
import java.awt.GridLayout;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.event.*;

/** 
 * Classe <code> MessageView </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class MessageView extends AbstractView 
{	
	/**
	 *	Controleur de la vue
	 */
	private MessageController controleur;

	private Panneau panneau = new Panneau();
	private JButton icone = new JButton();
	private Bouton bouton = new Bouton("OK");
	private JLabel label;
	private boolean isGo, isPopup;
	private AbstractView vueSuivante;

    /**
     *  Construit une <code>MessageView</code> a partir d'un String
     *  @param message texte du message
     */
	public MessageView(String message)
	{	
		super();
		this.label = new JLabel(message);
		this.isGo = false;
		this.isPopup = false;
		this.controleur = new MessageController(this);
	}

    /**
     *  Construit une <code>MessageView</code> a partir d'un String, d'une Vue et d'un booleen
     *  @param message texte du message
     *	@param vueSuivante vue suivante apres l'affichage du message
     *	@param isPopup precise si le message est un popup ou non
     */
	public MessageView(String message, AbstractView vueSuivante, boolean isPopup)
	{
		this(message);
		this.isGo = true;
		this.isPopup = isPopup;
		this.vueSuivante = vueSuivante;
	}

	/**
	 *	Initialise les composants de la vue
	 */
	public void initPanel()
	{	
		this.removeAll();

		ImageIcon imageIcon = new ImageIcon(this.getClass().getClassLoader().getResource("images/load.gif"));
		
		this.icone.setDisabledIcon(imageIcon);
		this.icone.setIcon(imageIcon);
		this.icone.setBorder(null);
		this.icone.setBackground(null);
		this.icone.setEnabled(false);
		this.icone.setBounds(300, 50, 90, 100);

		this.bouton.setBounds(300, 75, 50, 50);

		this.label.setBounds(50, 25, 250, 150);
		this.panneau.setBounds(250, 200, 400, 200);
		this.panneau.setLayout(null);
		this.panneau.add(label);

		this.add(panneau);

		if(isPopup)
			fermer();
		else if(isGo)
			this.panneau.add(bouton);
		else
			this.panneau.add(icone);
	}

	/**
	 *	Ajoute les Listeners a la vue
	 */
	public void addListeners()
	{
		this.bouton.addActionListener(controleur);
	}

	/** 
	 *	Supprime les Listeners a la vue
	 */
	public void removeListeners()
	{
		this.bouton.removeActionListener(controleur);
	}

	/**
	 *	Ferme automatiquement le popup
	 */
	public void fermer()
	{
		Thread pop = new Thread() {
			public void run()
			{
				try
				{
					Thread.sleep(750);
					controleur.vueSuivante();
				} catch(Exception e) {}
			}
		};

		pop.start();		
	}

	/**
	 *	@return vueSuivante
	 */
	public AbstractView getVueSuivante()
	{
		return this.vueSuivante;
	}

	/**
	 *	@return bouton
	 */
	public Bouton getBouton()
	{
		return this.bouton;
	}
}

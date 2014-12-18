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

public class MessageView extends AbstractView 
{	
	private MessageController controleur;

	private Panneau panneau = new Panneau();
	private JButton icone = new JButton();
	private Bouton bouton = new Bouton("OK");
	private JLabel label;
	private boolean isGo, isPopup;
	private AbstractView go;

	public MessageView(String message)
	{	
		super();
		this.label = new JLabel(message);
		this.isGo = false;
		this.isPopup = false;
		this.controleur = new MessageController(this);
	}

	public MessageView(String message, AbstractView go, boolean isPopup)
	{
		this(message);
		this.isGo = true;
		this.isPopup = isPopup;
		this.go = go;
	}
	
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

	public void addListeners()
	{
		this.bouton.addActionListener(controleur);
	}

	public void removeListeners()
	{
		this.bouton.removeActionListener(controleur);
	}

	public void fermer()
	{
		Thread pop = new Thread() {
			public void run()
			{
				try
				{
					Thread.sleep(1000);
					controleur.go();
				} catch(Exception e) {}
			}
		};

		pop.start();		
	}

	public AbstractView getGo()
	{
		return this.go;
	}

	public Bouton getBouton()
	{
		return this.bouton;
	}
}

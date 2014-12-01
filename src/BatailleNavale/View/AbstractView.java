package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observable;

import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;


public abstract class AbstractView extends JPanel
{
	protected Modele modele;
	protected Fenetre fenetre;
	protected Image img;

	public AbstractView(Fenetre fenetre, Modele modele)
	{
		this(fenetre, modele, "images/fond_accueil.jpg");
	}
	
	public AbstractView(Fenetre fenetre, Modele modele, String image_de_fond)
	{		
		this.fenetre = fenetre;
		this.modele = modele;
		this.img = new ImageIcon(getClass().getClassLoader().getResource(image_de_fond)).getImage();
		this.setBorder(new LineBorder(new Color(20,20,20), 10, false));
	}

	public void paintComponent(Graphics g) 
	{
		g.drawImage(img, 0, 0, fenetre.getWidth(), fenetre.getHeight(), null);
	}

	public Fenetre getFenetre()
	{
		return this.fenetre;
	}

	protected abstract void initPanel();	
}
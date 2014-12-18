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
	protected static Fenetre fenetre;
	protected static Image image;

	public AbstractView()
	{
		this("images/fond_accueil.jpg");
	}
	
	public AbstractView(String image_de_fond)
	{		
		image = new ImageIcon(getClass().getClassLoader().getResource(image_de_fond)).getImage();
		this.setBorder(new LineBorder(new Color(20,20,20), 10, false));
		this.setLayout(null);
	}

	public void paintComponent(Graphics g) 
	{
		g.drawImage(image, 0, 0, fenetre.getWidth(), fenetre.getHeight(), null);
	}

	public static void setFenetre(Fenetre fen)
	{
		fenetre = fen;
	}

	public abstract void initPanel();	
	public abstract void addListeners();
	public abstract void removeListeners();
}
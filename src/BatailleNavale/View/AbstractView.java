package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observable;

import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

/** 
 * Classe <code> AbstractView </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public abstract class AbstractView extends JPanel
{
	/**
	 *	Fenetre de la vue
	 */
	protected static Fenetre fenetre;

	/**
	 *	Image de fond de la vue
	 */
	protected static Image image;

	/**
     * Construit une <code>AbstractView</code> 
     */
	public AbstractView()
	{
		this("images/fond_accueil.jpg");
	}
	
	/**
     * Construit une <code>AbstractView</code> a partir d'un String
     * @param image_de_fond chemin vers l'image de fond de la vue
     */
	public AbstractView(String image_de_fond)
	{		
		image = new ImageIcon(getClass().getClassLoader().getResource(image_de_fond)).getImage();
		this.setBorder(new LineBorder(new Color(20,20,20), 10, false));
		this.setLayout(null);
		this.setFocusable(true);
	}

	/**
	 *	Dessine l'image de fond 
	 */
	public void paintComponent(Graphics g) 
	{
		g.drawImage(image, 0, 0, fenetre.getWidth(), fenetre.getHeight(), null);
	}

	/**
	 *	Change la fenetre 
	 */
	public static void setFenetre(Fenetre fen)
	{
		fenetre = fen;
	}

	/**
	 *	Initialise les composants de la vue
	 */
	public abstract void initPanel();	

	/**
	 *	Ajoute les Listeners a la vue
	 */
	public abstract void addListeners();

	/** 
	 *	Supprime les Listeners a la vue
	 */
	public abstract void removeListeners();
}
package BatailleNavale.View;

import BatailleNavale.Model.Flotte.*;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.swing.ImageIcon;

/** 
 * Classe <code> Case </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Case extends JButton
{
	private final int i;
	private final int j;

	private final int taille_case; 

	private Image img;
 	private BufferedImage bi;
 	private Graphics g;

	/**
     * Construit une <code>Case</code> a partir d'une position et d'une taille
     *	@param i position i
     *	@param j position j
     *	@param taille_case taille de la case
     */
	public Case(int i, int j, int taille_case)
	{
		super();
		this.setBackground(new Color(112, 128, 144));
		this.setBorder(new LineBorder(new Color(50, 50, 50, 100), 1, false));
		this.setFocusable(false);
		this.setEnabled(false);
		this.i = i;
		this.j = j;

		this.taille_case = taille_case;

		this.bi = new BufferedImage(taille_case, taille_case, BufferedImage.TYPE_INT_ARGB);
		this.g = bi.createGraphics(); 
	}

	/**
	 *	@return I
	 */
	public int getI()
	{
		return this.i;
	}

	/**
	 *	@return J
	 */
	public int getJ()
	{
		return this.j;
	}

	/**
	 *	Affiche l'image dans la case
	 */
	private void afficherImage()
	{
		this.setDisabledIcon(new ImageIcon(bi));
		this.setIcon(new ImageIcon(bi));
	}

	/**
	 *	Affiche un bateau dans la case
	 */
	public void afficherBateau(Bateau b, boolean orientation, int partie)
	{
		img = getImageBateau(b, orientation);
						
		if(orientation)
			g.drawImage(img, -(partie*taille_case), 0, taille_case*b.getTaille(), taille_case, null);
		else
			g.drawImage(img, 0, -(partie*taille_case), taille_case, taille_case*b.getTaille(), null);   

		afficherImage();  
	}

	/**
	 *	Affiche du feu dans la case
	 */
	public void afficherFeu()
	{
		img = new ImageIcon(getClass().getClassLoader().getResource("images/feu.png")).getImage();
		g.drawImage(img, 0, -2, taille_case, taille_case, null);
		afficherImage();
	}

	/**
	 *	Affiche une cible dans la case
	 */
	public void afficherCible()
	{
		img = new ImageIcon(getClass().getClassLoader().getResource("images/cible.png")).getImage();
		g.drawImage(img, 0, 0, taille_case, taille_case, null);
		afficherImage();
	}

	/**
	 *	Affiche que le tir est rate dans la case
	 */
	public void afficherRate()
	{
		img = new ImageIcon(getClass().getClassLoader().getResource("images/rate.png")).getImage();
		g.drawImage(img, taille_case/4, taille_case/4, taille_case/2, taille_case/2, null);
		afficherImage();
	}

	/**
	 *	Selectionne la case
	 */
	public void selectionner()
	{
		this.setBackground(new Color(220,220,220));
	}

	/**
	 *	Deselectionne la case
	 */
	public void deselectionner()
	{
		this.setBackground(new Color(112, 128, 144));
	}
	
	/**
	 *	Remet la case normalement
	 */
	public void clean()
	{
		this.setBackground(new Color(112, 128, 144));
		this.setDisabledIcon(null);
		this.setIcon(null);
	}

	/**
	 *	Cherche l'image associe a un bateau et a son orientation
	 */
	public Image getImageBateau(Bateau bateau, boolean orientation)
	{
		String b_nom = "", path;

		if(bateau instanceof Cuirasse)
			b_nom = "cuirasse";
		else if(bateau instanceof PorteAvion)
			b_nom = "porte_avion";
		else if(bateau instanceof SousMarin)
			b_nom = "sous_marin";
		else if(bateau instanceof Zodiac)
			b_nom = "zodiac";

		path = "images/bateaux/" + b_nom + (orientation?"":"_r") + ".png";

		return new ImageIcon(getClass().getClassLoader().getResource(path)).getImage();	 
	}
}
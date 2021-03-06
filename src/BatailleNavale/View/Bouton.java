package BatailleNavale.View;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.*;
import java.applet.*;  
import java.io.*;  

/** 
 * Classe <code> Bouton </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Bouton extends JButton implements MouseListener
{
	private int inset = 5;
	private Color buttonColor = new Color(10, 10, 10);

 	/**
     * Construit un <code>Bouton</code> a oartir d'une chaine de caracteres
     *	@param nom texte du bouton
     */
	public Bouton(String nom)
	{
		super(nom);
		setContentAreaFilled(false);
		setForeground(Color.white);
		setBorder(null);
		setFocusPainted(false);
		addMouseListener(this);
	}
 
 	protected void paintComponent(Graphics g)
	{
 		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		int largeur = getWidth(); //vWidth
		int hauteur = getHeight(); //vHeight
		
		// Calcule la taille du Bouton
		int b_hauteur = hauteur - (inset * 2); //vButtonHeight
		int b_largeur = largeur - (inset * 2); //vButtonWidth
		int vArcSize  = b_hauteur;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Crée le dégrader pour la 1ere couche du Boutton
		Color vGradientStartColor =  buttonColor.darker().darker().darker();
		Color vGradientEndColor   = buttonColor.brighter().brighter().brighter();
		Paint paint               = new GradientPaint(0, inset, vGradientStartColor, 0, b_hauteur, vGradientEndColor, false);
		g2d.setPaint(paint);
		
		// Paint la première couche du Boutton
		g2d.fillRoundRect(inset, inset, b_largeur, b_hauteur, vArcSize, vArcSize);
		
		// Calcule la taille de la deuxième couche du Boutton
		int vHighlightInset        = 2;
		int vButtonHighlightHeight = b_hauteur - (vHighlightInset * 2);
		int vButtonHighlightWidth  = b_largeur - (vHighlightInset * 2);
		int vHighlightArcSize      = vButtonHighlightHeight;
		
		// Crée la peinture pour la deuxième couche du Boutton
		vGradientStartColor = Color.WHITE;
		vGradientEndColor   = buttonColor.brighter();
		paint               = new GradientPaint(0,inset+vHighlightInset,vGradientStartColor,0,inset+vHighlightInset+(vButtonHighlightHeight/2), buttonColor.brighter(), false);
		
		// Paint la deuxième couche du Boutton
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.8f));
		g2d.setPaint(paint);
		
		g2d.fillRoundRect(inset+vHighlightInset,inset+vHighlightInset,vButtonHighlightWidth,vButtonHighlightHeight,vHighlightArcSize,vHighlightArcSize);
		
		RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(inset, inset, b_largeur, b_hauteur, vArcSize, vArcSize);
		g2d.clip(r2d);		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));
		super.paintComponent(g);
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
	}


    public void mouseEntered(MouseEvent event)
    {
    	this.setLocation(getX()+10, getY());
		setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 22));
    }

	public void mouseExited(MouseEvent event)
	{
		this.setLocation(getX()-10, getY());
		setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 14));
	}

	public void mouseReleased(MouseEvent event){}  
	public void mousePressed(MouseEvent event){}
	public void mouseClicked(MouseEvent event){}
}

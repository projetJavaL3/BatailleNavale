package BatailleNavale.View;

import BatailleNavale.Model.*;

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

public class Bouton extends JButton 
{
 
	private int inset = 2;
	private Color buttonColor = Color.black.brighter().brighter().brighter().brighter();
 
 
	public Bouton(String Nom)
	{
		super(Nom);
		setContentAreaFilled(false);
		setForeground(Color.white);
		setBorder(null);
		setFocusPainted(false);
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
		int vArcSize = b_hauteur;
 
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
		// Crée le dégrader pour la 1ere couche du Boutton
		Color vGradientStartColor =  buttonColor.darker().darker().darker();
		Color vGradientEndColor = buttonColor.brighter().brighter().brighter();
		Paint paint = new GradientPaint(0, inset, vGradientStartColor, 0, b_hauteur, vGradientEndColor, false);
		g2d.setPaint(paint);
 
		// Paint la première couche du Boutton
		g2d.fillRoundRect(inset, inset, b_largeur, b_hauteur, vArcSize, vArcSize);
 
		// Calcule la taille de la deuxième couche du Boutton
		int vHighlightInset = 2;
		int vButtonHighlightHeight = b_hauteur - (vHighlightInset * 2);
		int vButtonHighlightWidth = b_largeur - (vHighlightInset * 2);
		int vHighlightArcSize = vButtonHighlightHeight;
 
		// Crée la peinture pour la deuxième couche du Boutton
		vGradientStartColor = Color.WHITE;
		vGradientEndColor = buttonColor.brighter();
		paint = new GradientPaint(0,inset+vHighlightInset,vGradientStartColor,0,inset+vHighlightInset+(vButtonHighlightHeight/2), buttonColor.brighter(), false);
 
		// Paint la deuxième couche du Boutton
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,.8f));
		g2d.setPaint(paint);
 
		g2d.fillRoundRect(inset+vHighlightInset,inset+vHighlightInset,vButtonHighlightWidth,vButtonHighlightHeight,vHighlightArcSize,vHighlightArcSize);
 
		RoundRectangle2D.Float r2d =new RoundRectangle2D.Float(inset, inset, b_largeur, b_hauteur, vArcSize, vArcSize);
		g2d.clip(r2d);		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));
		super.paintComponent(g);
 
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
	}

	public void mouseIn()
	{
		this.move(getX()+10, getY());
		setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 22));
	}

	public void mouseOut()
	{
		this.move(getX()-10, getY());
		setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 14));
	}
}

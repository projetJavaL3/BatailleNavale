package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observable;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

public abstract class AbstractView
{
	protected Modele modele;
	protected MainView fen;
	protected JPanel panel;

	public AbstractView(MainView view, Modele modele)
	{
		this.fen = view;
		this.modele = modele;
		this.panel = new ImagePanel("images/fond.jpg");
	}
	
	public AbstractView(MainView view, Modele modele, String image_de_fond)
	{
		this(view, modele);
		this.panel = new ImagePanel(image_de_fond);
	}

	protected JPanel getPanel()
	{
		return this.panel;
	}
	
	protected abstract void initPanel();	
	protected abstract void update(Observable obs, Object o);

	class ImagePanel extends JPanel
	{
		private Image img;
		
		public ImagePanel(String img) 
		{
			this.img = new ImageIcon(img).getImage();
			this.setBorder(new LineBorder(new Color(20,20,20), 10, false));
		}
		
		public void paintComponent(Graphics g) 
		{
			g.drawImage(img, 0, 0, fen.getWidth(), fen.getHeight(), null);
		}
	}
}
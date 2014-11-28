package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observable;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class AbstractView
{
	protected Modele modele;
	protected MainView fen;
	protected JPanel panel;

	public AbstractView(MainView view, Modele modele)
	{
		this.fen = view;
		this.modele = modele;
		this.panel = new ImagePanel(new ImageIcon("images/fond.jpg").getImage());
		this.panel.setPreferredSize(view.getSize());
		this.panel.setLayout(null);
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
			this(new ImageIcon(img).getImage());
		}
		
		public ImagePanel(Image img) 
		{
			this.img = img;
			Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			setLayout(null);
		}
		
		public void paintComponent(Graphics g) 
		{
			g.drawImage(img, 0,0, fen.getWidth(), fen.getHeight(),  null);
		}
	}
}
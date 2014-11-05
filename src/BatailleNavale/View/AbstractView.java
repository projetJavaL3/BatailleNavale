package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observable;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class AbstractView
{
	protected Modele modele;

	protected JPanel panel;

	public AbstractView(MainView view, Modele modele)
	{
		this.modele = modele;
		this.panel = new JPanel();
		this.panel.setPreferredSize(view.getSize());
		this.panel.setBackground(Color.white);	
	}
	
	protected JPanel getPanel()
	{
		return this.panel;
	}
	
	protected abstract void initPanel();	
	protected abstract void update(Observable obs, Object o);
}
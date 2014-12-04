package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import javax.swing.JButton;

import java.awt.event.*;
import java.applet.*;  
import java.io.*;  

public class Grille extends JPanel implements MouseListener
{
 
 	private int taille;
 	private JButton[][] cases;
 	private Joueur joueur;
 	private boolean afficher_bateaux;
 
 	private Color couleur;

 	public Grille(int taille, Joueur joueur, boolean afficher_bateaux)
	{
		this.taille = taille;
		this.cases = new JButton[taille][taille];
		this.joueur = joueur;
		this.afficher_bateaux = afficher_bateaux;
		this.setBackground(new Color(0, 0, 0, 0));
		this.setLayout(new GridLayout(taille, taille));
		initialiserCases();
	}
 
	public void initialiserCases()
	{
		removeAll();

		for(int i=0; i<taille; i++)
		{
			for(int j=0; j<taille; j++)
			{
				cases[i][j] = new JButton();
				cases[i][j].setBackground(new Color(112, 128, 144));
				cases[i][j].setBorder(new LineBorder(new Color(200,200,200), 1, false));
				cases[i][j].setFocusable(false);
				cases[i][j].setEnabled(false);

				if(joueur.dansTirsSurJoueur(new Position(i+1, j+1)))
					cases[i][j].setBackground(new Color(250, 150, 0));

				if(joueur.getChampDeBataille().existeBloc(new Position(i+1, j+1)))
					if(afficher_bateaux)
						if(joueur.getChampDeBataille().getBloc(new Position(i+1, j+1)).getEtatBloc() != EtatBloc.TOUCHE)
							cases[i][j].setBackground(new Color(0, 0, 0));
						else 
							cases[i][j].setBackground(new Color(255, 0, 0));
					else if(joueur.getChampDeBataille().getBloc(new Position(i+1, j+1)).getEtatBloc() == EtatBloc.TOUCHE)
						cases[i][j].setBackground(new Color(255, 0, 0));

				this.add(cases[i][j]);	
			}
		}

		repaint();
	}

	public void addController(JeuController controleur)
	{
		for (int i=0; i<taille; i++)
		{
			for(int j=0; j<taille; j++)
			{
				cases[i][j].addMouseListener(this);
				cases[i][j].addActionListener(controleur);
				cases[i][j].setEnabled(true);
			}			
		}
	}

	public void addController(PlacementController controleur)
	{
		for (int i=0; i<taille; i++)
		{
			for(int j=0; j<taille; j++)
			{
				cases[i][j].addMouseListener(controleur);
				cases[i][j].setEnabled(true);
			}			
		}
	}

	public JButton getCase(int i, int j)
	{
		return cases[i][j];
	}

	public int getTaille()
	{
		return taille;
	}

    public void mouseEntered(MouseEvent event)
    {
    	JButton bouton = (JButton) event.getSource();
    	couleur = bouton.getBackground();
		bouton.setBackground(new Color(220,220,220));
	}

	public void mouseExited(MouseEvent event)
	{
		JButton bouton = (JButton) event.getSource();
		bouton.setEnabled(true);
    	bouton.setBackground(couleur);
	}

	public void mouseReleased(MouseEvent event){}  
	public void mousePressed(MouseEvent event){}
	public void mouseClicked(MouseEvent event){}
}

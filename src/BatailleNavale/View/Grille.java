package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.*;
import java.applet.*;  
import java.io.*;  

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;

public class Grille extends JPanel
{
 	private int taille;
 	private Case[][] cases;
 	private int taille_case;
 	private Joueur joueur;
 	private boolean afficher_bateaux;
 
 	private Image img;
 	private BufferedImage bi; 
	private Graphics g;

 	public Grille(int taille, Joueur joueur, boolean afficher_bateaux)
	{
		this.taille_case = 320/taille;
		this.taille = taille;
		this.cases = new Case[taille][taille];
		this.joueur = joueur;
		this.afficher_bateaux = afficher_bateaux;
		this.setBackground(new Color(0, 0, 0));
		this.setLayout(new GridLayout(taille, taille, 0, 0));
		initialiserCases();
	}
 
	public void initialiserCases()
	{
		removeAll();

		int k = 0;
		Bateau[] bateaux = joueur.getBateaux();
		int[] indice_b = new int[bateaux.length];
		int[] indice_x = new int[bateaux.length];
		boolean[] orientation = new boolean[bateaux.length];
		for(int i=0; i<indice_b.length; i++)
		{
			indice_b[i] = 0;
			indice_x[i] = -1;
		}

		Bloc[] blocs = joueur.getChampDeBataille().getEmplacements();
		for(int i=0; i<blocs.length; i++)
		{
			for(int j=0; j<bateaux.length; j++)
			{
				if(blocs[i].getBateau() == bateaux[j])
				{
					if(indice_x[j] == -1)
						indice_x[j] = blocs[i].getPosition().getCoord_X();
					else
						orientation[j] = (indice_x[j] == blocs[i].getPosition().getCoord_X());
				}
			}
		}


		for(int i=0; i<taille; i++)
		{
			for(int j=0; j<taille; j++)
			{
				cases[i][j] = new Case(i+1, j+1, taille_case);
					
				if(joueur.dansTirsSurJoueur(new Position(i+1, j+1)) && !joueur.getChampDeBataille().existeBloc(new Position(i+1, j+1)))
				{	
					cases[i][j].afficherRate();
				}

				if(joueur.getChampDeBataille().existeBloc(new Position(i+1, j+1)))
					if(afficher_bateaux)
					{
						Bateau b = joueur.getChampDeBataille().getBloc(new Position(i+1, j+1)).getBateau();
						for(int l=0; l<bateaux.length; l++)
							if(bateaux[l] == b)
								k = l;

						cases[i][j].afficherBateau(b, orientation[k], indice_b[k]);
												
						indice_b[k]++;

						if(joueur.getChampDeBataille().getBloc(new Position(i+1, j+1)).getEtatBloc() == EtatBloc.TOUCHE)
						{
							cases[i][j].afficherFeu();
						}
					}

				else if(joueur.getChampDeBataille().getBloc(new Position(i+1, j+1)).getEtatBloc() == EtatBloc.TOUCHE)
				{
					cases[i][j].afficherFeu();
				}
			   
				this.add(cases[i][j]);	

				this.repaint();
			}
		}
	}

	public void addController(JeuController controleur)
	{
		for (int i=0; i<taille; i++)
		{
			for(int j=0; j<taille; j++)
			{
				cases[i][j].addMouseListener(controleur);
			}			
		}
	}

	public void removeController(JeuController controleur)
	{
		for (int i=0; i<taille; i++)
		{
			for(int j=0; j<taille; j++)
			{
				cases[i][j].removeMouseListener(controleur);
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
			}			
		}
	}

	public Case getCase(int i, int j)
	{
		return cases[i][j];
	}


	public void clearCase(int i, int j)
	{
		cases[i][j] = new Case(i+1, j+1, taille_case);
	}

	public int getTaille()
	{
		return taille;
	}
}

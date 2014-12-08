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

public class Grille extends JPanel implements MouseListener
{
 	private int taille;
 	private JButton[][] cases;
 	private int taille_case = 32;
 	private Joueur joueur;
 	private boolean afficher_bateaux;
 
 	private Image img;
 	private BufferedImage bi; 
	private Graphics g;

 	private Color couleur;

 	public Grille(int taille, Joueur joueur, boolean afficher_bateaux)
	{
		this.taille = taille;
		this.cases = new JButton[taille][taille];
		this.joueur = joueur;
		this.afficher_bateaux = afficher_bateaux;
		this.setBackground(new Color(0, 0, 0, 0));
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
				this.bi = new BufferedImage(taille_case, taille_case, BufferedImage.TYPE_INT_ARGB);
				this.g = bi.createGraphics(); 

				cases[i][j] = new JButton();
				cases[i][j].setBackground(new Color(112, 128, 144));
				cases[i][j].setBorder(new LineBorder(new Color(50, 50, 50, 100), 1, false));
				cases[i][j].setFocusable(false);
				cases[i][j].setEnabled(false);
					
				if(joueur.dansTirsSurJoueur(new Position(i+1, j+1)) && !joueur.getChampDeBataille().existeBloc(new Position(i+1, j+1)))
				{	
					img = new ImageIcon(getClass().getClassLoader().getResource("images/rate.png")).getImage();
					g.drawImage(img, taille_case/4, taille_case/4, taille_case/2, taille_case/2, null);
				}

				if(joueur.getChampDeBataille().existeBloc(new Position(i+1, j+1)))
					if(afficher_bateaux)
					{
						Bateau b = joueur.getChampDeBataille().getBloc(new Position(i+1, j+1)).getBateau();
						for(int l=0; l<bateaux.length; l++)
							if(bateaux[l] == b)
								k = l;

						img = getImageBateau(b, orientation[k]);
						
						if(orientation[k])
							g.drawImage(img, -(indice_b[k]*taille_case), 0, taille_case*b.getTaille(), taille_case, null);
						else
							g.drawImage(img, 0, -(indice_b[k]*taille_case), taille_case, taille_case*b.getTaille(), null);       
						
						indice_b[k]++;

						if(joueur.getChampDeBataille().getBloc(new Position(i+1, j+1)).getEtatBloc() == EtatBloc.TOUCHE)
						{
							img = new ImageIcon(getClass().getClassLoader().getResource("images/feu.png")).getImage();
							g.drawImage(img, 0, -5, taille_case, taille_case, null);
						}
					}

				else if(joueur.getChampDeBataille().getBloc(new Position(i+1, j+1)).getEtatBloc() == EtatBloc.TOUCHE)
				{
					img = new ImageIcon(getClass().getClassLoader().getResource("images/feu.png")).getImage();
					g.drawImage(img, 0, 0, taille_case, taille_case, null);
				}

				cases[i][j].setDisabledIcon(new ImageIcon(bi));
			    cases[i][j].setIcon(new ImageIcon(bi));
				
				this.add(cases[i][j]);	

				this.repaint();
			}
		}
	}

	public Image getImageBateau(Bateau bateau, boolean orientation)
	{
		String b_nom = new String();

		if(bateau.getNom().equals("Cuirasse"))
			b_nom = "cuirasse";
		else if(bateau.getNom().equals("Porte Avion"))
			b_nom = "porte_avion";
		else if(bateau.getNom().equals("Sous-Marin"))
			b_nom = "sous_marin";
		else if(bateau.getNom().equals("Zodiac"))
			b_nom = "zodiac";

		String path = "images/bateaux/" + b_nom + (orientation?"":"_r") + ".png";
		Image img = new ImageIcon(getClass().getClassLoader().getResource(path)).getImage();

		return img; 
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

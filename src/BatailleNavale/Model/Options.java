package BatailleNavale.Model;

import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;

import java.util.ArrayList;
import java.io.Serializable;

public class Options implements Serializable
{
	/**
	 *	Taille de la grille
	 */
	private int taille_grille;

	/**
	 *	Flotte de base des joueurs
	 */
	private ArrayList<Bateau> flotte;

	/**
	 *	Niveau de l'IA
	 */
	private Difficulte niveau_IA;
	
	/**
	 * 
	 */
	public Options()
	{
		this.taille_grille = 10;
		this.flotte = new ArrayList<Bateau>();
		this.flotte.add(new Zodiac());
		this.flotte.add(new Cuirasse());
		this.flotte.add(new Cuirasse());
		this.flotte.add(new SousMarin());
		this.flotte.add(new PorteAvion());
		this.niveau_IA = Difficulte.MOYEN;
	}
	
	public int getTailleGrille()
	{
		return this.taille_grille;
	}
	
	public void setTailleGrille( int taille)
	{	
		this.taille_grille = taille;
	}
	
	public Bateau[] getFlotte()
	{	
		return this.flotte.toArray(new Bateau[flotte.size()]);
	}
	
	public void setFlotte(Bateau[] bateaux)
	{
		ArrayList<Bateau> copie = new ArrayList<Bateau>();
		for(int i=0; i<bateaux.length; i++)
			copie.add(bateaux[i]);
		this.flotte = new ArrayList<Bateau>(copie);
	}
	
	public Difficulte getNiveauIA()
	{
		return this.niveau_IA;
	}
	
	public void setNiveauIA(Difficulte niveau)
	{
		this.niveau_IA = niveau;
	}
}

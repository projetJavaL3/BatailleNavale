package BatailleNavale.Model;

import BatailleNavale.View.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.util.ArrayList;

public class Options 
{
	/**
	 * 
	 */
	private int taille_grille;
	/**
	 * 
	 */
	private ArrayList<Bateau> flotte;
	/**
	 * 
	 */
	private int niveau_IA;
	
	/**
	 * 
	 */
	public Options()
	{
		this.taille_grille = 10;
		this.flotte = new ArrayList <Bateau>();
		this.flotte.add(new Cuirasse());
		this.flotte.add(new SousMarin());
		this.flotte.add(new Zodiac());
		this.flotte.add(new Zodiac());
		this.flotte.add(new PorteAvion());
		this.niveau_IA = 0 ;
	}
	
	public int getTailleGrille()
	{
		return taille_grille;
	}
	
	public void setTailleGrille( int taille)
	{	
		taille_grille = taille;
	}
	
	public Bateau[] getFlotte()
	{	
		return flotte.toArray(new Bateau[flotte.size()]);
	}
	
	public void setFlotte(Bateau[] bateaux)
	{
		
	}
	
	public int getNiveauIA()
	{
		return niveau_IA;
	}
	
	public void setNiveauIA( int niveau )
	{
		niveau_IA = niveau;
	}
	
	
}

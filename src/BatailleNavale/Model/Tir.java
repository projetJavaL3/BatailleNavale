package BatailleNavale.Model;

import BatailleNavale.Model.Joueur.*;

import java.util.Iterator;

/** 
 * Classe <code> Tir </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Tir
{
	/**
	 * Position du Tir
	 */
	private Position position;
	/**
	 * Joueur cible du Tir
	 */
	private Joueur joueur;

	/**
	 * Construit un Tir a partir d'une position et d'un joueur 
	 * @param p position du Tir
	 * @param j joueur cible du Tir
	 */
	public Tir(Position p, Joueur j)
	{
		this.position = new Position(p);
		this.joueur = j;
	}

	/** 
	 * Construit un tir a partir d'un autre.
	 * @param t
	 */
	public Tir (Tir t) 
	{
		this.position = new Position(t.position);
		this.joueur = t.joueur;
	}

	/**
	 * Accesseur de position.
	 * @return position
	 */
	public Position getPosition()
	{
		return this.position;
	}

	/**
	 * Accesseur de Joueur.
	 * @return joueur
	 */
	public Joueur getJoueur()
	{
		return this.joueur;
	}

	/**
	 * Modifieur de position
	 * @param p nouvelle position
	 */
	public void setPosition(Position p)
	{
		this.position = new Position(p);
	}

	/**
	 * Modifieur de joueur 
	 * @param j nouveau joueur 
	 */
	public void setJoueur(Joueur j)
	{
		this.joueur = j;
	}

	/**
	 * @return true si le tir touche un bateau 
	 */
	public boolean toucheBateau()
	{
		Bloc[] emplacements = this.joueur.getChampDeBataille().getEmplacements();
		for(int i=0; i<emplacements.length; i++)
			if(emplacements[i].getPosition().equals(this.position))
				if(emplacements[i].getEtatBloc() == Etat_bloc.PAS_TOUCHE)
					return true;

		return false;
	}

	public String toString()
	{
		return "Tir sur " + joueur.toString() + " à la position " + position.toString();
	}
}
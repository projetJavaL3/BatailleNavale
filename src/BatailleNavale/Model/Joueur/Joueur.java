package BatailleNavale.Model.Joueur;


import java.util.ArrayList;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;

/** 
 * Classe <code> Joueur </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public abstract class Joueur
{
	/**
	 * Champ de bataille du joueur.
	 */
	private ChampDeBataille champ_de_bataille;
	
	/**
	 * Ensemble des tirs joues par le joueur.
	 */
	private ArrayList<Tir> tirs_joues;
	
	/**
	 * Liste des bateaux du joueur
	 */
	private ArrayList<Bateau> flotte;

	
	public Joueur(ChampDeBataille c)
	{
		this.champ_de_bataille = new ChampDeBataille(c.getLongueur(), c.getHauteur());
		this.tirs_joues = new ArrayList<Tir>();
		this.flotte = new ArrayList<Bateau>();
	}
	
	/**
	 * Positionne un bateau sur le champ de bataille.
	 * @param bateau
	 * @param p
	 */
	public boolean positionneBateau (Bateau bateau, Placement p)
	{
		int orientation = p.getDirection()?1:-1;

		if(!champ_de_bataille.placementAutorise(p, bateau))
			return false;

		for(int i=0; i<bateau.getTaille(); i++)
		{
			Position pos = new Position(p.getPosition().getCoord_X() + orientation * i, p.getPosition().getCoord_Y() + (1-orientation) * i);
			champ_de_bataille.addBloc(new Bloc(bateau, pos));
		}

		return true;
	}
	
	/**
	 * Retire un bateau du champ de bataille.
	 * @param bateau
	 */
	public boolean retirerBateau(Bateau bateau)
	{
		Bloc[] emplacements = champ_de_bataille.getEmplacements();
		int bloc_enleves = 0;

		boolean retirer = false;

		for(int i=0; i<emplacements.length; i++)
		{
			if(emplacements[i].getBateau()==bateau)
			{
				champ_de_bataille.removeBloc(emplacements[i]);
				bloc_enleves++;
				retirer = true;
				if(bloc_enleves==bateau.getTaille())
					break;
			}
		}

		return retirer;
	}
	
	/**
	 * Fonction de Tir du joueur
	 */
	public abstract boolean tir (Tir t);
	
	/**
	 * Accesseur du champ de bataille
	 * @return le champ de bataille
	 */
	public ChampDeBataille getChampDeBataille()
	{
		return this.champ_de_bataille;
	}

	/**
	 * @return le nombre de tirs joues
	 */
	public int getNbTirsJoues()
	{
		return tirs_joues.size();
	}

	/**
	 * @return la liste des tirs joues
	 */
	public Tir[] getTirs()
	{
		return tirs_joues.toArray(new Tir[tirs_joues.size()]);
	}

	/**
	 * @return le nombre de bateaux du joueurs
	 */
	public int getNbBateaux()
	{
		return flotte.size();
	}

	/**
	 * @return la liste des bateaux du joueurs
	 */
	public Bateau getBateaux()
	{
		return flotte.toArray(new Bateau[flotte.size()]);
	}
	
	/**
	 * Liste des bateaux encore en jeu.
	 * @return les bateaux intacts ou touche
	 */
	public Bateau[] getBateauxNonCoules()
	{
		ArrayList<Bateau> intacts = new ArrayList<>();

		for(int i=0; i<flotte.size();i++)
			if(flotte.get(i).getEtatBateau() != Etat_bateau.COULE)
				intacts.add(flotte.get(i));

		return intacts.toArray(new Bateau[intacts.size()]);
	}
	
	/**
	 * 
	 * @return true si le joueur n'a plus que des bateaux coules, false sinon
	 */
	public boolean aPerdu()
	{
		return (getBateauxNonCoules().length == 0);
	}
	
}

package BatailleNavale.Model;

import BatailleNavale.Model.Flotte.*;

import java.util.ArrayList;
import java.util.Iterator;

/** 
 * Classe <code> ChampsDeBataille </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class ChampDeBataille 
{
	/**
	 * Longueur du Champ de Bataille
	 */
	private final int longueur;
	/**
	 * Hauteur du Champ de Bataille
	 */
	private final int hauteur;
	/**
	 * Liste d'emplacement de nos Bateau
	 */
	private ArrayList<Bloc> emplacement_bateau;

	/** 
	 * Constructeur d'une Instance de Champ de Bataille
	 * @param longueur la longueur du Champ de Bataille
	 * @param hauteur la hauteur du Champ de Bataille
	 */
	public ChampDeBataille (int longueur, int hauteur)
	{
		this.longueur = longueur;
		this.hauteur = hauteur;
		this.emplacement_bateau = new ArrayList<Bloc>();
	}

	/**
	 * Definit si le Placement d'un Bateau est autorisée ou non
	 * @param p placement
	 * @param b bateau
	 */
	public boolean placementAutorise (Placement p , Bateau b)
	{
		if(positionValide(p))
		{
			if(p.getDirection())
				return (p.getPosition().getCoord_X() + b.getTaille() -1 <= longueur);
			else
				return (p.getPosition().getCoord_Y() + b.getTaille() - 1 <= hauteur);
		}
		return false;
	}

	/**
	 * Definit si un Bloc existe ou non en fonction d'une position p 
	 * @param p position que l'on compare à la position du bloc
	 */
	public boolean existeBloc(Position p)
	{
		Iterator iterateur = emplacement_bateau.iterator();
		while (iterateur.hasNext())
		{
			Bloc b = (bloc) iterateur.next();
			if(b.getPosition().equals(p))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Retourne le Bloc correspondant à la position p
	 * @param p position du bloc à recuperer
	 */
	public Bloc getBloc (Position p)
	{
		Iterator iterateur = emplacement_bateau.iterator();
		while (iterateur.hasNext())
		{
			Bloc b = (bloc) iterateur.next();
			if(b.getPosition().equals(p))
				return b;
		}
		
		return null;
	}

	/**
 	 * Renvoie si la position est bien dans le champs de bataille
 	 * @param p position a tester
	 */
	public boolean positionValide(Position p)
	{
		return (p.getCoord_X() > 0 && p.getCoord_X() <= longueur && p.getCoord_Y() > 0  && p.getCoord_Y() <= hauteur);
	}
	
	/**
 	 * Renvoie la Longueur du Bateau
	 */
	public int getLongueur()
	{
		return this.longueur;
	}
	
	/**
 	 * Renvoie la Largeur du Bateau
	 */
	public int getHauteur()
	{
		return this.hauteur;
	}
	
	/**
	 * Renvoie un tableau des Blocs
	 */
	public Bloc[] getEmplacement()
	{
		return this.emplacement_bateau.toArray(new Bloc[emplacement_bateau.size()]);
	}

	/**
	 * Ajoute un Bloc
	 * @param bloc bloc à ajouter
	 */
	public boolean addBloc (Bloc bloc)
	{
		return this.emplacement_bateau.add(bloc);
	}
	
	/**
	 * Supprime un Bloc
	 * @param bloc bloc à ajouter
	 */
	public boolean removeBlocBateau(Bloc bloc)
	{
		return this.emplacement_bateau.remove(bloc);
	}
	
}



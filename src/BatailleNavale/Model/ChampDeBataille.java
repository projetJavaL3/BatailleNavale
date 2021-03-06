package BatailleNavale.Model;

import BatailleNavale.Model.Flotte.*;

import java.util.ArrayList;
import java.util.Iterator;

import java.io.Serializable;

/** 
 * Classe <code> ChampsDeBataille </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class ChampDeBataille implements Serializable
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
	private ArrayList<Bloc> emplacements_bateau;


	/** 
	 * Constructeur par defaut d'une Instance de Champ de Bataille
	 */
	public ChampDeBataille()
	{
		this(10, 10);
	}

	/** 
	 * Constructeur d'une Instance de Champ de Bataille
	 * @param longueur la longueur du Champ de Bataille
	 * @param hauteur la hauteur du Champ de Bataille
	 */
	public ChampDeBataille(int longueur, int hauteur)
	{
		this.longueur = longueur;
		this.hauteur = hauteur;
		this.emplacements_bateau = new ArrayList<Bloc>();
	}

	/**
	 * Definit si le Placement d'un Bateau est autorisée ou non
	 * @param p placement
	 * @param b bateau
	 */
	public boolean placementAutorise(Placement p , Bateau b)
	{
		int orientation = p.getDirection()?1:0;

		boolean valide = true;

		for(int i=0; i<b.getTaille(); i++)
		{
			Position posBloc = new Position(p.getPosition().getCoord_X() + orientation * i, p.getPosition().getCoord_Y() + (1-orientation) * i);
			if(!positionValide(posBloc) || existeBloc(posBloc))
				valide = false;
		}

		return valide;
	}

	/**
	 * Definit si un Bloc existe ou non en fonction d'une position p 
	 * @param p position que l'on compare à la position du bloc
	 */
	public boolean existeBloc(Position p)
	{
		Iterator iterateur = emplacements_bateau.iterator();
		while (iterateur.hasNext())
		{
			Bloc b = (Bloc) iterateur.next();
			if(b.getPosition().equals(p))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Retourne le Bloc correspondant à la position p
	 * @param p position du bloc à recuperer
	 */
	public Bloc getBloc(Position p)
	{
		Iterator iterateur = emplacements_bateau.iterator();
		while (iterateur.hasNext())
		{
			Bloc b = (Bloc) iterateur.next();
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
		return ((p.getCoord_X() > 0) && (p.getCoord_X() <= longueur) && (p.getCoord_Y() > 0)  && (p.getCoord_Y() <= hauteur));
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
	public Bloc[] getEmplacements()
	{
		return this.emplacements_bateau.toArray(new Bloc[emplacements_bateau.size()]);
	}
        
    /**
     * Renvoie les <code>Position</code> disponibles du champ de bataille 
     */
    public Position[] getEmplacementsLibres()
    {
        ArrayList<Position> positions_libres = new ArrayList<Position>();
        for(int i=0; i<longueur; i++)
        {
            for(int j=0; j<hauteur; j++ )
            {
                Position position_courante = new Position(i, j);
                if(!existeBloc(position_courante))
                    positions_libres.add(position_courante);
            }
        }
        
        return positions_libres.toArray(new Position[positions_libres.size()]);
    }

	/**
	 * Ajoute un Bloc
	 * @param bloc bloc à ajouter
	 */
	public boolean addBloc(Bloc bloc)
	{
		return this.emplacements_bateau.add(bloc);
	}
	
	/**
	 * Supprime un Bloc
	 * @param bloc bloc à ajouter
	 */
	public boolean removeBloc(Bloc bloc)
	{
		return this.emplacements_bateau.remove(bloc);
	}
	

	public String toString()
	{
		String s = "";
		for(int i=1; i<=hauteur; i++)
		{
			for(int j=1; j<=longueur; j++)
			{
				if(existeBloc(new Position(j,i)))
					if(getBloc(new Position(j,i)).getEtatBloc() == EtatBloc.TOUCHE)
						s += "O|";
					else 
						s += "X|";
				else 
					s += " |";
			}
			s += "\n";
		}
		return s;
	}
}



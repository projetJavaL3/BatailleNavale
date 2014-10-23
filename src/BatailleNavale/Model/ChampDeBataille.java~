package BatailleNavale.Model;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe ChampDeBataille 
 * @date 23/10/14
 * @author Boukari Yanis - Abderemane Brady
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
	public ChampDeBataille (int longueur, int largeur)
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
		if(p.getPosition().getCoord_X() > 0 && p.getPosition().getCoord_Y() > 0)
		{
			if(p.getPosition().getCoord_X() <= longueur && p.getPosition().getCoord_Y() <= hauteur)
			{
				if(p.getDirection())
					return (p.getPosition().getCoord_X() + b.getTaille() -1 <= longueur);
				else
					return (p.getPosition().getCoord_Y() + b.getTaille() - 1 <= hauteur);
			}
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



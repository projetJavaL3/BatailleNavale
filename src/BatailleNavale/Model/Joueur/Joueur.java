package BatailleNavale.Model.Joueur;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

/** 
 * Classe <code> Joueur </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Joueur implements Serializable
{
	/**
	 * Champ de bataille du joueur.
	 */
	protected ChampDeBataille champ_de_bataille;
	/**
	 * Ensemble des tirs joues par le joueur.
	 */
	protected ArrayList<Tir> tirs_joues;
	/**
	 * Liste des bateaux du joueur
	 */
	protected ArrayList<Bateau> flotte;
	/**
	 * Liste des bateaux places du joueur
	 */
	protected ArrayList<Bateau> bateaux_places;
	/**
	 * Liste des joueurs adversaires
	 */
	protected ArrayList<Joueur> adversaires;
	/**
	 * Nom du joueur
	 */
	protected final String nom;
	
	

	public Joueur(String nom)
	{
		this.champ_de_bataille = new ChampDeBataille();
		this.tirs_joues = new ArrayList<Tir>();
		this.flotte = new ArrayList<Bateau>();
		this.bateaux_places = new ArrayList<Bateau>();
		this.adversaires = new ArrayList<Joueur>();
		this.nom = nom;
	}

	public Joueur(String nom, int taille_grille)
	{
		this(nom);
		this.champ_de_bataille = new ChampDeBataille(taille_grille, taille_grille);
	}
	
	/**
     * Ajoute un bateau à la flotte du joueur.
     */
    public boolean ajouterBateau(Bateau b)
    {
    	return flotte.add(b);
    }

    /**
     * Supprime un bateau à la flotte du joueur.
     */
    public boolean supprimerBateau(Bateau b)
    {
    	retirerBateau(b);
    	return flotte.remove(b);
    }

	/**
	 * Place un bateau sur le champ de bataille.
	 * @param bateau
	 * @param placement
	 */
	public boolean placerBateau(Bateau bateau, Placement placement)
	{
		if(!flotte.contains(bateau) || bateaux_places.contains(bateau))
			return false;

		int orientation = placement.getDirection()?1:0;

		if(!champ_de_bataille.placementAutorise(placement, bateau))
			return false;

		for(int i=0; i<bateau.getTaille(); i++)
		{
			Position pos = new Position(placement.getPosition().getCoord_X() + orientation * i, placement.getPosition().getCoord_Y() + (1-orientation) * i);
			champ_de_bataille.addBloc(new Bloc(bateau, pos));
		}

		bateaux_places.add(bateau);

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

		bateaux_places.remove(bateau);

		return retirer;
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
	public Bateau[] getBateaux()
	{
		return flotte.toArray(new Bateau[flotte.size()]);
	}

	public Bateau[] getBateauxNonPlaces()
	{
		ArrayList<Bateau> bateaux_non_places = new ArrayList<Bateau>(flotte);
		
		for(int i=0; i<bateaux_places.size(); i++)
			bateaux_non_places.remove(bateaux_places.get(i));
		

		return bateaux_non_places.toArray(new Bateau[bateaux_non_places.size()]);
	}
	
	/**
	 * Liste des bateaux encore en jeu.
	 * @return les bateaux intacts ou touche
	 */
	public Bateau[] getBateauxNonCoules()
	{
		ArrayList<Bateau> intacts = new ArrayList<>();

		for(int i=0; i<flotte.size();i++)
			if(flotte.get(i).getEtatBateau() != EtatBateau.COULE)
				intacts.add(flotte.get(i));

		return intacts.toArray(new Bateau[intacts.size()]);
	}
	
	/**
	 * Renvoie true si tous les bateaux de la flotte ont ete places
	 */
	public boolean bateauxPlaces()
	{
		return flotte.equals(bateaux_places);
	}

    /**
     * Calcul un placement aleatoire disponible sur le champ de bataille pour un bateau donné.
     */
    public Placement placementAleatoire(Bateau bateau) 
    {
    	Position[] positions_libres = champ_de_bataille.getEmplacementsLibres();
    	Placement placement_alea;
    	Random r = new Random();

        //Melange alétoire des positions libres
    	for(int i=0; i<positions_libres.length; i++)
    	{
    		int k = r.nextInt(positions_libres.length-1);
    		Position tmp = positions_libres[i];
    		positions_libres[i] = positions_libres[k];
    		positions_libres[k] = tmp;
    	}

        //Recherche d'un placement libre
    	for(int i=0; i<positions_libres.length; i++)
    	{
    		int k = r.nextInt(2);
    		placement_alea = new Placement(positions_libres[i], k==1);
    		if(champ_de_bataille.placementAutorise(placement_alea, bateau))
    		{
    			return placement_alea;
    		}
    		placement_alea = new Placement(positions_libres[i], k!=1);
    		if(champ_de_bataille.placementAutorise(placement_alea, bateau))
    		{
    			return placement_alea;
    		}
    	}

    	return null;
    }
     
        
    /**
     * Place tous les bateaux du joueur aléatoirement.
    */
    public void placementAleatoireFlotte()
    {
    	Iterator iterateur = flotte.iterator();
    	while(iterateur.hasNext())
    	{
    		Bateau b = (Bateau) iterateur.next();
    		Placement placement_courant = placementAleatoire( b );
    		placerBateau(b, placement_courant);
    	}
    }

	/**
	 * Fonction de Tir du joueur
	 */
	public boolean tir(Tir t)
	{
		tirs_joues.add(t);
		ChampDeBataille cible = t.getJoueur().getChampDeBataille();
		Position pos = t.getPosition();

		if (cible.existeBloc(pos))
		{
			Bloc bloc = cible.getBloc(pos);
			if (bloc.getEtatBloc() == EtatBloc.PAS_TOUCHE)
			{
				bloc.setEtatBloc(EtatBloc.TOUCHE);
				bloc.getBateau().retirerPointDeVie();
				return true;
			}
		}

		return false;
	}
	
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
	 * @return la liste des tirs effectues sur le joueur
	 */
	public Tir[] getTirsSurJoueur()
	{
		ArrayList<Tir> liste_tirs = new ArrayList<Tir>();
		for(int i=0; i<adversaires.size(); i++)
		{
				Tir[] tirs = adversaires.get(i).getTirs();
				for(int j=0; j<tirs.length; j++)
					if(tirs[j].getJoueur() == this)
						liste_tirs.add(tirs[j]);
		}

		return liste_tirs.toArray(new Tir[liste_tirs.size()]);
	}

	/**
	 * @return true si un tir a ete effectue sur le joueur a la position p
	 */
	public boolean dansTirsSurJoueur(Position p)
	{
		Tir[] tirs = getTirsSurJoueur();
		for(int i=0; i<tirs.length; i++)
			if(tirs[i].getPosition().equals(p))
				return true;
		return false;
	}

	public int plusPetiteDistance(Tir t)
	{
		int petite = 9999;
		Bloc[] blocs = this.champ_de_bataille.getEmplacements();
		for(int i=0; i<blocs.length; i++)
		{
			if(blocs[i].getEtatBloc() == EtatBloc.PAS_TOUCHE)
			{
				int temp = t.getPosition().distance(blocs[i].getPosition());
				if(petite > temp)
					petite = temp;
			}
		}

		return petite;
	}

	/**
	 * @return true si le joueur n'a plus que des bateaux coules, false sinon
	 */
	public boolean aPerdu()
	{
		return (getBateauxNonCoules().length == 0);
	}

	/**
	 * @return le nombre d'adversaires du joueur
	 */
	public int getNbAdversaires()
	{
		return this.adversaires.size();
	}

	/**
	 * Ajoute un joueur dans la liste des adversaires
	 * @param j le joueur a ajouter
	 */
	public boolean ajouterAdversaire(Joueur j)
	{
		return this.adversaires.add(j);
	}
	
	/**
	 * Retire un joueur de la liste des adversaires
	 * @param j le joueur a retirer
	 */
	public boolean retirerAdversaire(Joueur j)
	{
		return this.adversaires.remove(j);
	}

	/**
	 * Remet la liste des adversaires a zero
	 */
	public void reinitialiserListeAdversaires()
	{
		this.adversaires = new ArrayList<Joueur>();
	}

	/**
	 * @return la liste des adversaires du joueur
	 */
	public Joueur[] getAdversaires()
	{
		return this.adversaires.toArray(new Joueur[adversaires.size()]);
	}
	
	/**
	 * @return la liste des adversaires toujours en jeu du joueur
	 */
	public Joueur[] getAdversairesEnVie()
	{
		ArrayList<Joueur> liste_adversaires = new ArrayList<Joueur>();
		for(int i=0; i<adversaires.size(); i++)
			if(!adversaires.get(i).aPerdu())
				liste_adversaires.add(adversaires.get(i));
		return liste_adversaires.toArray(new Joueur[liste_adversaires.size()]);
	}

	/**
	 * @return nom du joueur
	 */
	public String getNom()
	{
		return this.nom;
	}

	/**
	 * toString de Joueur 
	 */
	public String toString()
	{
		return "[" + nom + "]";
	}
}

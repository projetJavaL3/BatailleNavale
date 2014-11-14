package BatailleNavale.Model.Joueur;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

/** 
 * Classe <code> Joueur </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Joueur
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
	 * Liste des joueurs adversaires
	 */
	protected ArrayList<Joueur> adversaires;
	
	/**
	 * Nom du joueur
	 */
	protected String nom;

	
	public Joueur(String nom, Options options)
	{
		this.champ_de_bataille = new ChampDeBataille(options.getLongueur(), options.getHauteur());
		this.tirs_joues = new ArrayList<Tir>();
		this.flotte = new ArrayList<Bateau>();
		this.adversaires = new ArrayList<Joueur>();
		this.nom = nom;
	}
	
	/**
	 * Place un bateau sur le champ de bataille.
	 * @param bateau
	 * @param placement
	 */
	public boolean placerBateau(Bateau bateau, Placement placement)
	{
		int orientation = placement.getDirection()?1:0;

		if(!champ_de_bataille.placementAutorise(placement, bateau))
			return false;

		for(int i=0; i<bateau.getTaille(); i++)
		{
			Position pos = new Position(placement.getPosition().getCoord_X() + orientation * i, placement.getPosition().getCoord_Y() + (1-orientation) * i);
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
     * Calcul un placement alétoire disponible sur le champ de bataille pour un bateau donné.
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
    		int k = r.nextInt(1);
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
    	return flotte.remove(b);
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
			if (bloc.getEtatBloc() == Etat_bloc.PAS_TOUCHE)
			{
				bloc.setEtatBloc(Etat_bloc.TOUCHE);
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
     * 
     * @return les tirs non joués par le joueur
     */
    public Tir[] tirsNonJoues()
    {
    	ArrayList<Tir> tirs_non_joues = new ArrayList<Tir>();
    	for(int i=0; i<adversaires.size(); i++)
    	{
    		for(int j=0; j<adversaires.get(i).getChampDeBataille().getHauteur(); j++)
    		{
    			for(int k=0; k<adversaires.get(i).getChampDeBataille().getLongueur(); k++)
    			{
    				Tir tir_ajout = new Tir(new Position(k,j), adversaires.get(i));
                    //Parcours des tirs joués
    				for(int l=0; l<tirs_joues.size(); l++)
    				{
    					if(!tirs_joues.get(l).equals(tir_ajout))
    						tirs_non_joues.add(tir_ajout);
    				}

    			}
    		}
    	}
    	
    	return tirs_joues.toArray(new Tir[tirs_non_joues.size()]);
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

	public int getNbAdversaires()
	{
		return this.adversaires.size();
	}

	public boolean ajouterAdversaire(Joueur j)
	{
		return this.adversaires.add(j);
	}
	
	public boolean retirerAdversaire(Joueur j)
	{
		return this.adversaires.remove(j);
	}

	public void reinitialiserListeAdversaires()
	{
		this.adversaires = new ArrayList<Joueur>();
	}

	public Joueur[] getAdversaires()
	{
		return this.adversaires.toArray(new Joueur[adversaires.size()]);
	}
	
	public String getNom()
	{
		return this.nom;
	}

	public boolean equals(Object o)
	{
		if (o==null || !( o instanceof Joueur))
			return false;

		Joueur tmp = (Joueur)o;
		if(tmp.adversaires != adversaires)
			return false;
		if(tmp.champ_de_bataille != champ_de_bataille)
			return false;
		if(tmp.nom.equals(nom))
			return false;
		if(tmp.flotte != flotte)
			return false;
		if(tmp.tirs_joues != tirs_joues)
			return false;
		return true;
	}

}

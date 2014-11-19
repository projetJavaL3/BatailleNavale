package BatailleNavale.Model;

import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/** 
 * Classe <code> Modele </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Modele extends Observable
{
	/**
	 * Liste de Joueur.
	 */
	private ArrayList<Joueur> joueurs;
	/**
	 * Type de la Partie
	 */
	private Type_partie type;
	/**
	 * Indice du joueur courant
	 */
	private int indice_joueur_courant;
	
	/**
	 * Constructeur d'une Instance de Partie
	 * @param type le Type de Partie choisis par l'utilisateur
	 */
	public Modele()
	{
		this.indice_joueur_courant = 0;
	}	

	public void commencerPartie(Type_partie type, Joueur j1, Joueur j2)
	{
		this.joueurs = new ArrayList<Joueur>();
		this.type = type;
		this.ajouterJoueur(j1);
		this.ajouterJoueur(j2);
	}
	
	/**
	 * @return le type de la Partie
	 */
	public Type_partie getTypePartie()
	{
		return this.type;
	}

	/**
	 * @return true si une partie est termine
	 */
	public boolean estTermine()
	{	
		int nombreDePerdants = 0;
		
		for(int i=0; i<joueurs.size();i++)
			if(joueurs.get(i).aPerdu())
				nombreDePerdants ++;

		return (nombreDePerdants == joueurs.size()-1);
	}
	
	/**
	 * @return le nombre de joueurs 
	 */
	public int getNbJoueurs()
	{
		return this.joueurs.size();
	}

	/**
	 * Ajoute un joueur a la liste
	 * @param joueur nouveau joueur
	 */
	public boolean ajouterJoueur(Joueur joueur)
	{
		Iterator iterateur = joueurs.iterator();
		while (iterateur.hasNext())
		{
			Joueur adversaire = (Joueur) iterateur.next();

			joueur.ajouterAdversaire(adversaire);
			adversaire.ajouterAdversaire(joueur);
		}

		return this.joueurs.add(joueur);
	}
	
	/**
	 * Retire un joueur a la liste
	 * @param joueur le joueur a retirer
	 */
	public boolean retirerJoueur(Joueur joueur)
	{
		if(joueurs.size()<=2)
			return false;

		Iterator iterateur = joueurs.iterator();
		while (iterateur.hasNext())
		{
			Joueur j = (Joueur) iterateur.next();
			j.retirerAdversaire(joueur);
		}

		joueur.reinitialiserListeAdversaires();

		return this.joueurs.remove(joueur);
	}

	public Joueur getJoueurCourant()
	{
		return this.joueurs.get(indice_joueur_courant);
	}

	public void joueurSuivant()
	{
		this.indice_joueur_courant++;
		this.indice_joueur_courant %= joueurs.size();
		setChanged();
		notifyObservers();
	}

	/**
	 * @return la liste des joueurs 
	 */
	public Joueur[] getJoueurs()
	{
		return this.joueurs.toArray(new Joueur[this.joueurs.size()]);
	}

	public static void main(String[] args)
	{
		Modele bn = new Modele();

		Humain h1 = new Humain("Yanis");
		Humain h2 = new Humain("Maxime");
		Humain h3 = new Humain("Brady");
		Humain h4 = new Humain("Théo");

		bn.commencerPartie(Type_partie.CLASSIQUE, h1, h2);

		bn.ajouterJoueur(h1);
		bn.ajouterJoueur(h2);
		bn.ajouterJoueur(h3);
		bn.ajouterJoueur(h4);

		Joueur[] adversaires = h3.getAdversaires();
		for(int i=0; i<adversaires.length; i++)
		{
			System.out.println("Adversaire n°" + i + ": " + ((Humain) adversaires[i]).toString());
		}

		h2.ajouterBateau(new Cuirasse());
		h2.ajouterBateau(new SousMarin());
		h2.ajouterBateau(new Zodiac());
		
		//ajout de Porte-Avion
		h2.ajouterBateau(new PorteAvion());
		

		Bateau[] bateauxH2 = h2.getBateaux();
		
		Position p0 = new Position(6,4);
		Position p1 = new Position(14,4);
		Position p2 = new Position(1,15);
		Position p3 = new Position(6,8);
		
		h2.placerBateau(bateauxH2[0], new Placement(p0, true));
		h2.placerBateau(bateauxH2[1], new Placement(p1, false));
		h2.placerBateau(bateauxH2[2], new Placement(p2, true));
		
		h2.placerBateau(bateauxH2[3], new Placement(p3, true));
		
		
		
		Bloc[] blocs = h2.getChampDeBataille().getEmplacements();

		/**
		 * Bloc Toucher(temporaire)
		 */
		blocs[1].setEtatBloc(Etat_bloc.TOUCHE);
		bateauxH2[0].retirerPointDeVie();
		blocs[2].setEtatBloc(Etat_bloc.TOUCHE);
		bateauxH2[0].retirerPointDeVie();
		blocs[5].setEtatBloc(Etat_bloc.TOUCHE);
		bateauxH2[1].retirerPointDeVie();
		

		for(int i=0; i<blocs.length; i++)
		{
			System.out.println(blocs[i].getPosition());
		}

		System.out.println(h2.getChampDeBataille());
		
		System.out.println("Cuirasse : "+bateauxH2[0].getTaille());
		System.out.println("Point de Vie : "+bateauxH2[0].getPointDeVie());
		System.out.println("\nSous marin : "+bateauxH2[1].getTaille());
		System.out.println("Point de Vie : "+bateauxH2[1].getPointDeVie());
		System.out.println("\nZodiac : "+bateauxH2[2].getTaille());
		System.out.println("Point de Vie : "+bateauxH2[2].getPointDeVie());
		
		System.out.println("\nPosition Cuirasse : "+p0);
		System.out.println("Position Cuirasse : "+p1);
		System.out.println("\nDistance entre Cuirasse et Sous-Marin : "+p0.distance(p1)+" bloc (ou km pour les intimes).");
		
		System.out.println("\nDistance entre Cuirasse et Sous-Marin : "+p0.distance(p1)+" bloc (ou km pour les intimes).");
		
		int j;
		for(j=0;j<=blocs.length;j++)
		{
			//Cuirasse
			if(j<3)
				System.out.println("Cuirasse : "+blocs[j].getEtatBloc());
			//Sous-marin
			else if(j<7)
				System.out.println("Sous-Marin : "+blocs[j].getEtatBloc());
			//Zodiac
			else if(j<9)
				System.out.println("Zodiac :"+blocs[j].getEtatBloc());
			
			//Porte avion
			else if(j<13)
				System.out.println("Porte-Avion :"+blocs[j].getEtatBloc());
		}
	}
}

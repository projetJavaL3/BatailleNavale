package BatailleNavale.Model;

import BatailleNavale.Model.Joueur.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/** 
 * Classe <code> Partie </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Partie extends Observable
{

	/**
	 * Liste de Joueur.
	 */
	private ArrayList<Joueur> joueurs;
	/**
	 * Type de la Partie
	 */
	private final Type_partie type;
	/**
	 * Indice du joueur courant
	 */
	private int indice_joueur_courant;
	
	/**
	 * Constructeur d'une Instance de Partie
	 * @param type le Type de Partie choisis par l'utilisateur
	 */
	public Partie(Type_partie type, Joueur j1, Joueur j2)
	{
		this.joueurs = new ArrayList<Joueur>();
		this.ajouterJoueur(j1);
		this.ajouterJoueur(j2);
		this.type = type;
		this.indice_joueur_courant = 0;
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
}

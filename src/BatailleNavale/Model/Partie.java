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
	 * Constructeur d'une Instance de Partie
	 * @param type le Type de Partie choisis par l'utilisateur
	 */
	public Partie(Type_partie type)
	{
		this.joueurs = new ArrayList<Joueur>();
		this.type = type;
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
		setChanged();
		notifyObservers();
		return this.joueurs.add(joueur);
	}
	
	/**
	 * Retire un joueur a la liste
	 * @param joueur le joueur a retirer
	 */
	public boolean retirerJoueur(Joueur joueur)
	{
		Iterator iterateur = joueurs.iterator();
		while (iterateur.hasNext())
		{
			Joueur j = (Joueur) iterateur.next();
			j.retirerAdversaire(joueur);
		}

		joueur.reinitialiserListeAdversaires();

		setChanged();
		notifyObservers();

		return this.joueurs.remove(joueur);
	}

	/**
	 * @return la liste des joueurs 
	 */
	public Joueur[] getJoueurs()
	{
		return this.joueurs.toArray(new Joueur[this.joueurs.size()]);
	}
}

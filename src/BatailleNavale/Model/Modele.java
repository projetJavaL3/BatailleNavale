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
	private TypePartie type;
	/**
	 * Indice du joueur courant
	 */
	private int indice_joueur_courant;
	
	/**
	 * Options de la partie
	 */
	private Options options;

	/**
	 * Constructeur par defaut du modele
	 */
	public Modele()
	{
		this.joueurs = new ArrayList<Joueur>();
		this.type = TypePartie.CLASSIQUE;
		this.options = new Options();
		this.indice_joueur_courant = 0;
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
		Iterator iterateur = joueurs.iterator();
		while (iterateur.hasNext())
		{
			Joueur j = (Joueur) iterateur.next();
			j.retirerAdversaire(joueur);
		}

		joueur.reinitialiserListeAdversaires();

		return this.joueurs.remove(joueur);
	}

	/**
	 * @return le joueur courant
	 */
	public Joueur getJoueurCourant()
	{
		return this.joueurs.get(indice_joueur_courant);
	}

	/**
	 * on passe au joueur suivant
	 */
	public void joueurSuivant()
	{
		int cpt = 0;
		do
		{
			this.indice_joueur_courant++;
			this.indice_joueur_courant %= joueurs.size();
			
			if(cpt++>joueurs.size())
				break;

		} while(joueurs.get(indice_joueur_courant).aPerdu());

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

	/**
	 * @return true si une partie est termine
	 */
	public boolean partieTermine()
	{	
		int nombreDePerdants = 0;
		
		for(int i=0; i<joueurs.size();i++)
			if(joueurs.get(i).aPerdu())
				nombreDePerdants ++;

		return (nombreDePerdants >= joueurs.size()-1);
	}

	/**
	 * Modifieur du type de partie
	 * @param type type de la partie
	 */
	public void setTypePartie(TypePartie type)
	{		
		this.type = type;
	}
	
	/**
	 * @return le type de la Partie
	 */
	public TypePartie getTypePartie()
	{
		return this.type;
	}
	
	public Options getOptions()
	{
		return options;
	}
}

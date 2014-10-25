package BatailleNavale.Model;

import BatailleNavale.Model.Joueur.*;

import java.util.ArrayList;

/** 
 * Classe <code> Partie </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Partie 
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
	 * @param j nouveau joueur
	 */
	public boolean ajouterJoueur(Joueur j)
	{
		return this.joueurs.add(j);
	}
	
	/**
	 * Retire un joueur a la liste
	 * @param j le joueur a retirer
	 */
	public boolean retirerJoueur(Joueur j)
	{
		return this.joueurs.remove(j);
	}

	/**
	 * @return la liste des joueurs 
	 */
	public Joueur[] getJoueurs()
	{
		return this.joueurs.toArray(new Joueur[this.joueurs.size()]);
	}
}

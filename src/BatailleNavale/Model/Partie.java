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
	private Type_partie type;
	
	/**
	 * Constructeur d'une Instance de Partie
	 * @param type le Type de Partie choisis par l'utilisateur
	 */
	public Partie(Type_partie type)
	{
		this.type = type;
	}	
	
	/**
	 * Retourne true si une partie est termine
	 */
	private boolean estTermine()
	{	
		int nombreDePerdants = 0;
		
		for(int i=0; i<joueurs.size();i++)
			if(joueurs.get(i).aPerdu())
				nombreDePerdants ++;

		return (nombreDePerdants == joueurs.size()-1);
	}
	
	/**
	 * Renvoie le type de la Partie
	 */
	public Type_partie getTypePartie()
	{
		return this.type;
	}
	
	/**
	 * Modifie le type de la Partie
	 * @param new_type nouveau type de la partie
	 */
	public void setTypePartie(Type_partie new_type)
	{
		this.type = new_type;
	}
}

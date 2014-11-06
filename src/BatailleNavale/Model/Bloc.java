//plop
package BatailleNavale.Model;

import BatailleNavale.Model.Flotte.*;
import java.util.Observable;

/** 
 * Classe <code> Bloc </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Bloc extends Observable
{
	/**
	 * Etat dans lequel le Bloc se trouve
	 */
	protected Etat_bloc etat;
	/**
	 * Declaration d'un objet de type Bateau
	 */
	private Bateau bateau;
	/**
	 * Declaration d'un objet de type Position
	 */
	protected Position position;

	/**
	 * Constructeur d'une Instance de Bloc (avec exactement un Bateau) 
	 */
	public Bloc (Bateau bateau, Position position)
	{
		this.bateau = bateau;
		this.position = new Position(position);
		this.etat = Etat_bloc.PAS_TOUCHE;
	}
	
	/**
	 * Retroune l'Etat dans lequel le Bloc se trouve
	 */
	public Etat_bloc getEtatBloc()
	{
		return this.etat;
	}
	
	/**
	 * Retourne le bateau du Bloc
	 */
	public Bateau getBateau()
	{
		return this.bateau;
	}

	/*
	 * Retroune la position du Bloc
	 */
	public Position getPosition()
	{
		return this.position;
	}

	/**
	 * Modifie l'état du Bloc
	 * @param new_etat le nouvel état du Bloc
	 */
	public void setEtatBloc(Etat_bloc new_etat)
	{
		this.etat = new_etat;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Modifie le bateau du Bloc
	 * @param bateau le nouveau bateau du Bloc
	 */
	public void setBateau(Bateau bateau) 
	{
		this.bateau = bateau;
		setChanged();
		notifyObservers();
	}

	/**
	 * Modifie la Position du Bloc
	 * @param p la nouvelle Position du Bloc
	 */
	public void setPosition(Position p)
	{
		this.position = new Position(p);
		setChanged();
		notifyObservers();
	}
}

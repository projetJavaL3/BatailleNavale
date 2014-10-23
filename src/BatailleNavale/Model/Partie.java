package BatailleNavale.Model;
import java.util.ArrayList;

public class Partie {

	/**
	 * Liste de Joueur.
	 */
	private ArrayList<Joueur> joueur;
	/**
	 * Type dans lequel le partie se trouve
	 */
	protected Type_partie partie;
	
	/**
	 * Constructeur de la Partie 
	 */
	public Partie(){
		
		this.partie = Partie.ARCADE;
	    this.joueur = new ArrayList<Joueur>;
	}
	
	/**
	 * Retroune le type de partie
	 */
	public Type_Partie getTypePartie()
	{
		return this.partie;
	}
	/**
	 * Modifie le type de Partie
	 */
	public void setTypePartie(Type_partie new_partie)
	{
		this.partie = new_partie;
	}
	/**
	 * Pour savoir si la Partie est terminé.
	 * @return true
	 */
	private boolean estTermine(){
		return true;
	}
}

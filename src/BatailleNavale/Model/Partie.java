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
	
	private boolean estTermine(){
		return true;
	}
}
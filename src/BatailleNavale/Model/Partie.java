package BatailleNavale.Model;
import java.util.ArrayList;

/**
 * Class Partie
 * @date 25/10/14
 * @author Boukari Yanis - Abderemane Brady - Chelim Theo
public class Partie {

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
		int nombreDeJoueurs = joueurs.size();
		int nombreDePerdants = 0;
		for(int i=0; i<nombreDeJoueurs;i++)
		{
			if(joueurs.get(i).aPerdu())
			{
				nombreDePerdants ++;
			}
		}
		
		if(nombreDePerdants == nombreDeJoueurs-1;)
			return true;

		else
			return false;
	}
	
	/**
	 * Renvoie le type de la Partie
	 */
	public Type_Partie getTypePartie()
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

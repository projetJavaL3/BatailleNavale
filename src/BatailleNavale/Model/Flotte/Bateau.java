package BatailleNavale.Model.Flotte;

/**
 * Classe Bateau 
 * @date 16/10/14
 * @author Théo CHELIM et Yanis BOUKARI
 */
public abstract class Bateau 
{
	/**
	 * Nom du Bateau
	 */
	protected final String nom;
	/**
	 * Taille du Bateau
	 */
	protected final int taille;
	/**
	 * Nombre de points de vie du Bateau
	 */ 
	protected int point_de_vie;
	/**
	 * Etat dans lequel le Bateau se trouve
	 */
	protected Etat_bateau etat; 

	/**
	 * Constructeur d'instance de Bateau 
	 * @param nom nom du bateau
	 * @param taille taille du bateau
	 */
	Bateau (String nom, int taille)
	{
		this.nom = nom;
		this.taille = taille;
		this.point_de_vie = taille;
	}

	/**
	 * Renvoie l'état du bateau
	 */
	public Etat_bateau getEtatBateau()
	{
		return this.etat;
	}


	/**
	 * Renvoie le nombre de points de vie
	 */
	public int getPointDeVie()
	{
		return this.point_de_vie;
	}

	/**
	 * Renvoie la taille du Bateau
	 */
	public  int getTaille()
	{
		return this.taille;
	}
	/**
	 * Renvoie le nom du Bateau
	 */
	public String getNom()
	{
		return this.nom;
	}
	
	/**
	 * Modifie l'état du Bateau
	 * @param new_etat nouvel état du Bateau
	 */
	public void setEtatBateau(Etat_bateau new_etat)
	{
		this.etat = new_etat;
	}
}
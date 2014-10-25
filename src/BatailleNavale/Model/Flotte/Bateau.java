package BatailleNavale.Model.Flotte;

/** 
 * Classe <code> Bateau </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
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
	public Bateau (String nom, int taille)
	{
		this.nom = nom;
		this.taille = taille;
		this.point_de_vie = taille;
		this.etat = Etat_bateau.INTACT;
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
	 * Retire un point de vie au bateau
	 * @return true si on le bateau n'est pas deja touche
	 */
	public boolean retirerPointDeVie()
	{
		if(point_de_vie > 0)
		{
			point_de_vie--;
			this.etat = Etat_bateau.TOUCHE;
			if(point_de_vie == 0)
				this.etat = Etat_bateau.COULE;

			return true;			
		}

		return false;
	}

	/**
	 * Modifie l'état du Bateau
	 * @param new_etat nouvel état du Bateau
	 */
	protected void setEtatBateau(Etat_bateau new_etat)
	{
		this.etat = new_etat;
	}
}

package BatailleNavale.Model;

/** 
 * 16/10/2014
 * @author Maxime Kermarquer - Brady Abderemane - Théo Chelim - Yanis Boukari
 * @version 1.0.0
 */
public class Tir
{
	/**
	 * Position du Tir
	 */
	private Position position;
	/**
	 * Joueur cible du Tir
	 */
	private Joueur joueur;

	/**
	 * Construit un Tir à partir d'une position et d'un joueur 
	 * @param p position du Tir
	 * @param j joueur cible du Tir
	 */
	public Tir(Position p, Joueur j)
	{
		this.position = new Position(p);
		this.joueur = j;
	}

	/** 
	 * Construit un tir à partir d'un autre.
	 * @param t
	 */
	public Tir (Tir t) 
	{
		this.position = new Position(t.position);
		this.joueur = t.joueur;
	}

	/**
	 * Accesseur de position.
	 * @return position
	 */
	public Position getPosition()
	{
		return this.position;
	}

	/**
	 * Accesseur de Joueur.
	 * @return joueur
	 */
	public Joueur getJoueur()
	{
		return this.joueur;
	}

	/**
	 * Modifieur de position
	 * @param p nouvelle position
	 */
	public void setPosition(Position p)
	{
		this.position = new Position(p);
	}

	/**
	 * Modifieur de joueur 
	 * @param j nouveau joueur 
	 */
	public void setJoueur(Joueur j)
	{
		this.joueur = j;
	}

	public boolean toucheBateau()
	{
		
	}

	public String toString()
	{
		return "Tir sur " + joueur.toString() + " à la position " + position.toString();
	}
}
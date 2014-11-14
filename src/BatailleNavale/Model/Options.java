package BatailleNavale.Model;

/** 
 * Classe <code> Options </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Options
{
	/**
	 * La partie de bataille navale
	 */
	private int longueur;
	private int hauteur;

	/**
	 * Constructeur du jeu de bataille navale
	 */
	public Options()
	{
		this.longueur = 15;
		this.hauteur = 15;
	}

	public int getLongueur()
	{
		return this.longueur;
	}

	public int getHauteur()
	{
		return this.hauteur;
	}

	public void setLongueur(int l)
	{
		this.longueur = l;
	}

	public void setHauteur(int h)
	{
		this.hauteur = h;
	}
}

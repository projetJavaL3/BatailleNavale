package BatailleNavale.Model;

/**
 * Classe Bloc 
 * @date 17/10/14
 * @author Théo CHELIM et Yanis BOUKARI
 */
public class Bloc
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
	Bloc (Bateau bateau, Position position)
	{
		this.bateau = new Bateau(" " , 0);
		this.position = new Position(position);
		//this.position = new Position(0,0) ? 
		etat.PAS_TOUCHE;
	}
	
	/**
	 * Retroune l'Etat dans lequel le Bloc se trouve
	 */
	public Etat_bloc getEtatBloc()
	{
		return this.etat;
	}
	
	/**
	 * Modifie l'état du Bloc
	 * @param new_etat , nouvelle état du Bloc
	 */
	public void setEtatBloc(Etat_bloc new_etat)
	{
		this.etat = new_etat;
	}
	
	/*
	 * Retroune la position du Bloc
	 */
	public Position getPosition()
	{
		return this.position;
	}
	
	/**
	 * Modifie la Position du Bloc
	 * @param pos , nouvelle Position du Bloc
	 */
	public void setPosition(Position pos)
	{
		this.position = pos;
	}
		
}

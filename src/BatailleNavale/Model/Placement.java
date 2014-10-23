package BatailleNavale.Model;

/** 
 * 16/10/2014
 * @author Maxime Kermarquer - Brady Abderemane - Théo Chelim - Yanis Boukari
 * @version 1.0.0
 */
public class Placement 
{
	/**
	 * Position du placement
	 */
	private Position position;
	/**
	 * Direction du placement
	 */
	private boolean direction;

	/**
	 * Construit un Placement a partir d'une position et d'une direction (boolean)
	 * @param p 
	 * @param d
	 */
	public Placement(Position p, boolean d)
	{
		this.position = new Position(p);
		this.direction = d;
	}

	/** 
	 * Construit un Placement a partir d'un autre Placement 
	 * @param p placement a copier
	 */
	public Placement(Placement p) 
	{
		this.position = new Position(p.position);
		this.direction = p.direction;
	}

	/** 
	 * Accesseur de postion
	 * @return position
	 */
	public Position getPosition()
	{
		return this.position;
	}

	/**
	 * Accesseur de direction
	 * @return direction
	 */
	public boolean getDirection()
	{
		return this.direction;
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
	 * Modifieur de direction
	 * @param d nouvelle direction
	 */
	public void setDirection(boolean d)
	{
		this.direction = d;
	}

	public String toString()
	{
		return "Placement: " + position.toString() + " " + (direction?"horizontalement":"verticalement");
	}
}
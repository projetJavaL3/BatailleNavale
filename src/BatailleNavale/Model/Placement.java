package BatailleNavale.Model;

import java.util.Observable;

/** 
 * Classe <code> Placement </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Placement extends Observable
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
		setChanged();
		notifyObservers();
	}

	/**
	 * Modifieur de direction
	 * @param d nouvelle direction
	 */
	public void setDirection(boolean d)
	{
		this.direction = d;
		setChanged();
		notifyObservers();
	}

	public String toString()
	{
		return "Placement: " + position.toString() + " " + (direction?"horizontalement":"verticalement");
	}
}

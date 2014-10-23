package BatailleNavale.Model;

/** 
 * 16/10/2014
 * @author Maxime Kermarquer - Brady Abderemane - Th�o Chelim - Yanis Boukari
 * @version 1.0.0
 */
public class Position
{
	/**
	 * Coordonnee X
	 */
	private int coord_X;
	/**
	 * Coordonnee Y
	 */
	private int coord_Y;
	
	/**
	 * Construit une <code>Position</code> � partir de deux entiers x,y.
	 * @param x
	 * @param y
	 */
	public Position (int x, int y) 
	{
		coord_X = x;
		coord_Y = y;
	}
	
	/**
	 * Construit une <code>Position</code> � partir d'une autre.
	 * @param p
	 */
	public Position (Position p) 
	{
		coord_X = p.coord_X;
		coord_Y = p.coord_Y;
	}

	/**
	 * Accesseur de <code>coord_X</code>.
	 * @return coord_X
	 */
	public int getCoord_X() {
		return coord_X;
	}

	/**
	 * Modifieur de <code>coord_X</code>.
	 * @param coord_X
	 */
	public void setCoord_X(int coord_X) {
		this.coord_X = coord_X;
	}

	/**
	 * Accesseur de <code>coord_Y</code>.
	 * @return coord_Y
	 */
	public int getCoord_Y() {
		return coord_Y;
	}

	/**
	 * Modifieur de <code>coord_Y</code>.
	 * @param coord_Y
	 */
	public void setCoord_Y(int coord_Y) {
		this.coord_Y = coord_Y;
	}
	
	/**
	 * Modifieur de <code>coord_X</code> et <code>coord_Y</code>.
	 * @param coord_X
	 * @param coord_Y
	 */
	public void setCoord_XY (int coord_X, int coord_Y){
		setCoord_X(coord_X);
		setCoord_Y(coord_Y);
	}
	
	/**
	 * Calcule la distance approchee entre deux <code>Position</code>.
	 * @param p
	 * @return
	 */
	public int distance (Position p) 
	{
		return (int) Math.sqrt( (p.coord_X - coord_X)*(p.coord_X - coord_X) + (p.coord_Y - coord_Y)*(p.coord_Y - coord_Y));
	}
	
	
	/*
	 * Calcul la distance exacte 
	 * 
	 * 
	public double distance2 (Position p) throws NullPointerException{
		if(p==null){
			throw new NullPointerException();
		}
		//Conversion un peu degueulasse
		return Math.sqrt( (p.coord_X - coord_X)*(p.coord_X - coord_X) + (p.coord_Y - coord_Y)*(p.coord_Y - coord_Y));
	}
	*/
	
	public String toString(){
		return "("+coord_X+","+coord_Y+")";
	}
	
	public boolean equals(Object o){
		if(o == null || !(o instanceof Position)){
			return false;
		}
		Position tmp = (Position)o;
		if(tmp.coord_X != coord_X){
			return false;
		}
		if(tmp.coord_Y != coord_Y){
			return false;
		}	
		return true;
	}
	
}
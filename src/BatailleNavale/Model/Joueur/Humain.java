package BatailleNavale.Model.Joueur;


import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;

/** 
 * Classe <code> Humain </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Humain extends Joueur
{

	
	public Humain(String nom, Options options)
	{
		super(nom, options);
	}
	
	public boolean tir(Tir t)
	{
		return true;
	}

	public String toString()
	{
		return "(" + nom + ")";
	}
}

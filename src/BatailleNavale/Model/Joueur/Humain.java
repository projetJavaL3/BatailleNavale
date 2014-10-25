package BatailleNavale.Model.Joueur;


import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;

/** 
 * Classe <code> Humain </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Humain extends Joueur
{

	private final String nom;
	
	public Humain(String nom, Options options)
	{
		super(options);
		this.nom = nom;
	}
	
	public String getNom()
	{
		return this.nom;
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

package BatailleNavale.Model.Joueur;


import java.util.ArrayList;

import BatailleNavale.Model.Flotte.Bateau;
import BatailleNavale.Model.Flotte.Etat_bateau;
import BatailleNavale.Model.Tir;

/**
 * Classe décrivant le joueur de bataille navale.
 */
public abstract class Joueur {
	/**
	 * Champ de bataille du joueur.
	 */
	private ChampDeBataille champ_de_bataille;
	
	/**
	 * Ensemble des tirs joues par le joueur.
	 */
	private ArrayList<Tir> tirs_joues;
	
	/**
	 * Bateau(x) du joueur
	 */
	private ArrayList<Bateau> flotte;

	
	public Joueur (ChampDeBataille c){
		//Voir l'instanciation du champ de bataille 
		champ_de_bataille = c;
		tirs_joues = new ArrayList<>();
		flotte = new ArrayList<>();
	}
	
	
	
	public boolean positionneBateau (Bateau bateau, Placement placement){
		if(!champ_de_bataille.placementAutorise()){
			//ExceptionPlacementBateau()
			return false;
		}
		if(!champ_de_bataille.existePosition (placement.getPosition() )){
			//La position n'appartient pas au champ de bataille
			//Exception
			return false;
		}
		
		champ_de_bataille.
		for(int i=0; i<bateau.getTaille(); i++){
			if(placement.getDirection()){
				//Direction horizontale
			}
		}
	}
	
	public void enleveBateau(Bateau bateau){
		
	}
	
	public abstract boolean tir (Tir t);
	
	public int NbTirsJoues(){
		return tirs_joues.size();
	}
	
	
	/**
	 * Liste des bateaux encore intacts.
	 * @return les bateaux intacts
	 */
	public ArrayList<Bateau> bateaux_intacts(){
		ArrayList<Bateau> intacts = new ArrayList<>();
		for(int i=0; i<flotte.size();i++){
			if(flotte.get(i).getEtatBateau() == Etat_bateau.INTACT){
				intacts.add(flotte.get(i));
			}
		}
		return intacts;
	}
	
	/**
	 * 
	 * @return true si le joueur n'a plus que des bateaux coulés, false sinon
	 */
	public boolean aPerdu(){
		for(int i=0; i<flotte.size();i++){
			if(flotte.get(i).getEtatBateau() == Etat_bateau.INTACT || flotte.get(i).getEtatBateau() == Etat_bateau.TOUCHE ){
				return false;
			}
		}
		return true;
	}
	
}

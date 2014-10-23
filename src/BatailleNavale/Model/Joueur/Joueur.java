package BatailleNavale.Model.Joueur;


import java.util.ArrayList;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;

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
		
		if(placement.getDirection()){
			//Direction Horizontale
			for(int i=0; i<bateau.getTaille(); i++){
				Position p = new Position(placement.getPosition().getCoord_X()+i, placement.getPosition().getCoord_Y());
				Bloc bloc = new Bloc(bateau, p);
				champ_de_bataille.addBloc(bloc);
			}
		}
		else{
			//Direction verticale
			for(int i=0; i<bateau.getTaille(); i++){
				Position p = new Position(placement.getPosition().getCoord_X(), placement.getPosition().getCoord_Y()+i);
				Bloc bloc = new Bloc(bateau, p);
				champ_de_bataille.addBloc(bloc);
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

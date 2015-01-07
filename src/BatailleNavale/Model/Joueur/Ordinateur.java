package BatailleNavale.Model.Joueur;


import BatailleNavale.Model.*;

import java.util.Random;
import java.util.ArrayList;

/**
 * Classe <code> Ordinateur </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Ordinateur extends Joueur 
{   
    /**
     * Niveau de l'ordinateur
     */
    private Difficulte niveau;
    
    /**
     *  Constructeur par defaut de l'ordinateur
     */
    public Ordinateur(String nom, int niveau)
	{
            super(nom);
            if (niveau <= 1) {
                this.niveau = Difficulte.FACILE;
            } else if (niveau == 2) {
                this.niveau = Difficulte.MOYEN;
            } else {
                this.niveau = Difficulte.DIFFICILE;
            }
	}
        
    public Ordinateur(String nom, int taille_grille, int niveau)
    {
        super(nom, taille_grille);
        if (niveau <= 1) {
            this.niveau = Difficulte.FACILE;
        } else if (niveau == 2) {
            this.niveau = Difficulte.MOYEN;
        } else {
            this.niveau = Difficulte.DIFFICILE;
        }
    } 

    /**
     * Calcul d'un <code>Tir</code> aléatoire
     */
    public Tir tirAleatoire()
    {
        switch(niveau)
        {
            case FACILE : return tirFacile();
                
            case MOYEN : return tirMoyen();
                
            case DIFFICILE : return tirDifficile();
                
            default : return tirFacile();
        }
    }
    
    /**
     * Tir choisi de façon totalement aléatoire.
     */
    private Tir tirFacile(){
        Tir[] tir_non_joues = getTirsNonJoues();
        Random r = new Random();
        if(tir_non_joues.length==0)
            return null;
        return tir_non_joues[r.nextInt(tir_non_joues.length)];
    }
    
    /**
     * Tir aux alentours du dernier tir réussi  
     */
    private Tir tirMoyen(){
        ArrayList<Tir> tirs_potentiels = getTirsPotentiels();
        if(!tirs_potentiels.isEmpty())
            return tirs_potentiels.get(0);
        return tirFacile();
    }
    
    /**
     * Tir qui a une chance sur deux de tirer sur un bateau de l'adversaire
     */
    private Tir tirDifficile(){
        Tir[] tir_non_joues = getTirsNonJoues();
        Tir[] tirs_sur_bateaux_adversaires = getTirsBateauxAdversaires();
        Random r = new Random();
        if((r.nextInt(3))!=2){
            return tirs_sur_bateaux_adversaires[0];
        }
        else{
            return tir_non_joues[r.nextInt(tir_non_joues.length)];
        }
    }

    /**
     * 
     * @return les tirs non joués par le joueur
     */
    public Tir[] getTirsNonJoues()
    {
        ArrayList<Tir> tirs_non_joues = new ArrayList<Tir>();
        
        for(int i=0; i<adversaires.size(); i++)
        {
            for(int j=0; j<adversaires.get(i).getChampDeBataille().getHauteur(); j++)
            {
                for(int k=0; k<adversaires.get(i).getChampDeBataille().getLongueur(); k++)
                {
                    Tir tir_ajout = new Tir(new Position(k+1,j+1), adversaires.get(i));
                    if(!tirs_joues.contains(tir_ajout))
                        tirs_non_joues.add(tir_ajout);
                }
            }
        }
        
        return tirs_non_joues.toArray(new Tir[tirs_non_joues.size()]);
    }  
    
    /**
     * 
     * @return les tirs qui touchent les bateaux des adversaires
     */
    private Tir[] getTirsBateauxAdversaires()
    {
        ArrayList<Tir> tirs_sur_bateaux_adversaires = new ArrayList<Tir>();
        
        for(int i=0; i<adversaires.size(); i++)
        {
            Bloc[] blocs_bateaux_adversaire_courant = adversaires.get(i).getChampDeBataille().getEmplacements();
            for(int j=0; j<blocs_bateaux_adversaire_courant.length;j++){
                Tir tir_a_ajouter = new Tir(blocs_bateaux_adversaire_courant[j].getPosition(), adversaires.get(i));
                if ( !tirs_joues.contains(tir_a_ajouter) ) {
                    tirs_sur_bateaux_adversaires.add(tir_a_ajouter);
                }   
            }
        }
        
        return tirs_sur_bateaux_adversaires.toArray(new Tir[tirs_sur_bateaux_adversaires.size()]);
    }
    
    /**
     * 
     * @return les tirs aux alentours du dernier tir qui a reussi
     */
    private ArrayList<Tir> getTirsPotentiels() {
        ArrayList<Tir> tirs_potentiels = new ArrayList<>();
        Position position_probable;
        Tir dernier_tir = tirs_joues.get(tirs_joues.size() - 1);
        ChampDeBataille champ_dernier_tir = dernier_tir.getJoueur().getChampDeBataille();
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    position_probable = new Position(dernier_tir.getPosition().getCoord_X() + 1, dernier_tir.getPosition().getCoord_Y());
                    break;
                case 1:
                    position_probable = new Position(dernier_tir.getPosition().getCoord_X() - 1, dernier_tir.getPosition().getCoord_Y());
                    break;
                case 2:
                    position_probable = new Position(dernier_tir.getPosition().getCoord_X(), dernier_tir.getPosition().getCoord_Y() + 1);
                    break;
                default:
                    position_probable = new Position(dernier_tir.getPosition().getCoord_X(), dernier_tir.getPosition().getCoord_Y() - 1);
                    break;
            }

            if (champ_dernier_tir.positionValide(position_probable)) {
                Tir tir_ajout = new Tir(position_probable, dernier_tir.getJoueur());
                if (!tirs_joues.contains(tir_ajout)) {
                    tirs_potentiels.add(tir_ajout);
                }
            }
        }
        return tirs_potentiels;
    }
    
    private boolean reussiteDernierTir(){
        if(tirs_joues.isEmpty()){
            return false;
        }
        return tirs_joues.get( (tirs_joues.size()-1) ).tirReussi();
    }
    

    
}

package BatailleNavale.Model.Joueur;


import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;

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
    
    private boolean bateauTrouve = false;
    private boolean cherche_direction = true;
    private boolean changement_sens = false;
    private boolean sens = true;
    private boolean avant = true;
    private Tir dernierBonTir;

    /**
     *  Constructeur par defaut de l'ordinateur
     */
    public Ordinateur(String nom, Difficulte niveau)
	{
        this(nom, 10, niveau);
	}
        
    public Ordinateur(String nom, int taille_grille, Difficulte niveau)
    {
        super(nom, taille_grille);
        this.niveau = niveau;
    } 

    /**
     * Calcul d'un <code>Tir</code> aléatoire
     */
    public Tir tirAleatoire()
    {
        Tir t = null;

        switch(niveau)
        {
            case FACILE: 
                t = tirFacile();
                break;
                
            case MOYEN: 
                t = tirMoyen();
                break;

            case DIFFICILE: 
                t = tirDifficile();
        }

        return t;
    }
    
    /**
     * Tir choisi de façon totalement aléatoire.
     */
    private Tir tirFacile()
    {
        Tir[] tir_non_joues = getTirsNonJoues();
        Random r = new Random();
        if(tir_non_joues.length==0)
            return null;
        return tir_non_joues[r.nextInt(tir_non_joues.length)];
    }
    
    /**
     * Tir aux alentours du dernier tir réussi  
     */
    private Tir tirMoyen()
    {
        Tir t = tirFacile();
        
        if(bateauTrouve)
            t = getTirPotentiel();
        
        if(t.tirReussi())
        {
            if(t.getBateau().getPointDeVie()>1)
            {
                if(bateauTrouve)
                    cherche_direction = false;
                bateauTrouve = true;
                dernierBonTir = t;
            }
            else
            {
                bateauTrouve = false;
                cherche_direction = true;
                changement_sens = false;
            }
        }
        else
        {
            if(!changement_sens && (bateauTrouve && !cherche_direction))
            {
                avant = !avant;
                changement_sens = true;
            }
        }
        
        return t;
    }
    
    /**
     * Tir qui a une chance sur deux de tirer sur un bateau de l'adversaire
     */
    private Tir tirDifficile()
    {
        Random r = new Random();
        Tir[] tirs_sur_bateaux_adversaires = getTirsBateauxAdversaires();
        if(r.nextInt(2)==0)
            return tirs_sur_bateaux_adversaires[0];
        else
            return tirFacile();
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
            for(int j=0; j<blocs_bateaux_adversaire_courant.length;j++)
            {
                Tir tir_a_ajouter = new Tir(blocs_bateaux_adversaire_courant[j].getPosition(), adversaires.get(i));
                if (!tirs_joues.contains(tir_a_ajouter))
                    tirs_sur_bateaux_adversaires.add(tir_a_ajouter);
            }
        }
        
        return tirs_sur_bateaux_adversaires.toArray(new Tir[tirs_sur_bateaux_adversaires.size()]);
    }
    
    /**
     * 
     * @return les tirs aux alentours du dernier tir qui a reussi
     */
    private Tir getTirPotentiel() 
    {
        Tir tir_ajout = null;
        ArrayList<Tir> tirs_potentiels = new ArrayList<Tir>();
        Position position_probable;
        ChampDeBataille champ_dernierBonTir = dernierBonTir.getJoueur().getChampDeBataille();   

        if(cherche_direction)
        {
            for (int i = 0; i < 4; i++)
            {
                switch (i) 
                {
                    case 0:
                        position_probable = new Position(dernierBonTir.getPosition().getCoord_X() + 1, dernierBonTir.getPosition().getCoord_Y());
                        break;
                    case 1:
                        position_probable = new Position(dernierBonTir.getPosition().getCoord_X() - 1, dernierBonTir.getPosition().getCoord_Y());
                        break;
                    case 2:
                        position_probable = new Position(dernierBonTir.getPosition().getCoord_X(), dernierBonTir.getPosition().getCoord_Y() + 1);
                        break;
                    default:
                        position_probable = new Position(dernierBonTir.getPosition().getCoord_X(), dernierBonTir.getPosition().getCoord_Y() - 1);
                        break;
                }

                if(champ_dernierBonTir.positionValide(position_probable))
                {
                    tir_ajout = new Tir(position_probable, dernierBonTir.getJoueur());
                    if (!tirs_joues.contains(tir_ajout))
                        tirs_potentiels.add(tir_ajout);
                }
            }
            if(!tirs_potentiels.isEmpty())
                sens = (tirs_potentiels.get(0).getPosition().getCoord_X()!=dernierBonTir.getPosition().getCoord_X());
            avant = true;
        }
        else
        {
            position_probable = dernierBonTir.getPosition();
            boolean chercher = true;
            
            do
            {
                position_probable = new Position(position_probable.getCoord_X() + ((sens?1:0) * (avant?1:-1)), position_probable.getCoord_Y() + ((sens?0:1) * (avant?1:-1)));
                if(champ_dernierBonTir.positionValide(position_probable))
                {
                    tir_ajout = new Tir(position_probable, dernierBonTir.getJoueur());
                    if (!tirs_joues.contains(tir_ajout))
                        chercher = false;        
                }
                else
                {
                    avant = !avant;
                    changement_sens = true;
                }
            
            }while(chercher);

            tirs_potentiels.add(tir_ajout);
        }
    
        return tirs_potentiels.isEmpty()?null:tirs_potentiels.get(0);
    }
}

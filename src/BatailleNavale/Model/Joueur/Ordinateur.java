
package BatailleNavale.Model.Joueur;

import BatailleNavale.Model.*;

import java.util.Random;

/**
 * Classe <code> Ordinateur </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Ordinateur extends Joueur 
{
    /**
     * Niveau de l'ordinateur
     */
    private int niveau;

    /**
     *  Constructeur par defaut de l'ordinateur
     */
    public Ordinateur(String nom, int niveau)
	{
		super(nom);
        this.niveau = niveau;
	}
        
    /**
     * Calcul d'un <code>Tir</code> aléatoire
     */
    public Tir tirAleatoire()
    {
        Tir[] tir_non_joues = getTirsNonJoues();
        Random r = new Random();
        if(tir_non_joues.length==0)
            return null;
        return tir_non_joues[r.nextInt(tir_non_joues.length)];
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
                    Tir tir_ajout = new Tir(new Position(k,j), adversaires.get(i));
                   
                    for(int l=0; l<tirs_joues.size(); l++)
                    {
                        if(!tirs_joues.get(l).equals(tir_ajout))
                            tirs_non_joues.add(tir_ajout);
                    }
                }
            }
        }
        
        return tirs_joues.toArray(new Tir[tirs_non_joues.size()]);
    }  
}


package BatailleNavale.Model.Joueur;

import BatailleNavale.Model.Options;
import BatailleNavale.Model.Position;
import BatailleNavale.Model.Tir;
import java.util.Random;

/**
 * Classe <code> IA </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class IA extends Joueur {
    
    	public IA (Options options)
	{
		super("IA", options);
	}
        
        /**
         * Calcul d'un <code>Tir</code> aléatoire
         */
        public Tir tir_aleatoire()
        {
            Random r = new Random();
            int index_joueur_alea = r.nextInt(getAdversaires().length);
            int coord_X = r.nextInt( getChampDeBataille().getLongueur() );
            int coord_Y = r.nextInt( getChampDeBataille().getHauteur() );
            Joueur joueur_alea = getAdversaires()[index_joueur_alea];
            Position position_alea = new Position( coord_X , coord_Y );
            Tir tir_alea = new Tir( position_alea , joueur_alea );
            boolean nouvelle_position = !tirDansTirsJoues( tir_alea );
            
            while(!nouvelle_position)
            {
                coord_X = r.nextInt(getChampDeBataille().getLongueur());
                coord_Y = r.nextInt(getChampDeBataille().getHauteur());
                position_alea.setCoord_XY(coord_X, coord_Y);
                tir_alea.setPosition(position_alea);
                nouvelle_position = !tirDansTirsJoues( tir_alea );
            }
            
            return tir_alea;
        }
        
        /**
         * Verifie si un tir à déjà été joué
         * @param tir à vérifier 
         * @return <code>true</code> si la position est dans la liste des tirs joués, <code>false</code> sinon.
         */
        public boolean tirDansTirsJoues(Tir tir)
        {
            Tir[] tirs_joues = getTirs();
            for(int i=0; i<tirs_joues.length;i++)
            {
                if(tir.equals(tirs_joues[i]))
                    return true;
            }
            return false;
        }
        
        public static void main(String[] args){
            //Init
            Humain j1 = new Humain("Max", new Options());
            IA j2 = new IA(new Options());
            
            //Ajout des adversaires
            j1.ajouterAdversaire(j2);
            j2.ajouterAdversaire(j1);
            
            
       
            //Essai de n tirs aléatoires
            int n = 10;
            for(int i=0; i<n; i++)
                j2.tirs_joues.add(j2.tir_aleatoire());
            for(int i=0; i<j2.getTirs().length;i++)
                System.out.println(j2.getTirs()[i]);
            
        }
    
}

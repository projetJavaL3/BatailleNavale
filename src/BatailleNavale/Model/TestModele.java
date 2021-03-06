package BatailleNavale.Model;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Model.Flotte.*;

public class TestModele
{
	public static void main(String[] args)
	{
		Modele bn = new Modele();

		Humain h1 = new Humain("Yanis");
		Humain h2 = new Humain("Maxime");
		Humain h3 = new Humain("Brady");
		Humain h4 = new Humain("Théo");

		bn.setTypePartie(TypePartie.CLASSIQUE);

		bn.ajouterJoueur(h1);
		bn.ajouterJoueur(h2);
		bn.ajouterJoueur(h3);
		bn.ajouterJoueur(h4);

		Joueur[] adversaires = h3.getAdversaires();
		for(int i=0; i<adversaires.length; i++)
		{
			System.out.println("Adversaire n°" + i + ": " + adversaires[i].toString());
		}

		h2.ajouterBateau(new Cuirasse());
		h2.ajouterBateau(new SousMarin());
		h2.ajouterBateau(new Zodiac());
		
		//ajout de Porte-Avion
		h2.ajouterBateau(new PorteAvion());
		

		Bateau[] bateauxH2 = h2.getBateaux();
		
		Position p0 = new Position(6,4);
		Position p1 = new Position(14,4);
		Position p2 = new Position(1,15);
		Position p3 = new Position(6,8);
		
		h2.placerBateau(bateauxH2[0], new Placement(p0, true));
		h2.placerBateau(bateauxH2[1], new Placement(p1, false));
		h2.placerBateau(bateauxH2[2], new Placement(p2, true));
		
		h2.placerBateau(bateauxH2[3], new Placement(p3, true));
		
		
		
		Bloc[] blocs = h2.getChampDeBataille().getEmplacements();

		/**
		 * Bloc Toucher(temporaire)
		 */
		blocs[1].setEtatBloc(EtatBloc.TOUCHE);
		bateauxH2[0].retirerPointDeVie();
		blocs[2].setEtatBloc(EtatBloc.TOUCHE);
		bateauxH2[0].retirerPointDeVie();
		blocs[5].setEtatBloc(EtatBloc.TOUCHE);
		bateauxH2[1].retirerPointDeVie();
		

		for(int i=0; i<blocs.length; i++)
		{
			System.out.println(blocs[i].getPosition());
		}

		System.out.println(h2.getChampDeBataille());
		
		System.out.println("Cuirasse : "+bateauxH2[0].getTaille());
		System.out.println("Point de Vie : "+bateauxH2[0].getPointDeVie());
		System.out.println("\nSous marin : "+bateauxH2[1].getTaille());
		System.out.println("Point de Vie : "+bateauxH2[1].getPointDeVie());
		System.out.println("\nZodiac : "+bateauxH2[2].getTaille());
		System.out.println("Point de Vie : "+bateauxH2[2].getPointDeVie());
		
		System.out.println("\nPosition Cuirasse : "+p0);
		System.out.println("Position Cuirasse : "+p1);
		System.out.println("\nDistance entre Cuirasse et Sous-Marin : "+p0.distance(p1)+" bloc (ou km pour les intimes).");
		
		System.out.println("\nDistance entre Cuirasse et Sous-Marin : "+p0.distance(p1)+" bloc (ou km pour les intimes).");
		
		int j;
		for(j=0;j<=blocs.length;j++)
		{
			//Cuirasse
			if(j<3)
				System.out.println("Cuirasse : "+blocs[j].getEtatBloc());
			//Sous-marin
			else if(j<7)
				System.out.println("Sous-Marin : "+blocs[j].getEtatBloc());
			//Zodiac
			else if(j<9)
				System.out.println("Zodiac :"+blocs[j].getEtatBloc());
			
			//Porte avion
			else if(j<13)
				System.out.println("Porte-Avion :"+blocs[j].getEtatBloc());
		}
	}
}
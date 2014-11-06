package BatailleNavale.Model;

import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;

import java.util.Observable;

/** 
 * Classe <code> Modele </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Modele extends Observable
{
	/**
	 * La partie de bataille navale
	 */
	private Partie partie;
	private Options options;

	/**
	 * Constructeur du Modele
	 */
	public Modele()
	{
		this.options = new Options();
	}

	/**
	 * initialise la partie de bataille navale
	 */
	public void initialiserPartie(Type_partie type)
	{
		this.partie = new Partie(type);
		setChanged();
		notifyObservers();
	}

	/**
	 * Accesseur de la partie
	 * @return partie
	 */
	public Partie getPartie()
	{
		return this.partie;
	}

	/**
	 * Accesseur des options
	 * @return options
	 */
	public Options getOptions()
	{
		return this.options;
	}

	public static void main(String[] args)
	{
		Modele bn = new Modele();

		Humain h1 = new Humain("Yanis", bn.getOptions());
		Humain h2 = new Humain("Maxime", bn.getOptions());
		Humain h3 = new Humain("Brady", bn.getOptions());
		Humain h4 = new Humain("Théo", bn.getOptions());

		bn.initialiserPartie(Type_partie.CLASSIQUE);

		bn.getPartie().ajouterJoueur(h1);
		bn.getPartie().ajouterJoueur(h2);
		bn.getPartie().ajouterJoueur(h3);
		bn.getPartie().ajouterJoueur(h4);

		Joueur[] adversaires = h3.getAdversaires();
		for(int i=0; i<adversaires.length; i++)
		{
			System.out.println("Adversaire n°" + i + ": " + ((Humain) adversaires[i]).toString());
		}

		h2.ajouterBateau(new Cuirasse());
		h2.ajouterBateau(new SousMarin());
		h2.ajouterBateau(new Zodiac());

		Bateau[] bateauxH2 = h2.getBateaux();

		h2.placerBateau(bateauxH2[0], new Placement(new Position(4,4), true));
		h2.placerBateau(bateauxH2[1], new Placement(new Position(14,6), false));
		h2.placerBateau(bateauxH2[2], new Placement(new Position(1,15), true));

		Bloc[] blocs = h2.getChampDeBataille().getEmplacements();

		blocs[1].setEtatBloc(Etat_bloc.TOUCHE);

		for(int i=0; i<blocs.length; i++)
		{
			System.out.println(blocs[i].getPosition());
		}

		System.out.println(h2.getChampDeBataille());
	}
}

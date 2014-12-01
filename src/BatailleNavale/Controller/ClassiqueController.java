package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

public class ClassiqueController extends JeuController
{

	public ClassiqueController(JeuView view, Modele modele)
	{
		super(view, modele);
	}

	public void tirerSurEnnemi(int x, int y, int indice_adversaire)
	{
		Position pos = new Position(x+1, y+1);
		Joueur joueur_courant = modele.getJoueurCourant();
		Joueur ennemi = joueur_courant.getAdversaires()[indice_adversaire];
		Tir t = new Tir(pos, ennemi);
		
		if(t.toucheBateau())
		{
			joueur_courant.tir(t);
			fenetre.changerVue(new JeuView(fenetre, modele));
			fenetre.afficherMessage(joueur_courant.getNom() + " vient de toucher " + ennemi.getNom() + " à la position " + pos, "Touché");	
			if(modele.estTermine())
				fenetre.afficherMessage("Partie terminé !", "#findugame");	

		}
		else
		{
			joueur_courant.tir(t);
			fenetre.afficherMessage("Raté", "Oups");	
			modele.joueurSuivant();
		}
	}
}
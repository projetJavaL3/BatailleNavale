package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public abstract class JeuController extends AbstractController implements MouseListener, KeyListener, ItemListener
{
	protected JeuView view;

	protected int posX, posY;
	protected boolean key_pret = false;

	protected Animation animation;
	protected ActionOrdi ao;
	
	public JeuController(JeuView view)
	{
		this.view = view;
	}
	
	public void tirerSurEnnemi(int x, int y, Joueur joueur_ennemi, boolean afficher_infos)
	{
		Position pos = new Position(x, y);
		Joueur joueur_courant = fenetre.getModele().getJoueurCourant();
		Tir t = new Tir(pos, joueur_ennemi);
		
		if(joueur_courant.tir(t))
		{
			if(fenetre.getModele().partieTermine())
			{
				envoyerModele();
				fenetre.changerVue(new FinView());
			}
			else
			{
				envoyerMessage("Votre adversaire vous a touché !");
				fenetre.changerVue(new MessageView("<html>Touché !<br/> Encore à vous de jouer !</html> ", new JeuView(), true));	
			}
		}
		else
		{
			int distance = joueur_ennemi.plusPetiteDistance(t) ;

			if(estConnecte())
			{
				AbstractView page_suivante = new MessageView("En attente du tir de l'adversaire...");
				fenetre.changerVue(new MessageView("Raté ! " + (afficher_infos?"Bateau le plus proche: "+distance:""), page_suivante, true));
	         
	            Thread jouer = new Thread() {
	                public void run()
	                {
	                    fenetre.getModele().joueurSuivant();

	                    envoyerModele();

	 					recevoirModele();

	 					fenetre.changerVue(new JeuView());
	                }
	            };

	            jouer.start();
			}
			else
			{
				fenetre.getModele().joueurSuivant();
				fenetre.changerVue(new MessageView("<html>Raté ! <br/>"+(afficher_infos?"Bateau le plus proche: "+distance:"")+ "<br/>Joueur suivant !</html> ", new JeuView(), (joueur_courant instanceof Ordinateur) || (fenetre.getModele().getJoueurSuivant() instanceof Ordinateur)));		
			}
		}
	}

	public void control()
	{
		if(fenetre.getModele().getJoueurCourant() instanceof Ordinateur)
		{
			ao = new ActionOrdi();
			ao.start();
		}

		if(fenetre.getModele().partieTermine())
		{
			fenetre.changerVue(new FinView());
		}
	}

	public void lancerAnimation(int x)
	{
 		posY = x;
		animation = new Animation();
		animation.start();
	}

	public void mouseEntered(MouseEvent event)
    {
    	if(fenetre.getModele().getJoueurCourant() instanceof Humain)
    		((Case) event.getSource()).selectionner();
	}

	public void mouseExited(MouseEvent event)
	{
		if(fenetre.getModele().getJoueurCourant() instanceof Humain)
			((Case) event.getSource()).deselectionner();
	}

	public void mouseClicked(MouseEvent event){}
	public void mouseReleased(MouseEvent event){}  
	public void mousePressed(MouseEvent event){}

	public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e){}

    public void itemStateChanged(ItemEvent e)
	{
		int num = view.getSelection().getSelectedIndex();
		view.setIndiceAdversaire(num);
		fenetre.changerVue(view);
	}     

    public class ActionOrdi extends Thread
	{
		public void run() 
		{
			long debut = System.currentTimeMillis();
			long fin = debut + 1500;
			while (System.currentTimeMillis() < fin){}

			Grille grille = view.getGrilleEnnemi();
			Ordinateur joueur_courant = (Ordinateur) fenetre.getModele().getJoueurCourant();
			Tir temp = null;

			for(int i=0; i<3; i++)
			{
				temp = joueur_courant.tirAleatoire();
				grille.getCase(temp.getPosition().getCoord_X()-1, temp.getPosition().getCoord_Y()-1).afficherCible();
				debut = System.currentTimeMillis();
				fin = debut + 500;
				while (System.currentTimeMillis() < fin){}
				grille.getCase(temp.getPosition().getCoord_X()-1, temp.getPosition().getCoord_Y()-1).clean();
			}

			tirerSurEnnemi(temp.getPosition().getCoord_X(), temp.getPosition().getCoord_Y(), temp.getJoueur(), false);
		}
	}

	public class Animation extends Thread
	{
		public void run()
		{
			Grille grille = view.getGrilleEnnemi();
			do
			{
				for(int i=0; i<fenetre.getModele().getOptions().getTailleGrille(); i++)
				{
					posX = i+1;
					grille.getCase(i,posY-1).selectionner();
					long debut = System.currentTimeMillis();
					long fin = debut + 200;
					while (System.currentTimeMillis() < fin){}
					grille.getCase(i,posY-1).deselectionner();
				}

			} while(true);
		}
	}
}
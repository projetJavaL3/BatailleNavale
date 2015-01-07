package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;

/**
 * Classe <code> JeuController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public abstract class JeuController extends AbstractController implements MouseListener, KeyListener, ItemListener
{
	/**
	 *	La vue a controler 
	 */
	protected JeuView view;

	/**
	 *	La position X de l'animation
	 */
	protected int posX;

	/**
	 *	La position Y de l'animation
	 */
	protected int posY;

	/**
	 *	Condition pour verifier les evenements clavier
	 */
	protected boolean key_pret = false;

	/**
	 * Animation en boucle sur la grille
	 */
	protected static Animation animation;

	/**
	 *	Animation pour l'action de l'ordi
	 */
	protected static ActionOrdi ao;
	
	/**
     * Construit un <code>JeuController</code> a partir d'une JeuView
     * @param view vue a controler
     */
	public JeuController(JeuView view)
	{
		this.view = view;
	}
	
	/**
	 *	Methode qui tire sur un ennemi a la position (x, y)
	 *	@param x position x
	 *	@param y position y
	 *	@param joueur_ennemi joueur cible du tir
	 *	@param afficher_infos true si on affiche la distance du bateau le plus proche false sinon
	 */
	public void tirerSurEnnemi(int x, int y, Joueur joueur_ennemi, boolean afficher_infos)
	{
		Position pos = new Position(x, y);
		Joueur joueur_courant = fenetre.getModele().getJoueurCourant();
		Tir t = new Tir(pos, joueur_ennemi);
		
		if(joueur_courant.tir(t))
		{
			if(fenetre.getModele().partieTermine())
			{
				if(estConnecte())
					envoyerModele();
				
				fenetre.changerVue(new FinView());
			}
			else
			{
				if(estConnecte())
					if(t.getBateau().getEtatBateau() == EtatBateau.TOUCHE)
						envoyerMessage("Votre adversaire vous a touché !");
					else
						envoyerMessage("Votre adversaire vous a coulé un bateau !");

				if(t.getBateau().getEtatBateau() == EtatBateau.TOUCHE)
					fenetre.changerVue(new MessageView("<html>Touché !<br/> Encore à vous de jouer !</html> ", new JeuView(), true));	
				else
					fenetre.changerVue(new MessageView("<html>Coulé !<br/> Encore à vous de jouer !</html> ", new JeuView(), true));
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

	/**
	 *	Controle de la vue 
	 */
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

	/**
	 *	Lancement de l'animation 
	 */
	public void lancerAnimation(int x)
	{
 		posY = x;
		animation = new Animation();
		animation.start();
	}

	public static void stopOrdi()
	{
		if(ao!=null)
			ao.stop();
	}

	/**
	 *	Action a executer lors du survol d'une case
	 */
	public void mouseEntered(MouseEvent event)
    {
    	if(fenetre.getModele().getJoueurCourant() instanceof Humain)
    		((Case) event.getSource()).selectionner();
	}

	/**
	 *	Action a executer lors de la fin du survol d'une case
	 */
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

    /**
     *	Action a executer lors du changement de la selection d'adversaire
     */
    public void itemStateChanged(ItemEvent e)
	{
		int num = view.getSelection().getSelectedIndex();
		view.setIndiceAdversaire(num);
		fenetre.changerVue(view);
	}     

	/**
	 *	Action de lors d'un coup joue par l'ordinateur
	 */
    public class ActionOrdi extends Thread
	{
		public void run() 
		{
			long debut = System.currentTimeMillis();
			long fin = debut + 2000;
			while (System.currentTimeMillis() < fin){}

			Grille grille = view.getGrilleEnnemi();
			Ordinateur joueur_courant = (Ordinateur) fenetre.getModele().getJoueurCourant();
			Tir temp = joueur_courant.tirFacile();

			boolean afficher_infos = (fenetre.getModele().getTypePartie() == TypePartie.RADAR) || (fenetre.getModele().getTypePartie() == TypePartie.ALERTE);
			boolean faire_animation = (fenetre.getModele().getTypePartie() == TypePartie.ARTILLERIE) || (fenetre.getModele().getTypePartie() == TypePartie.ALERTE);
			
			if(faire_animation)
			{
				lancerAnimation(temp.getPosition().getCoord_Y());
				while(posX!=temp.getPosition().getCoord_X()){}
				animation.stop();
			}
			else
			{
				for(int i=0; i<3; i++)
				{
					if(i==2)
						temp = joueur_courant.tirAleatoire();
					else
						temp = joueur_courant.tirFacile();

					grille.getCase(temp.getPosition().getCoord_X()-1, temp.getPosition().getCoord_Y()-1).afficherCible();
					debut = System.currentTimeMillis();
					fin = debut + 500;
					while (System.currentTimeMillis() < fin){}
					grille.getCase(temp.getPosition().getCoord_X()-1, temp.getPosition().getCoord_Y()-1).clean();
				}
			}

			tirerSurEnnemi(temp.getPosition().getCoord_X(), temp.getPosition().getCoord_Y(), temp.getJoueur(), afficher_infos);
		}
	}

	/**
	 *	Animation pour les modes de jeu comme (Artillerie ou Alerte)
	 */
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
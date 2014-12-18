package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;
import javax.swing.JButton;
import java.awt.Color;

public abstract class JeuController extends AbstractController implements MouseListener, KeyListener
{
	protected JeuView view;

	protected int posX, posY;
	protected boolean ordi_pret = true;
	protected boolean key_pret = false;

	protected Color couleur = new Color(112, 128, 144);

	protected Thread animation;
	
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
				fenetre.changerVue(new FinView());
			}
			else
			{
				fenetre.changerVue(new MessageView("<html>Touché !<br/> Encore à vous de jouer !</html> ", view, true));	
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
				fenetre.changerVue(new MessageView("<html>Raté ! <br/>"+(afficher_infos?"Bateau le plus proche: "+distance:"")+ "<br/>Joueur suivant !</html> ", view, (joueur_courant instanceof Ordinateur) || (fenetre.getModele().getJoueurSuivant() instanceof Ordinateur)));
				fenetre.getModele().joueurSuivant();
			}
		}
	}

	public void actionOrdinateur()
	{
		Thread tirOrdinateur = new Thread() 
		{
			public void run() 
			{
				ordi_pret = false;

				try{ Thread.sleep(1000); } catch(Exception e){}

				if(fenetre.getModele().getJoueurCourant() instanceof Ordinateur)
				{
					Ordinateur joueur_courant = (Ordinateur) fenetre.getModele().getJoueurCourant();
					
					Tir t = joueur_courant.tirAleatoire();

					tirerSurEnnemi(t.getPosition().getCoord_X(), t.getPosition().getCoord_Y(), t.getJoueur(), false);
				}

				ordi_pret = true;
			}
		};

		if(ordi_pret)
			tirOrdinateur.start();
	}

	public void loop(int x)
	{
 		posY = x;
		animation = new Thread() {
			public void run()
			{
				Grille grille = view.getGrilleEnnemi();
				do
				{
					for(int i=0; i<fenetre.getModele().getOptions().getTailleGrille(); i++)
					{
						posX = i+1;
						grille.getCase(i,posY-1).setBackground(new Color(255,0,0));
						
						 long debut = System.currentTimeMillis();
						 long fin = debut + 200;
						 while (System.currentTimeMillis() < fin){}
						grille.getCase(i,posY-1).setBackground(couleur);
					}
				} while(true);
			}
		};

		animation.start();
	}

	public void mouseEntered(MouseEvent event)
    {
    	JButton bouton = (JButton) event.getSource();
		bouton.setBackground(new Color(220,220,220));
	}

	public void mouseExited(MouseEvent event)
	{
		JButton bouton = (JButton) event.getSource();
    	bouton.setBackground(couleur);
	}

	public void mouseClicked(MouseEvent event){}
	public void mouseReleased(MouseEvent event){}  
	public void mousePressed(MouseEvent event){}

	public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
}
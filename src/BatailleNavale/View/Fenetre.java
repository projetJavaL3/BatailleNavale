package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.Dimension;

public class Fenetre extends JFrame 
{
	private MenuController controleur;
	private Modele modele;
	private AbstractView container;
	private JOptionPane boite_dialogue = new JOptionPane();
	private JMenuBar menubar = new JMenuBar();
	private JMenu menu_fichier = new JMenu("Fichier");
	private	JMenu menu_edition = new JMenu("Edition");
	private	JMenu menu_aide = new JMenu("Aide");
	private	JMenuItem item_fichier_menuPrincipal = new JMenuItem("Menu principal");
	private	JMenuItem item_fichier_quitter = new JMenuItem("Quitter");
	private	JMenuItem item_edition_annuler = new JMenuItem("Annuler");
	private	JMenuItem item_aide = new JMenuItem("A propos de Bataille Navale");
 	
	public Fenetre(Modele modele)
	{
		super("Bataille Navale");
		this.modele = modele;
		this.setSize(new Dimension(900, 640));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.initMenu();
		this.changerVue(new AccueilView(this, modele));
		this.setVisible(true);		
	}

	public void changerVue(AbstractView view)
	{
		this.container = view;
		this.setContentPane(container);
		this.getContentPane().revalidate();
	}

	public void afficherMessage(String message, String entete)
	{
		boite_dialogue.showMessageDialog(null, message, entete, JOptionPane.INFORMATION_MESSAGE);
		
	}
	

	public AbstractView getContainer()
	{
		return this.container;
	}

	/**
	 * Initialise notre Menu
	 */
	public void initMenu()
	{		
		this.controleur = new MenuController(this, modele);
		
		menu_fichier.add(item_fichier_menuPrincipal);
		menu_fichier.add(item_fichier_quitter);
		

		menu_edition.add(item_edition_annuler);
		menu_aide.add(item_aide);
		
		menubar.add(menu_fichier);
		menubar.add(menu_edition);
		menubar.add(menu_aide);
				
		this.setJMenuBar(menubar);

		item_fichier_menuPrincipal.addActionListener(controleur);
		item_fichier_quitter.addActionListener(controleur);
		item_aide.addActionListener(controleur);
	}

	public JMenuItem getItemMenuPrincipal()
	{
		return this.item_fichier_menuPrincipal;
	}

	public JMenuItem getItemQuitter()
	{
		return this.item_fichier_quitter;
	}
	public JMenuItem getItemAide()
	{
		return this.item_aide;
	}

	public static void main(String[] args)
	{
		Modele modele = new Modele();

		Humain h1 = new Humain("Yanis");
		Humain h2 = new Humain("Maxime");
		Humain h3 = new Humain("Brady");
		Humain h4 = new Humain("Théo");

		modele.setTypePartie(TypePartie.CLASSIQUE);

		modele.ajouterJoueur(h1);
		modele.ajouterJoueur(h2);
		modele.ajouterJoueur(h3);
		modele.ajouterJoueur(h4);

		h1.ajouterBateau(new Cuirasse());
		h1.ajouterBateau(new SousMarin());
		h1.ajouterBateau(new Zodiac());
		h1.ajouterBateau(new Zodiac());
		h1.ajouterBateau(new PorteAvion());

		h2.ajouterBateau(new Cuirasse());
		h2.ajouterBateau(new SousMarin());
		h2.ajouterBateau(new Zodiac());
		h2.ajouterBateau(new Zodiac());
		h2.ajouterBateau(new PorteAvion());

		h3.ajouterBateau(new Cuirasse());
		h3.ajouterBateau(new SousMarin());
		h3.ajouterBateau(new Zodiac());
		h3.ajouterBateau(new Zodiac());
		h3.ajouterBateau(new PorteAvion());

		h4.ajouterBateau(new Cuirasse());
		h4.ajouterBateau(new SousMarin());
		h4.ajouterBateau(new Zodiac());
		h4.ajouterBateau(new Zodiac());
		h4.ajouterBateau(new PorteAvion());

		h1.placementAleatoireFlotte();
		h2.placementAleatoireFlotte();
		h3.placementAleatoireFlotte();
		h4.placementAleatoireFlotte();

		Fenetre fenetre = new Fenetre(modele);
	}
}

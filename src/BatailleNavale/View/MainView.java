package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.Dimension;

public class MainView extends JFrame 
{

	private AbstractView container;
	private JOptionPane boite_dialogue = new JOptionPane();
	private JMenuBar menubar = new JMenuBar();
	private JMenu menu_fichier = new JMenu("Fichier");
	private	JMenu menu_edition = new JMenu("Edition");
	private	JMenuItem menu_fichier_demarrer = new JMenuItem("Démarrer");
	private	JMenuItem menu_fichier_fin = new JMenuItem("Fin");
	private	JMenuItem menu_edition_annuler = new JMenuItem("Annuler");

	public MainView(Modele modele)
	{
		super("Bataille Navale");
		this.setSize(new Dimension(900, 640));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.initMenu();
		this.changerVue(new JeuView(this, modele));
		this.setVisible(true);		
	}

	public void changerVue(AbstractView view)
	{
		this.container = view;
		this.setContentPane(container.getPanel());
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
		menu_fichier.add(menu_fichier_demarrer);
		menu_fichier.add(menu_fichier_fin);

		menu_edition.add(menu_edition_annuler);

		menubar.add(menu_fichier);
		menubar.add(menu_edition);
				
		this.setJMenuBar(menubar);
	}

	public static void main(String[] args)
	{
		Modele modele = new Modele();

		Humain h1 = new Humain("Yanis");
		Humain h2 = new Humain("Maxime");
		Humain h3 = new Humain("Brady");
		Humain h4 = new Humain("Théo");

		modele.commencerPartie(Type_partie.CLASSIQUE, h1, h2);

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

		MainView fen = new MainView(modele);
	}
}

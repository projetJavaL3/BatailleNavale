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
import javax.swing.JDialog;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Dimension;

/** 
 * Classe <code> Fenetre </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Fenetre extends JFrame 
{
	/**
	 *	Controleur du menu de la fenetre
	 */
	private MenuController controleur;

	/**
	 *	Modele de l'application
	 */
	private Modele modele;

	/**
	 *	Conteneur principal de la fenetre
	 */
	private AbstractView container;

	private JOptionPane jop = new JOptionPane();
	private JMenuBar menubar = new JMenuBar();
	private JMenu menu_fichier = new JMenu("Fichier");
        private JMenu menu_jouer = new JMenu("Jouer");
	//private JMenu menu_edition = new JMenu("Edition");
        private JMenu menu_jouer_local = new JMenu("En local");
        private JMenu menu_jouer_reseau = new JMenu("En réseau");
	private	JMenu menu_aide = new JMenu("Aide");
	private	JMenuItem item_fichier_menuPrincipal = new JMenuItem("Menu principal");
        private JMenuItem item_fichier_options = new JMenuItem("Options");
        private JMenuItem item_fichier_credits = new JMenuItem("Credits");
	private	JMenuItem item_fichier_quitter = new JMenuItem("Quitter");
	//private JMenuItem item_edition_annuler = new JMenuItem("Annuler");
        private JMenuItem item_jouer_local_classique = new JMenuItem("Classique");
        private JMenuItem item_jouer_local_radar = new JMenuItem("Radar");
        private JMenuItem item_jouer_local_artillerie = new JMenuItem("Artillerie");
        private JMenuItem item_jouer_local_alerte = new JMenuItem("Alerte");
        private JMenuItem item_jouer_reseau_creer_partie = new JMenuItem("Creer une partie");
        private JMenuItem item_jouer_reseau_rejoindre_partie = new JMenuItem("Rejoindre une partie");
	private	JMenuItem item_aide = new JMenuItem("A propos de Bataille Navale");
 	
 	/**
     * Construit une <code>Fenetre</code> a partir du modele
     *	@param modele modele de l'application
     */
	public Fenetre(Modele modele)
	{
		super("Bataille Navale");
		this.modele = modele;

		AbstractController.setFenetre(this);
		AbstractView.setFenetre(this);
	
		this.setSize(new Dimension(900, 640));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.initMenu();
		this.changerVue(new AccueilView());
		this.setVisible(true);		
	}

	/**
	 *	Change le conteneur principal de la fenetre
	 */
	public void changerVue(AbstractView view)
	{
		this.container = view;
		update();
		this.container.addListeners();
	}

	/**
	 *	Met a jour la fenetre
	 */
	public void update()
	{
		this.container.initPanel();
		this.setContentPane(container);
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}

	/**
	 *	Affiche une fentre de choix
	 *	@param message contenu du message
	 *	@param entete texte ecrit dans la barre de la boite de dialogue
	 */
	public int afficherChoixMessage(String message, String entete)
	{
		return jop.showConfirmDialog(null, message, entete, JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

	/**
	 *	@return modele
	 */
	public Modele getModele()
	{
		return this.modele;
	}

	/**
	 *	Modifie le modele 
	 */
	public void setModele(Modele modele)
	{
		this.modele = modele;
	}

	/**
	 *	Initialise les differents elements de la barre de menu
	 */
	public void initMenu()
	{		
		this.controleur = new MenuController();
		
		menu_fichier.add(item_fichier_menuPrincipal);
                menu_fichier.add(item_fichier_options);
                menu_fichier.add(item_fichier_credits);
		menu_fichier.add(item_fichier_quitter);
		
		//menu_edition.add(item_edition_annuler);
                menu_jouer.add(menu_jouer_local);
                menu_jouer.add(menu_jouer_reseau);
                menu_jouer_local.add(item_jouer_local_classique);
                menu_jouer_local.add(item_jouer_local_radar);
                menu_jouer_local.add(item_jouer_local_artillerie);
                menu_jouer_local.add(item_jouer_local_alerte);
                menu_jouer_reseau.add(item_jouer_reseau_creer_partie);
                menu_jouer_reseau.add(item_jouer_reseau_rejoindre_partie);
                
                
		menu_aide.add(item_aide);
		
		menubar.add(menu_fichier);
		menubar.add(menu_jouer);
		menubar.add(menu_aide);
				
		this.setJMenuBar(menubar);

		item_fichier_menuPrincipal.addActionListener(controleur);
                item_fichier_options.addActionListener(controleur);
                item_fichier_credits.addActionListener(controleur);
                item_jouer_local_classique.addActionListener(controleur);
                item_jouer_local_radar.addActionListener(controleur);
                item_jouer_local_artillerie.addActionListener(controleur);
                item_jouer_local_alerte.addActionListener(controleur);
                item_jouer_reseau_creer_partie.addActionListener(controleur);
                item_jouer_reseau_rejoindre_partie.addActionListener(controleur);
		item_fichier_quitter.addActionListener(controleur);
		item_aide.addActionListener(controleur);
	}

	/**
	 *	@return itemMenuPrincipal
	 */
	public JMenuItem getItemMenuPrincipal()
	{
		return this.item_fichier_menuPrincipal;
	}
        
        /**
         * 
         * @return item_fichier_options
         */
        public JMenuItem getItemOptions()
        {
            return this.item_fichier_options;
        }
        
        /**
         * 
         * @return item_fichier_credits
         */
        public JMenuItem getItemCredits()
        {
            return this.item_fichier_credits;
        }
        

	/**
	 *	@return itemQuitter
	 */
	public JMenuItem getItemQuitter()
	{
		return this.item_fichier_quitter;
	}
        
        /**
         * 
         * @return item_jouer_local_classique
         */
        public JMenuItem getItemClassique()
        {
            return this.item_jouer_local_classique;
        }
        
        /**
         * 
         * @return item_jouer_local_radar
         */
        public JMenuItem getItemRadar()
        {
            return this.item_jouer_local_radar;
        }
        
        /**
         * 
         * @return item_jouer_local_artillerie
         */
        public JMenuItem getItemArtillerie()
        {
            return this.item_jouer_local_artillerie;
        }
        
        /**
         * 
         * @return item_jouer_local_alerte
         */
        public JMenuItem getItemAlerte()
        {
            return this.item_jouer_local_alerte;
        }
        
        /**
         * 
         * @return item_jouer_reseau_creer_partie
         */
        public JMenuItem getItemCreerPartie()
        {
            return this.item_jouer_reseau_creer_partie;
        }
        
        /**
         * 
         * @return item_jouer_reseau_rejoindre_partie
         */
        public JMenuItem getItemRejoindrePartie()
        {
            return this.item_jouer_reseau_rejoindre_partie;
        }

	/**
	 *	@return itemAide
	 */
	public JMenuItem getItemAide()
	{
		return this.item_aide;
	}

	/**
	 *	@return conteneur principal
	 */
	public AbstractView getContainer()
	{
		return container;
	}

	public static void main(String[] args)
	{
		Modele modele = new Modele();
		Fenetre fenetre = new Fenetre(modele);
	}
}

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
	private	JMenu menu_edition = new JMenu("Edition");
	private	JMenu menu_aide = new JMenu("Aide");
	private	JMenuItem item_fichier_menuPrincipal = new JMenuItem("Menu principal");
	private	JMenuItem item_fichier_quitter = new JMenuItem("Quitter");
	private	JMenuItem item_edition_annuler = new JMenuItem("Annuler");
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

	/**
	 *	@return itemMenuPrincipal
	 */
	public JMenuItem getItemMenuPrincipal()
	{
		return this.item_fichier_menuPrincipal;
	}

	/**
	 *	@return itemQuitter
	 */
	public JMenuItem getItemQuitter()
	{
		return this.item_fichier_quitter;
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

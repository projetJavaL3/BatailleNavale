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

public class Fenetre extends JFrame 
{
	private MenuController controleur;
	private Modele modele;
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

	public void changerVue(AbstractView view)
	{
		this.container = view;
		update();
		this.container.addListeners();
	}

	public void update()
	{
		this.container.initPanel();
		this.setContentPane(container);
		this.getContentPane().revalidate();
		this.getContentPane().repaint();
	}

	public int afficherChoixMessage(String message, String entete)
	{
		return jop.showConfirmDialog(null, message, entete, JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

	public Modele getModele()
	{
		return this.modele;
	}

	public void setModele(Modele modele)
	{
		this.modele = modele;
	}

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
		Fenetre fenetre = new Fenetre(modele);
	}
}

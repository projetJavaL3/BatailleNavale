package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.Dimension;

public class MainView extends JFrame 
{

	private AbstractView container;

	public MainView(Modele modele)
	{
		super("Bataille Navale");
		this.setSize(new Dimension(1000,680));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.initMenu();
		this.changerVue(new TypeView(this, modele));
		this.setVisible(true);		
	}

	public void changerVue(AbstractView view)
	{
		this.container = view;
		this.setContentPane(container.getPanel());
	}
	
	/**
	 * Initialise notre Menu
	 */
	public void initMenu()
	{
		JMenuBar menubar = new JMenuBar();
		JMenu menu1 = new JMenu("Fichier");
		JMenu menu2 = new JMenu("Edition");
		JMenuItem demarrer = new JMenuItem("Démarrer");
		JMenuItem fin = new JMenuItem("Fin");
		JMenuItem annuler = new JMenuItem("Annuler");
		
		menu1.add(demarrer);
		menu1.add(fin);
		menu2.add(annuler);

		menubar.add(menu1);
		menubar.add(menu2);
				
		this.setJMenuBar(menubar);
	}

	public static void main(String[] args)
	{
		Modele modele = new Modele();
		MainView fen = new MainView(modele);
	}
}

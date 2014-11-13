package BatailleNavale.View;

import BatailleNavale.Model.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JFrame;

import java.awt.Dimension;

public class MainView extends JFrame implements Observer
{

	private AbstractView container;

	public MainView(Modele modele)
	{
		super("Bataille Navale");
		modele.addObserver(this);
		this.setSize(new Dimension(700,540));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.initMenu();
		this.changerVue(new AccueilView(this, modele));
		this.setVisible(true);		
	}

	public void update(Observable obs, Object o)
	{
		container.update(obs, o);
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

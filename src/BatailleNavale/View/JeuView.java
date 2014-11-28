package BatailleNavale.View;

import BatailleNavale.Controller.*;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;

import java.util.Observer;
import java.util.Observable;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JeuView extends AbstractView implements Observer
{		
	private ClassiqueController controleur;

	private Joueur joueur_courant;
	private Joueur[] adversaires;
	private Tir[] tirs;
	private int taille = 10;

	private Color couleur_en_cours = new Color(0,0,0);

	private JPanel[][] flotte = new JPanel[taille][taille];
	private JPanel[][] flotte_ennemi = new JPanel[taille][taille];
	private JComboBox<Joueur> selection_adversaire = new JComboBox<Joueur>();
	private JPanel panel_flotte_ennemi = new JPanel();
	private JPanel panel_flotte = new JPanel();
	private JLabel lblMaFlotte, lblFlotteEnnemi, lblScore, lblAction;

	public JeuView(MainView view, Modele modele)
	{	
		super(view, modele);
		controleur = new ClassiqueController(view, modele);
		modele.addObserver(this);
		initPanel();
	}
	
	public void initPanel()
	{	
		panel.removeAll();

		joueur_courant = modele.getJoueurCourant();
		adversaires = joueur_courant.getAdversaires();
		tirs = joueur_courant.getTirsSurJoueur();

		panel_flotte.setBounds(67, 187, 316, 357);
		panel_flotte.setBackground(new Color(0,0,0,125));
		panel_flotte.setLayout(new GridLayout(taille, taille, 0, 0));
	
		panel_flotte_ennemi.setBounds(504, 187, 316, 357);
		panel_flotte_ennemi.setBackground(new Color(0,0,0,125));
		panel_flotte_ennemi.setLayout(new GridLayout(taille, taille, 0, 0));

		lblMaFlotte = new JLabel(joueur_courant.getNom());
		lblMaFlotte.setBounds(67, 160, 200, 15);
		
		lblFlotteEnnemi  = new JLabel("Flotte ennemi:");
		lblFlotteEnnemi.setBounds(504, 160, 142, 15);

		selection_adversaire = new JComboBox<Joueur>(adversaires);
		selection_adversaire.setBounds(700, 155, 119, 24);
		
		lblScore = new JLabel("Score: XXXpts");
		lblScore.setBounds(67, 556, 184, 15);
		
		lblAction = new JLabel("Selectionner un adversaire et une position sur son champs de bataille: ");
		lblAction.setBounds(67, 87, 614, 24);

		this.panel.add(lblAction);
		this.panel.add(lblMaFlotte);
		this.panel.add(lblFlotteEnnemi);
		this.panel.add(lblScore);

		this.panel.add(selection_adversaire);

		this.panel.add(panel_flotte);
		this.panel.add(panel_flotte_ennemi);

		afficherFlotte();
		afficherFlotteEnnemi();

		selection_adversaire.addItemListener(controleur);

		panel.revalidate();
	}

	public void afficherFlotte()
	{
		panel_flotte.removeAll();

		for(int i=0; i<taille; i++)
		{
			for(int j=0; j<taille; j++)
			{
				flotte[i][j] = new JPanel();
				flotte[i][j].setBackground(new Color(112, 128, 144));

				if(joueur_courant.dansTirsSurJoueur(new Position(i+1, j+1)))
					flotte[i][j].setBackground(new Color(255 ,255, 0));

				if(joueur_courant.getChampDeBataille().existeBloc(new Position(i+1, j+1)))
					if(joueur_courant.getChampDeBataille().getBloc(new Position(i+1, j+1)).getEtatBloc() != Etat_bloc.TOUCHE)
						flotte[i][j].setBackground(new Color(0 ,255, 0));
					else 
						flotte[i][j].setBackground(new Color(255 ,0, 0));
					
				flotte[i][j].setEnabled(false);
				flotte[i][j].setBorder(new LineBorder(new Color(200,200,200), 1, false));

				panel_flotte.add(flotte[i][j]);	
			}
		}

		panel_flotte.revalidate();
	}

	public void afficherFlotteEnnemi()
	{
		Joueur ennemi = adversaires[selection_adversaire.getSelectedIndex()];
	
		panel_flotte_ennemi.removeAll();

		for(int i=0; i<taille; i++)
		{
			for(int j=0; j<taille; j++)
			{
				flotte_ennemi[i][j] = new JPanel();
				flotte_ennemi[i][j].setBackground(new Color(112, 128, 144));
				flotte_ennemi[i][j].setBorder(new LineBorder(new Color(200,200,200), 1, false));
				
				panel_flotte_ennemi.add(flotte_ennemi[i][j]);

				if(ennemi.dansTirsSurJoueur(new Position(i+1, j+1)))
					flotte_ennemi[i][j].setBackground(new Color(255 ,255, 0));

				if(ennemi.getChampDeBataille().existeBloc(new Position(i+1, j+1)))
					if(ennemi.getChampDeBataille().getBloc(new Position(i+1, j+1)).getEtatBloc() == Etat_bloc.TOUCHE)
						flotte_ennemi[i][j].setBackground(new Color(255 ,0, 0));

				flotte_ennemi[i][j].addMouseListener(controleur);
			}		
		}		

		panel_flotte_ennemi.revalidate();
	}

	public int getTaille()
	{
		return taille;
	}

	public JPanel[][] getFlotteEnnemi()
	{
		return this.flotte_ennemi;
	}

	public JComboBox getSelectionAdversaire()
	{
		return selection_adversaire;
	}

	public void finSurvol(int x, int y)
	{
		JPanel case_event = flotte_ennemi[x][y];
		case_event.setBackground(couleur_en_cours);
	}

	public void survol(int x, int y)
	{
		JPanel case_event = flotte_ennemi[x][y];
		couleur_en_cours = case_event.getBackground();
		case_event.setBackground(new Color(0, 0, 255));
	}

	public void update(Observable obs, Object o)
	{
		initPanel();
		lblMaFlotte.setText("*" + modele.getJoueurCourant().getNom() + "*");
		panel.revalidate();
	}
}

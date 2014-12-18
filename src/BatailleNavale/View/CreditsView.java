package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Controller.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class CreditsView extends AbstractView
{
	private CreditsController controleur;
	
	private final JLabel titre = new JLabel ("Crédits : ");
		
	private final Bouton b_Brady = new Bouton("Brady");
	private final Bouton b_Theo = new Bouton("Théo");
	private final Bouton b_Maxime = new Bouton("Maxime");
	private final Bouton b_Yanis = new Bouton("Yanis");
	
	private final Panneau description = new Panneau();
	private final Panneau panneauBrady = new Panneau();
	private final Panneau panneauTheo = new Panneau();
	private final Panneau panneauMaxime = new Panneau();
	private final Panneau panneauYanis = new Panneau();
	
	private final Bouton b_retour = new Bouton("Retour");
		
	public CreditsView()
	{	
		super();	
		this.controleur = new CreditsController(this);
	}
	
	public void initPanel()
	{	
		this.removeAll();
		
		titre.setBounds(360, 20, 500, 50);
		titre.setForeground(Color.BLACK);
		titre.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 40));
			
		description.setBounds(100, 80, 700, 150);
		description.add(new JLabel("Projet de Bataille Navale réalisé par 4 élèves de L3 à l'Université d'Evry."));
		
		panneauBrady.setBounds(25, 350, 200, 200);
		panneauBrady.add(new JLabel("Après un IUT\n d'Informatique\n et une\n année de Web Machin\n Brady décide de\n reprendre ses études.\nActuellement en L3\n Informatique à\n l'Université\nd'Evry Val D'essonne\n il est l'un des\n Cerveau de ce Projet"));
		panneauBrady.setVisible(false);
		
		panneauTheo.setBounds(240, 350, 200, 200);
		panneauTheo.add(new JLabel("<html> Passionée d'Informatique <br/>" +
			"depuis le collège c'est tout naturellement que Théo <br/>" +
			" choisit de s'orienter vers l'Informatique. <br/>" +
			" Excellent dans la majorité de ses domaines, <br/>" +
			" il fut l'un des acteurs majeurs de ce projet </html>"));
		panneauTheo.setVisible(false);
		
		
		panneauMaxime.setBounds(455, 350, 200, 200);
		panneauMaxime.add(new JLabel("blablablablabalblabla blablablabablabla bblablablablabalblabla blablablabablabla blablablablabalblabla blablablabablabla"));
		panneauMaxime.setVisible(false);
		
		panneauYanis.setBounds(675, 350, 200, 200);
		panneauYanis.add(new JLabel("blablablablabalblabla blablablabablabla bblablablablabalblabla blablablabablabla blablablablabalblabla blablablabablabla"));
		panneauYanis.setVisible(false);
		
		b_Brady.setBounds(75, 255, 100, 90);
		b_Theo.setBounds(290, 255, 100, 90);
		b_Maxime.setBounds(505, 255, 100, 90);
		b_Yanis.setBounds(725, 255, 100, 90);
		b_retour.setBounds(10, 520, 100, 50);
		
		this.add(b_retour);
		this.add(titre);
		this.add(description);
		this.add(b_Brady);
		this.add(b_Theo);
		this.add(b_Maxime);
		this.add(b_Yanis);
		this.add(panneauBrady);
		this.add(panneauTheo);
		this.add(panneauMaxime);
		this.add(panneauYanis);
	}
	
	public void addListeners()
	{
		b_Brady.addActionListener(controleur);
		b_Theo.addActionListener(controleur);
		b_Maxime.addActionListener(controleur);
		b_Yanis.addActionListener(controleur);
		b_retour.addActionListener(controleur);
	}

	public void removeListeners()
	{
		b_Brady.removeActionListener(controleur);
		b_Theo.removeActionListener(controleur);
		b_Maxime.removeActionListener(controleur);
		b_Yanis.removeActionListener(controleur);
		b_retour.removeActionListener(controleur);
	}

	public Bouton getBoutonBrady()
	{
		return b_Brady;
	}
	
	public Panneau getPanneauBrady()
	{
		return panneauBrady;
	}
	
	public Bouton getBoutonTheo()
	{
		return b_Theo;
	}
	
	public Panneau getPanneauTheo()
	{
		return panneauTheo;
	}

	public Bouton getBoutonMaxime()
	{
		return b_Maxime;
	}
	
	public Panneau getPanneauMaxime()
	{
		return panneauMaxime;
	}
	
	public Bouton getBoutonYanis()
	{
		return b_Yanis;
	}
	
	public Panneau getPanneauYanis()
	{
		return panneauYanis;
	}
	
	public Bouton getBoutonRetour()
	{
		return b_retour;
	}
}

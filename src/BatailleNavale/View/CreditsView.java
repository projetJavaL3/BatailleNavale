package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Controller.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

/** 
 * Classe <code> CreditsView </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class CreditsView extends AbstractView
{
	/**
	 *	Controleur de la vue
	 */
	private CreditsController controleur;
	
	private final JLabel titre = new JLabel ("Crédits  ");
		
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
	
	/**
     * Construit une <code>CreditsView</code> 
     */
	public CreditsView()
	{	
		super();	
		this.controleur = new CreditsController(this);
	}

	/**
	 *	Initialise les composants de la vue
	 */
	public void initPanel()
	{	
		this.removeAll();
		
		titre.setBounds(360, 20, 500, 50);
		titre.setForeground(Color.BLACK);
		titre.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 40));
			
		description.setBounds(100, 80, 700, 150);
		description.add(new JLabel("<html>Projet de Bataille Navale réalisé par 4 élèves de L3 à l'Université d'Evry Val 						D'Essonne.<br/>"+
					"Ce projet a était réalisé en Java dans le cadre d'un cours de Programmations orienté objet<br/>"+
					"Il a de plus était conçu selon le Modèle MVC : Modèle Vue Controleur.<html> "));
		
		panneauBrady.setBounds(25, 350, 200, 200);
		panneauBrady.add(new JLabel("<html>Après un IUT d'Informatique<br/>" + 
						"et une année de Web Machin<br/>" +
						 "Brady décide de<br/>"+ 
						"reprendre ses études.<br/>" +
						 "Actuellement en L3 Informatique<br/>" +
						" à l'Université <br/>"+
						"d'Evry Val D'essonne<br/>"+
						"il est l'un des<br/>"+
						"Cerveau de ce Projet </html>"));
		panneauBrady.setVisible(false);
		
		panneauTheo.setBounds(240, 350, 200, 200);
		panneauTheo.add(new JLabel("<html> Passionée d'Informatique <br/>" +
			"depuis le collège c'est tout naturellement que Théo <br/>" +
			" choisit de s'orienter vers l'Informatique. <br/>" +
			" Excellent dans la majorité de ses domaines, <br/>" +
			" il fut l'un des acteurs majeurs de ce projet </html>"));
		panneauTheo.setVisible(false);
		
		
		panneauMaxime.setBounds(455, 350, 200, 200);
		panneauMaxime.add(new JLabel("<html> Friand de nouvelles technologies,<br/>" +
					"Maxime apprécie tout particulièrement le langage Java.<br/>" +
					"D'un naturelle curieux et <br/>" +
					"Excellent <br/>" +
					"il fut l'un des acteurs majeurs de ce projet </html>"));
		panneauMaxime.setVisible(false);
		
		panneauYanis.setBounds(675, 350, 200, 200);
		panneauYanis.add(new JLabel("<html> Après un Bac Scientifique <br/>" +
			"c'est par hasard que Yanis se <br/>" +
			"dirige vers l'Informatique<br/>" +
			" Excellent dans la majorité de ses domaines, <br/>" +
			" il fut l'un des acteurs majeurs de ce projet </html>"));
		panneauYanis.setVisible(false);
		
		b_Brady.setBounds(75, 255, 100, 90);
		b_Theo.setBounds(290, 255, 100, 90);
		b_Maxime.setBounds(505, 255, 100, 90);
		b_Yanis.setBounds(725, 255, 100, 90);
		b_retour.setBounds(10, 550, 100, 50);
		
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

	/**
	 *	Ajoute les Listeners a la vue
	 */	
	public void addListeners()
	{
		b_Brady.addActionListener(controleur);
		b_Theo.addActionListener(controleur);
		b_Maxime.addActionListener(controleur);
		b_Yanis.addActionListener(controleur);
		b_retour.addActionListener(controleur);
	}

	/** 
	 *	Supprime les Listeners a la vue
	 */
	public void removeListeners()
	{
		b_Brady.removeActionListener(controleur);
		b_Theo.removeActionListener(controleur);
		b_Maxime.removeActionListener(controleur);
		b_Yanis.removeActionListener(controleur);
		b_retour.removeActionListener(controleur);
	}

	/**
	 *	@return boutonBrady
	 */
	public Bouton getBoutonBrady()
	{
		return b_Brady;
	}

	/**
	 *	@return panneauBrady
	 */
	public Panneau getPanneauBrady()
	{
		return panneauBrady;
	}

	/**
	 *	@return boutonTheo
	 */
	public Bouton getBoutonTheo()
	{
		return b_Theo;
	}

	/**
	 *	@return panneauTheo
	 */
	public Panneau getPanneauTheo()
	{
		return panneauTheo;
	}

	/**
	 *	@return boutonMaxime
	 */
	public Bouton getBoutonMaxime()
	{
		return b_Maxime;
	}

	/**
	 *	@return panneauMaxime
	 */
	public Panneau getPanneauMaxime()
	{
		return panneauMaxime;
	}

	/**
	 *	@return boutonYanis
	 */
	public Bouton getBoutonYanis()
	{
		return b_Yanis;
	}

	/**
	 *	@return panneauYanis
	 */
	public Panneau getPanneauYanis()
	{
		return panneauYanis;
	}

	/**
	 *	@return boutonRetour
	 */
	public Bouton getBoutonRetour()
	{
		return b_retour;
	}
}

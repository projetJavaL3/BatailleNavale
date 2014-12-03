package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Controller.*;

import java.util.Observer;
import java.util.Observable;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class CreditsView extends AbstractView
{
	private CreditsController controleur;
	
	//private int indice = 0;
	
	private final JLabel txt_credit = new JLabel ("Crédits : ");
		
	private final Bouton b_Brady = new Bouton("Brady");
	private final Bouton b_Theo = new Bouton("Théo");
	private final Bouton b_Maxime = new Bouton("Maxime");
	private final Bouton b_Yanis = new Bouton("Yanis");
	
	private final JTextArea text_Brady = new JTextArea(1,2);
	private final JTextArea text_Theo = new JTextArea();
	private final JTextArea text_Maxime = new JTextArea();
	private final JTextArea text_Yanis = new JTextArea();
	
	private final Bouton b_retour = new Bouton("Retour");
		
	public CreditsView(Fenetre fenetre, Modele modele)
	{	
		super(fenetre, modele);
		this.controleur = new CreditsController(this, modele);
		initPanel();
	}
	
	public void initPanel()
	{	
		this.setLayout(null);
		
		txt_credit.setBounds(360, 20, 500, 50);
		txt_credit.setForeground(Color.white);
		txt_credit.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 40));
			
		JTextArea text = new JTextArea("	Projet de Bataille Navale réalisé par 4 élèves de L3 à l'Université d'Evry" );
		text.setBounds(100,80,700,150);
		text.setBackground(Color.black);
		text.setForeground(Color.white);
		
		text_Brady.setText(" Après un IUT\n d'Informatique\n et une\n année de Web Machin\n Brady décide de\n reprendre ses études.\nActuellement en L3\n Informatique à\n l'Université\nd'Evry Val D'essonne\n il est l'un des\n Cerveau de ce Projet");
		text_Brady.setEditable(false);
		text_Brady.setBackground(Color.black);
		text_Brady.setForeground(Color.white);
		text_Brady.setBounds(25, 350, 150, 200);
		text_Brady.setVisible(false);	
		
		text_Theo.setText("Passionée d'Informatique depuis le collège c'est tout naturellement que Théo choisit de s'orienter vers l'Informatique.Excellent dans la majorité de ses domaines il fut l'un des acteurs majeurs de ce projet");
		text_Theo.setEditable(false);
		text_Theo.setBackground(Color.black);
		text_Theo.setForeground(Color.white);
		text_Theo.setBounds(255, 350, 150, 200);
		text_Theo.setVisible(false);
		
		text_Maxime.setText("blablablablabalblabla blablablabablabla bblablablablabalblabla blablablabablabla blablablablabalblabla blablablabablabla");
		text_Maxime.setEditable(false);
		text_Maxime.setBackground(Color.black);
		text_Maxime.setForeground(Color.white);
		text_Maxime.setBounds(505, 350, 150, 200);
		text_Maxime.setVisible(false);
		
		text_Yanis.setText("blablablablabalblabla blablablabablabla bblablablablabalblabla blablablabablabla blablablablabalblabla blablablabablabla");
		text_Yanis.setEditable(false);
		text_Yanis.setBackground(Color.black);
		text_Yanis.setForeground(Color.white);
		text_Yanis.setBounds(725, 350, 150, 200);
		text_Yanis.setVisible(false);
		 
		
		b_Brady.setBounds(30, 255, 100, 90);
		b_Theo.setBounds(255, 255,100, 90);
		b_Maxime.setBounds(505, 255, 100, 90);
		b_Yanis.setBounds(755, 255, 100, 90);
		b_retour.setBounds(10,560,100,50);
		
		b_Brady.addActionListener(controleur);
		b_Theo.addActionListener(controleur);
		b_Maxime.addActionListener(controleur);
		b_Yanis.addActionListener(controleur);
		b_retour.addActionListener(controleur);
		
		this.add(b_retour);
		this.add(txt_credit);
		this.add(text);
		this.add(b_Brady);
		this.add(b_Theo);
		this.add(b_Maxime);
		this.add(b_Yanis);
		this.add(text_Brady);
		this.add(text_Theo);
		this.add(text_Maxime);
		this.add(text_Yanis);
	}
	
	public Bouton getBoutonBrady()
	{
		return b_Brady;
	}
	
	public JTextArea getTextBrady()
	{
		return text_Brady;
	}
	
	public Bouton getBoutonTheo()
	{
		return b_Theo;
	}
	
	public JTextArea getTextTheo()
	{
		return text_Theo;
	}

	public Bouton getBoutonMaxime()
	{
		return b_Maxime;
	}
	
	public JTextArea getTextMaxime()
	{
		return text_Maxime;
	}
	
	public Bouton getBoutonYanis()
	{
		return b_Yanis;
	}
	
	public JTextArea getTextYanis()
	{
		return text_Yanis;
	}
	
	public Bouton getBoutonRetour()
	{
		return b_retour;
	}
	
	/*public boolean isVisible()
	{
		boolean b = true;
		if((boolean) text_Brady.setVisible(true) == b)
			return b;
		else
			return false;
	}*/
}

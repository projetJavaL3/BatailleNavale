package BatailleNavale.View;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Controller.*;

import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AccueilView extends AbstractView
{
	private AbstractController controleur;

	private JLabel texte;

	public AccueilView(MainView view, Modele modele)
	{
		super(view, modele);
		this.controleur = new ClassiqueController(view, modele);
		initPanel();
	}

	public void initPanel()
	{
		texte = new JLabel("Bienvenue dans la Bataille Navale");
		
		final Boutton b_jouer = new Boutton("Jouer");
		final Boutton b_options = new Boutton("Options");
		final Boutton b_credit = new Boutton("Credits");
		
		this.panel.setLayout(null);
		
		b_jouer.setBounds(500, 400, 170, 50);
		b_jouer.addMouseListener(new MouseAdapter()
		{
			
			public void mouseEntered(MouseEvent e) {
				b_jouer.setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 22));
				b_jouer.setBounds(510,400,170,50);
			}
			
			public void mouseExited(MouseEvent e) {
				b_jouer.setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 14));
				b_jouer.setBounds(500, 400, 170, 50);
			}
			
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		
		b_options.setBounds(500, 460, 170, 50);
		b_options.addMouseListener(new MouseAdapter()
		{
			
			public void mouseEntered(MouseEvent e) {
				b_options.setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 22));
				b_options.setBounds(510,460,170,50);
			}
			
			public void mouseExited(MouseEvent e) {
				b_options.setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 14));
				b_options.setBounds(500, 460, 170, 50);
			}
			
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		b_credit.setBounds(500, 520, 170, 50);
		b_credit.addMouseListener(new MouseAdapter()
		{
			
			public void mouseEntered(MouseEvent e) {
				b_credit.setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 22));
				b_credit.setBounds(510,520,170,50);
			}
			
			public void mouseExited(MouseEvent e) {
				b_credit.setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 14));
				b_credit.setBounds(500, 520, 170, 50);
			}
			
			public void mouseClicked(MouseEvent e) {
				
			}
		});

		this.panel.add(texte);
		this.panel.add(b_jouer);
		this.panel.add(b_options);
		this.panel.add(b_credit);
		
	}

	public void update(Observable obs, Object o){}

}

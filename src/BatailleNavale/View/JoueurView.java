package BatailleNavale.View;

import BatailleNavale.Controller.JoueurController;
import BatailleNavale.Model.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Observer;
import java.util.Observable;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;

public class JoueurView extends AbstractView 
{
    private JoueurController controleur;
    private int nb_joueurs = 2;
    private JLabel label_joueur;
    private JLabel label_type;
    private ArrayList<JLabel> label_j;
    private ArrayList<JComboBox> combo_j;
    private JPanel panel_entete, panel_valider;
    private ArrayList<JPanel> panel_j;
    private JButton valider, ajouter_joueur;
    
    public JoueurView (Fenetre fenetre, Modele modele)
    {	
		super(fenetre, modele);
                controleur = new JoueurController(this,modele);
                initPanel();
    }
    
    public void initPanel()
    {
        this.setBounds(0, 0, 900, 640);
        //Panneau entête
        label_joueur = new JLabel("Joueur");
        label_type = new JLabel("Type");
        panel_entete = new JPanel();
        panel_entete.add(label_joueur);
        panel_entete.add(label_type);
        this.add(panel_entete);
        
        //Création et ajout au paneau principal des panneaux des joueurs
        label_j = new ArrayList<JLabel>();
        combo_j = new ArrayList<JComboBox>();
        panel_j = new ArrayList<JPanel>();

        for(int i=0; i<nb_joueurs;i++)
        {
            label_j.add(new JLabel((i+1)+""));
            combo_j.add(new JComboBox());
            combo_j.get(i).addItem("Humain");
            combo_j.get(i).addItem("IA");
            panel_j.add(new JPanel());
            panel_j.get(i).add(label_j.get(i));
            panel_j.get(i).add(combo_j.get(i));
            this.add(panel_j.get(i));
        }
        
        //Panneau valider     
        ajouter_joueur = new JButton ("Ajouter joueur");
        ajouter_joueur.addActionListener(controleur);
        valider = new JButton("Valider");
        panel_valider = new JPanel();
        panel_valider.add(valider);
        panel_valider.add(ajouter_joueur);
        this.add(panel_valider);
    }
    
    public JButton getBoutonAjouterJoueur(){
        return ajouter_joueur;
    }
    
    public void ajouterJoueur(){
        nb_joueurs++;
        //initPanel();
    }
    
    public int getNbJoueurs(){
        return nb_joueurs;
    }
    
    
}
package BatailleNavale.View;

import BatailleNavale.Controller.JoueurController;
import BatailleNavale.Model.*;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Observer;
import java.util.Observable;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;

public class JoueurView extends AbstractView {

    private JoueurController controleur;
    private int nb_joueurs = 2;
    private JLabel label_joueur;
    private JLabel label_type;
    private ArrayList<JLabel> label_j;
    private ArrayList<JComboBox> combo_j;
    private JPanel panel_entete, panel_valider;
    private ArrayList<JPanel> panel_j;
    private Bouton valider, ajouter_joueur;

    public JoueurView(Fenetre fenetre, Modele modele) {
        super(fenetre, modele);
        controleur = new JoueurController(this, modele);
        initPanel();
    }

    public void initPanel() {
        
        this.setBounds(0, 0, 900, 640);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //Panneau entête
        label_joueur = new Label("Joueur",20);
        label_type = new Label("Type",20);
        panel_entete = new JPanel();
        panel_entete.add(label_joueur);
        panel_entete.add(label_type);
        panel_entete.setOpaque(false);
        this.add(panel_entete);

        //Création et ajout au paneau principal des panneaux des joueurs
        label_j = new ArrayList<JLabel>();
        combo_j = new ArrayList<JComboBox>();
        panel_j = new ArrayList<JPanel>();

        for (int i = 0; i < nb_joueurs; i++) {
            label_j.add(new Label("Joueur "+(i + 1) + "",16));
            combo_j.add(new JComboBox());
            combo_j.get(i).addItem("Humain");
            combo_j.get(i).addItem("IA");
            panel_j.add(new JPanel());
            panel_j.get(i).add(label_j.get(i));
            panel_j.get(i).add(combo_j.get(i));
            panel_j.get(i).setOpaque(false);
            this.add(panel_j.get(i));
        }

        //Panneau valider     
        ajouter_joueur = new Bouton("Ajouter joueur");
        ajouter_joueur.addActionListener(controleur);
        valider = new Bouton("Valider");
        ajouter_joueur.setBounds(175,10,200,60);
        valider.setBounds(525,10,200,60);
        panel_valider = new JPanel();
        panel_valider.add(valider);
        panel_valider.add(ajouter_joueur);
        panel_valider.setBounds(0,480,900,160);
        panel_valider.setOpaque(false);
        panel_valider.setLayout(null);
        this.add(panel_valider);
    }

    public Bouton getBoutonAjouterJoueur() {
        return ajouter_joueur;
    }
    

    public void ajouterJoueur() {       
        this.remove(panel_valider);
        label_j.add(new Label("Joueur "+(nb_joueurs+1),16));
        combo_j.add(new JComboBox());
        combo_j.get(nb_joueurs).addItem("Humain");
        combo_j.get(nb_joueurs).addItem("IA");
        panel_j.add(new JPanel());
        panel_j.get(nb_joueurs).add(label_j.get(nb_joueurs));
        panel_j.get(nb_joueurs).add(combo_j.get(nb_joueurs));
        panel_j.get(nb_joueurs).setOpaque(false);
        this.add(panel_j.get(nb_joueurs));     
        this.revalidate();
        this.add(panel_valider);
        this.repaint();
        nb_joueurs++;
    }

    public int getNbJoueurs() {
        return nb_joueurs;
    }

}

package BatailleNavale.View;

import BatailleNavale.Controller.*;
import BatailleNavale.Model.*;

import java.util.Observer;
import java.util.Observable;

import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.IconUIResource;

import java.awt.Color;
import java.awt.Font;
import java.awt.Component;

/** 
 * Classe <code> JoueurView </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class JoueurView extends AbstractView
{
    /**
     *  Controleur de la vue
     */
    private JoueurController controleur;

    private int nb_joueurs = 2;

    private ArrayList<JPanel> panel_j;
    private ArrayList<JLabel> label_j;
    private ArrayList<JComboBox<String>> combo_j;
    private JPanel panel_entete = new JPanel();
    private JPanel panel_valider = new JPanel();
    private Label label_joueur = new Label("Joueur", 40);
    private Label label_type = new Label("Type",40);
    private Bouton valider = new Bouton("Valider");
    private Bouton ajouter_joueur = new Bouton("Ajouter joueur");
    private Bouton supprimer_joueur = new Bouton("Supprimer joueur");

    /**
     * Construit une <code>JoueurView</code> 
     */
    public JoueurView()
    {
        super();
        controleur = new JoueurController(this);
    }

    /**
     *  Initialise les composants de la vue
     */
    public void initPanel() 
    {
        removeAll();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	
	label_joueur.setForeground(Color.BLACK);
	label_joueur.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 40));
	
	label_type.setForeground(Color.BLACK);
	label_type.setFont(new Font("Droid Serif", Font.ITALIC | Font.BOLD , 40));
        
        //Panneau entête
        panel_entete.add(label_joueur);
        panel_entete.add(label_type);
        panel_entete.setOpaque(false);
        this.add(panel_entete);

        //Création et ajout au paneau principal des panneaux des joueurs
        label_j = new ArrayList<JLabel>();
        combo_j = new ArrayList<JComboBox<String>>();
        panel_j = new ArrayList<JPanel>();

        for (int i = 0; i < nb_joueurs; i++)
        {
            label_j.add(new Label("Joueur "+(i + 1) + "",16));
            combo_j.add(new JComboBox<String>());
            combo_j.get(i).addItem("Humain");
            combo_j.get(i).addItem("Ordinateur");
            panel_j.add(new JPanel());
            panel_j.get(i).add(label_j.get(i));
            panel_j.get(i).add(combo_j.get(i));
            panel_j.get(i).setOpaque(false);
            this.add(panel_j.get(i));
        }

        //Panneau valider     
        ajouter_joueur.setBounds(40,10,200,60);
        supprimer_joueur.setBounds(290,10,300,60);
        valider.setBounds(640,10,200,60);
        panel_valider.setLayout(null);
        panel_valider.add(valider);
        panel_valider.add(ajouter_joueur);
        panel_valider.add(supprimer_joueur);
        panel_valider.setBounds(0,480,900,160);
        panel_valider.setOpaque(false);
        this.add(panel_valider);
    }

    /**
     *  Ajoute les Listeners a la vue
     */
    public void addListeners()
    {
        ajouter_joueur.addActionListener(controleur);
        supprimer_joueur.addActionListener(controleur);
        valider.addActionListener(controleur);
    }

    /** 
     *  Supprime les Listeners a la vue
     */
    public void removeListeners()
    {
        ajouter_joueur.removeActionListener(controleur);
        supprimer_joueur.removeActionListener(controleur);
        valider.removeActionListener(controleur);
    }

    /**
     *  @return le nombre de joueurs
     */
    public int getNbJoueurs()
    {
        return nb_joueurs;
    }

    /**
     *  @return le type du joueur i
     */
    public String getTypeJoueur(int i)
    {
        return (String) combo_j.get(i).getSelectedItem();
    }

    /**
     *  @return boutonAjouterJoueur
     */
    public Bouton getBoutonAjouterJoueur()
    {
        return ajouter_joueur;
    }

    /**
     *  @return boutonSupprimerJoueur
     */
    public Bouton getBoutonSupprimerJoueur()
    {
        return supprimer_joueur;
    }

    /**
     *  @return boutonValider
     */
    public Bouton getBoutonValider()
    {
        return valider;
    }

    /**
     *  Ajoute un joueur a la vue
     */
    public void ajouterJoueur()
    {       
        this.remove(panel_valider);
        label_j.add(new Label("Joueur "+(nb_joueurs+1),16));
        combo_j.add(new JComboBox<String>());
        combo_j.get(nb_joueurs).addItem("Humain");
        combo_j.get(nb_joueurs).addItem("Ordinateur");
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

    /**
     *  Supprime un joueur de la vue
     */
    public void supprimerJoueur()
    {
        this.remove(panel_j.get(nb_joueurs-1));
        panel_j.remove(panel_j.get(nb_joueurs-1));
        this.revalidate();
        this.repaint();
        nb_joueurs--;
    }
}

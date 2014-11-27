

package BatailleNavale.View;

import BatailleNavale.Controller.AbstractController;
import BatailleNavale.Model.Modele;
import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.util.Observable;
import javax.swing.*;

public class JoueurView extends AbstractView {
    private Modele modele; 
    private JLabel label_joueur;
    private JLabel label_type;
    private JLabel[] label_j;
    private JComboBox[] combo_j;
    private JPanel panel_entete, panel_valider;
    private JPanel[] panel_j;
    private JButton valider;
    
    public JoueurView (MainView view, Modele modele) {	
		super(view, modele);
		initPanel();
    }
    
    public void initPanel() {
        this.panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        int nb_joueurs = 10;
        //Panneau entête
        label_joueur = new JLabel("Joueur");
        label_type = new JLabel("Type");
        panel_entete = new JPanel();
        panel_entete.add(label_joueur);
        panel_entete.add(label_type);
        this.panel.add(panel_entete);
        
        //Creation et ajout au panneau principal des panneaux des joueurs
        label_j = new JLabel[nb_joueurs];
        combo_j = new JComboBox[nb_joueurs];
        panel_j = new JPanel[nb_joueurs];
        String[] data = {"Humain","IA"};
        for(int i=0; i<nb_joueurs;i++){
            label_j[i] = new JLabel((i+1)+"");
            combo_j[i] = new JComboBox(data);
            panel_j[i] = new JPanel();
            panel_j[i].add(label_j[i]);
            panel_j[i].add(combo_j[i]);
            this.panel.add(panel_j[i]);
        }
        
        //Panneau valider
        valider = new JButton("Valider");
        panel_valider = new JPanel();
        panel_valider.add(valider);
        this.panel.add(panel_valider);
        
        
        
    }

    protected void update(Observable obs, Object o) {}


}
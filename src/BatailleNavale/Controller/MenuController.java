package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;
import javax.swing.JOptionPane;

public class MenuController extends AbstractController implements ActionListener
{
    private int choix;

    public MenuController(Fenetre fenetre, Modele modele)
    {
        super(fenetre, modele);
    }

    public void actionPerformed(ActionEvent arg0) 
    {
    	if(arg0.getSource() == fenetre.getItemMenuPrincipal())
        {
            fenetre.changerVue(new AccueilView(fenetre, modele));
        }
        else if(arg0.getSource() == fenetre.getItemQuitter())
        {
            choix = fenetre.afficherChoixMessage("Êtes-vous sur de vouloir quitter ?", "Attention");
            if(choix == JOptionPane.YES_OPTION)
                System.exit(0);
        }
        else if(arg0.getSource() == fenetre.getItemAide())
        {
            fenetre.changerVue(new AideView(fenetre, modele));
        }
	}  
}

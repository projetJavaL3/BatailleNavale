package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;
import javax.swing.JOptionPane;

public class MenuController extends AbstractController implements ActionListener
{
    private int choix;

    public void actionPerformed(ActionEvent arg0) 
    {
    	if(arg0.getSource() == fenetre.getItemMenuPrincipal())
        {
            fenetre.getModele().setTypePartie(TypePartie.CLASSIQUE);
            fenetre.changerVue(new AccueilView());
        }
        else if(arg0.getSource() == fenetre.getItemQuitter())
        {
            quitter();
        }
	}  

    public void quitter()
    {
        choix = fenetre.afficherChoixMessage("Êtes-vous sur de vouloir quitter ?", "Attention");
        if(choix == JOptionPane.YES_OPTION)
            System.exit(0);
    }
}

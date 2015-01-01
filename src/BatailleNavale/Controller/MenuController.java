package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 * Classe <code> MenuController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class MenuController extends AbstractController implements ActionListener
{
    /**
     *  Choix de l'utilisateur
     */
    private int choix;

    /**
     *  Les differentes actions a executer selon les boutons utilises
     */
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

    /**
     *  On demande a l'utilisateur s'il veut quitter l'application
     */
    public void quitter()
    {
        choix = fenetre.afficherChoixMessage("Êtes-vous sur de vouloir quitter ?", "Attention");
        if(choix == JOptionPane.YES_OPTION)
            System.exit(0);
    }
}

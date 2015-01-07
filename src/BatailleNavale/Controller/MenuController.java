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
    private static int choix;

    /**
     *  Les differentes actions a executer selon les boutons utilises
     */
    public void actionPerformed(ActionEvent arg0) 
    {
    	if(arg0.getSource() == fenetre.getItemMenuPrincipal())
        {
            socket = null;
            fenetre.changerVue(new AccueilView());
        }
        else if(arg0.getSource() == fenetre.getItemQuitter())
        {
            quitter();
        }
        else if (arg0.getSource() == fenetre.getItemOptions())
        {
            fenetre.changerVue(new OptionsView());
        }
        else if (arg0.getSource() == fenetre.getItemCredits())
        {
            fenetre.changerVue(new CreditsView());
        }
        else if (arg0.getSource() == fenetre.getItemClassique())
        {
            socket = null;
            fenetre.getModele().setTypePartie(TypePartie.CLASSIQUE);
            fenetre.changerVue(new JoueurView());
        }
        else if (arg0.getSource() == fenetre.getItemRadar())
        {
            socket = null;
            fenetre.getModele().setTypePartie(TypePartie.RADAR);
            fenetre.changerVue(new JoueurView()); 
        }
        else if (arg0.getSource() == fenetre.getItemArtillerie())
        {
            socket = null;
            fenetre.getModele().setTypePartie(TypePartie.ARTILLERIE);
            fenetre.changerVue(new JoueurView());
        }
        else if (arg0.getSource() == fenetre.getItemAlerte())
        {
            socket = null;
            fenetre.getModele().setTypePartie(TypePartie.ALERTE);
            fenetre.changerVue(new JoueurView());
        }
        else if (arg0.getSource() == fenetre.getItemCreerPartie())
        {
            ModeReseauController.connexionClient();
        }
        else if (arg0.getSource() == fenetre.getItemRejoindrePartie())
        {
            fenetre.changerVue(new AdresseView());
        }  
    }  

    /**
     *  On demande a l'utilisateur s'il veut quitter l'application
     */
    public static void quitter()
    {
        choix = fenetre.afficherChoixMessage("Êtes-vous sur de vouloir quitter ?", "Attention");
        if(choix == JOptionPane.YES_OPTION)
            System.exit(0);
    }
}

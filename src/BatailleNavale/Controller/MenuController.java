package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class MenuController extends AbstractController implements ActionListener
{

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
            fenetre.afficherMessage("Etes-vous sûr de vouloir quitter ?", "Attention");
            System.exit(0);
        }
	}  
}

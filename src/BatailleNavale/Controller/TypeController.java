package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class TypeController extends AbstractController implements ActionListener
{

    private TypeView view;

    public TypeController(TypeView view, Modele modele)
    {
        super(view.getFenetre(), modele);
        this.view = view;
    }

    public void actionPerformed(ActionEvent arg0) 
    {
    	if(arg0.getSource() == view.getBoutonClassique())
    	{
    		// action à faire lorsque l'on clique sur le bouton classique
            fenetre.afficherMessage("Vous allez commencer une partie classique !", "Début de partie");
    	}
    	else if(arg0.getSource() == view.getBoutonRadar())
    	{
    		// action à faire lorsque l'on clique sur le bouton radar
            fenetre.afficherMessage("Vous allez commencer une partie radar !", "Début de partie");
    	}
    	else if(arg0.getSource() == view.getBoutonArtillerie())
    	{
    		// action à faire lorsque l'on clique sur le bouton artillerie
            fenetre.afficherMessage("Vous allez commencer une partie artillerie !", "Début de partie");
    	}
        else if(arg0.getSource() == view.getBoutonAlerte())
        {
            // action à faire lorsque l'on clique sur le bouton alerte
            fenetre.afficherMessage("Vous allez commencer une partie alerte !", "Début de partie");
        }
	}
}

package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class TypeController extends AbstractController implements ActionListener
{

	public TypeController(MainView view, Modele modele)
	{
		super(view, modele);
	}

    public void actionPerformed(ActionEvent arg0) 
    {
    	TypeView container = (TypeView) view.getContainer();
    	if(arg0.getSource() == container.getBoutonClassique())
    	{
    		// action à faire lorsque l'on clique sur le bouton classique
            view.afficherMessage("Vous allez commencer une partie classique !", "Début de partie");
    	}
    	else if(arg0.getSource() == container.getBoutonRadar())
    	{
    		// action à faire lorsque l'on clique sur le bouton radar
            view.afficherMessage("Vous allez commencer une partie radar !", "Début de partie");
    	}
    	else if(arg0.getSource() == container.getBoutonArtillerie())
    	{
    		// action à faire lorsque l'on clique sur le bouton artillerie
            view.afficherMessage("Vous allez commencer une partie artillerie !", "Début de partie");
    	}
        else if(arg0.getSource() == container.getBoutonAlerte())
        {
            // action à faire lorsque l'on clique sur le bouton alerte
            view.afficherMessage("Vous allez commencer une partie alerte !", "Début de partie");
        }
	}
}

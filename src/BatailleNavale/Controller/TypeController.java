package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class TypeController extends AbstractController implements ActionListener
{

    private TypeView view;

    public TypeController(TypeView view)
    {
        this.view = view;
    }

    public void actionPerformed(ActionEvent arg0) 
    {
    	if(arg0.getSource() == view.getBoutonClassique())
    	{
            fenetre.getModele().setTypePartie(TypePartie.CLASSIQUE);
    		fenetre.changerVue(new JoueurView());
    	}
    	else if(arg0.getSource() == view.getBoutonRadar())
    	{
    		fenetre.getModele().setTypePartie(TypePartie.RADAR);
            fenetre.changerVue(new JoueurView());
    	}
    	else if(arg0.getSource() == view.getBoutonArtillerie())
    	{
    		fenetre.getModele().setTypePartie(TypePartie.ARTILLERIE);
            fenetre.changerVue(new JoueurView());
    	}
        else if(arg0.getSource() == view.getBoutonAlerte())
        {
            fenetre.getModele().setTypePartie(TypePartie.ALERTE);
            fenetre.changerVue(new JoueurView());
        }
    	else if(arg0.getSource() == view.getBoutonRetour())
    	{	
    		fenetre.changerVue(new ChoixModeView());
    	}
	}
}

package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class JoueurController extends AbstractController implements ActionListener
{
    private JoueurView view;

    public JoueurController(JoueurView view, Modele modele) {
        super(view.getFenetre(), modele);
        this.view = view;
    }
    
    public void actionPerformed(ActionEvent arg0) 
    {
        if(arg0.getSource() == view.getBoutonAjouterJoueur()){
            view.ajouterJoueur();
            System.out.println("C'est rentré dans action performed: nbjoueur = "+view.getNbJoueurs());
        }
    }
}

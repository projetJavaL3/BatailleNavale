package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

/**
 * Classe <code> MessageController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class MessageController extends AbstractController implements ActionListener
{
    /**
     *  La vue a controler
     */
    private MessageView view;

    /**
     * Construit un <code>MessageController</code> a partir d'une MessageView
     * @param view vue a controler
     */
	public MessageController(MessageView view)
	{
       this.view = view;
	}

    /**
     *  Les differentes actions a executer selon les boutons utilises
     */
    public void actionPerformed(ActionEvent arg0) 
    {
        if(arg0.getSource() == view.getBouton())
        {
            vueSuivante();
        }
	}  

    /**
     *  On change de vue pour la vue suivante
     */
    public void vueSuivante()
    {
        AbstractView vue_suivante = view.getVueSuivante();

        try
        {
            vue_suivante.removeListeners();
        }
        catch(Exception e){}

        fenetre.changerVue(vue_suivante);
    }
}
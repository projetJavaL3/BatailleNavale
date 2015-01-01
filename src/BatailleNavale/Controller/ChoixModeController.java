package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

/**
 * Classe <code> ArtillerieController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class ChoixModeController extends AbstractController implements ActionListener
{
    /**
     *  La vue a controler
     */
    private ChoixModeView view;

    /**
     * Construit un <code>ChoixModeController</code> a partir d'une ChoixModeView
     * @param view vue a controler
     */
	public ChoixModeController(ChoixModeView view)
	{
		this.view = view;
	}

    /**
     *  Les differentes actions a executer selon les boutons utilises
     */
    public void actionPerformed(ActionEvent arg0) 
    {
    	if(arg0.getSource() == view.getBoutonLocal())
    	{
    		fenetre.changerVue(new TypeView());
    	}
    	else if(arg0.getSource() == view.getBoutonReseau())
    	{
    		fenetre.changerVue(new ModeReseauView());
    	}
    	else if(arg0.getSource() == view.getBoutonRetour())
    	{
    		fenetre.changerVue(new AccueilView());
    	}
	}  
}

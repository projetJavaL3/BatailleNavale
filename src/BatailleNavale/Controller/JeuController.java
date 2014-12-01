package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public abstract class JeuController extends AbstractController implements ActionListener, ItemListener
{

	protected JeuView view;

	public JeuController(JeuView view, Modele modele)
	{
		super(view.getFenetre(), modele);
		this.view = view;
	}

	public abstract void tirerSurEnnemi(int x, int y, int indice_adversaire);   

	public void itemStateChanged(ItemEvent e)
	{
		//vue.afficherFlotteEnnemi();
	}     

	public void actionPerformed(ActionEvent arg0)
    {
 		Grille grille = view.getGrilleEnnemi();
        for(int i=0; i<grille.getTaille(); i++)
        	for(int j=0; j<grille.getTaille(); j++)
        		if(arg0.getSource() == grille.getCase(i, j))
        			tirerSurEnnemi(i, j, 0);
    }
}
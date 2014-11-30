package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class ClassiqueController extends AbstractController implements MouseListener, ItemListener
{

	public ClassiqueController(MainView view, Modele modele)
	{
		super(view, modele);
	}

	public void tirerSurEnnemi(int x, int y, int indice_adversaire)
	{
		Position pos = new Position(x+1, y+1);
		Joueur joueur_courant = modele.getJoueurCourant();
		Joueur ennemi = joueur_courant.getAdversaires()[indice_adversaire];
		
		joueur_courant.tir(new Tir(pos, ennemi));
		modele.joueurSuivant();
		view.afficherMessage(joueur_courant.getNom() + " vient de tirer sur " + ennemi.getNom() + " à la position " + pos + "\nJoueur suivant: " + modele.getJoueurCourant().getNom(), "Tir effectué");	
	}

	public Position caseTouched(MouseEvent event)
	{
		JeuView vue = (JeuView) view.getContainer();
 
        for(int i=0; i<vue.getTaille(); i++)
        	for(int j=0; j<vue.getTaille(); j++)
        		if(event.getSource() == vue.getFlotteEnnemi()[i][j])
        			return new Position(i, j);
        return null;
	}

    public void mouseClicked(MouseEvent event) 
    {
    	Position pcase = caseTouched(event);
    	JeuView vue = (JeuView) view.getContainer();
    	int indice_adversaire = vue.getSelectionAdversaire().getSelectedIndex();

		tirerSurEnnemi(pcase.getCoord_X(), pcase.getCoord_Y(), indice_adversaire);
	}

    public void mouseEntered(MouseEvent event)
    {
    	Position pcase = caseTouched(event);
    	JeuView vue = (JeuView) view.getContainer();
		vue.mouseIn(pcase.getCoord_X(), pcase.getCoord_Y());
    }

	public void mouseExited(MouseEvent event)
	{
		Position pcase = caseTouched(event);
		JeuView vue = (JeuView) view.getContainer();
		vue.mouseOut(pcase.getCoord_X(), pcase.getCoord_Y());
	}

	public void mousePressed(MouseEvent event){}
	public void mouseReleased(MouseEvent event){}   

	public void itemStateChanged(ItemEvent e)
	{
		JeuView vue = (JeuView) view.getContainer();
		vue.afficherFlotteEnnemi();
	}     
}
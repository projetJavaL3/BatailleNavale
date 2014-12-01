package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

public abstract class AbstractController
{
	protected Modele modele;
	protected Fenetre fenetre;

	public AbstractController(Fenetre fenetre, Modele modele)
	{
		this.fenetre = fenetre;
		this.modele = modele;
	}
}
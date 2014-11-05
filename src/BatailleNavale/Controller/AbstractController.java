package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

public abstract class AbstractController
{
	protected Modele modele;
	protected MainView view;

	public AbstractController(MainView view, Modele modele)
	{
		this.view = view;
		this.modele = modele;
	}
	
}
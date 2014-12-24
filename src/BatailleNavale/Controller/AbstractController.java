package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class AbstractController
{
	protected static Fenetre fenetre;
	
	protected static Socket socket;
	protected static ObjectInputStream in;
	protected static ObjectOutputStream out;

	public static void setFenetre(Fenetre fen)
	{
		fenetre = fen;
	}

	public static boolean estConnecte()
	{
		return (socket!=null && socket.isConnected());
	}

	public static void recevoirModele()
	{
		try
		{
			Object objetRecu;                     
	        do
	        {
	            objetRecu = in.readObject();
	            
	            if(objetRecu instanceof String)
	            	fenetre.changerVue(new MessageView((String) objetRecu, fenetre.getContainer(), true));

	        } while(!(objetRecu instanceof Modele));
	                    
	        fenetre.setModele((Modele) objetRecu);
		}
		catch(Exception e)
		{
			fenetre.changerVue(new MessageView("Connexion rompu !", new AccueilView(), true));
		}
	}

	public static void envoyerModele()
	{
		try
		{
			out.writeObject(fenetre.getModele());
		   	out.flush();	
	   	}
		catch(Exception e)
		{
			fenetre.changerVue(new MessageView("Connexion rompu !", new AccueilView(), true));
		}				
	}

	public static void envoyerMessage(String message)
	{
		try
		{
			out.writeObject(message);
		   	out.flush();	
	   	}
		catch(Exception e)
		{
			fenetre.changerVue(new MessageView("Connexion rompu !", new AccueilView(), true));
		}				
	}
}
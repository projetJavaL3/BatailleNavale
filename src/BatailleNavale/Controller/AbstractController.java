package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.View.*;

import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe <code> AbstractController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public abstract class AbstractController
{
	/**
	 *	Fenetre static des controleurs
	 */
	protected static Fenetre fenetre;
	
	/**
	 *	Socket pour la partie reseau
	 */
	protected static Socket socket;

	/**
	 *	L'inputStream pour lire des objets sur le socket
	 */
	protected static ObjectInputStream in;

	/**
	 *	L'outputStream pour envoyer des objets sur le socket
	 */
	protected static ObjectOutputStream out;

	/**
	 *	Permet de changer statiquement la fenetre des controleurs
	 */
	public static void setFenetre(Fenetre fen)
	{
		fenetre = fen;
	}

	/**
	 *	@return l'etat de la connection - true si connecte - false sinon
	 */
	public static boolean estConnecte()
	{
		return (socket!=null && socket.isConnected());
	}

	/** 
	 *	Permet de lire dans le inputStream un objet de type Modele
	 *	(methode commune a tous les controleurs)
	 */
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

	/** 
	 *	Permet d'ecrire dans le outputStream un objet de type Modele
	 *	(methode commune a tous les controleurs)
	 */
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

	/** 
	 *	Permet d'ecrire dans le outputStream un objet de type String
	 *	(methode commune a tous les controleurs)
	 */
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
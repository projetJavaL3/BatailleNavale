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

	public static void ajouterBateaux(Joueur j)
	{
		for(int i=0; i<fenetre.getModele().getOptions().getFlotte().length; i++)
        {
            Bateau bateau = fenetre.getModele().getOptions().getFlotte()[i];
                   
            if(bateau instanceof Cuirasse)
                j.ajouterBateau(new Cuirasse());
            else if(bateau instanceof SousMarin)
                j.ajouterBateau(new SousMarin());
            else if(bateau instanceof Zodiac)
                j.ajouterBateau(new Zodiac());
             else
                j.ajouterBateau(new PorteAvion());
        }
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
}
package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.Model.Joueur.*;
import BatailleNavale.Model.Flotte.*;
import BatailleNavale.View.*;

import java.awt.event.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.net.*;
import java.util.*;

public class ModeReseauController extends AbstractController implements ActionListener
{
    private ModeReseauView view;

    private final int serverPort = 9999;
    private String serverName = "127.0.0.1";
    
    public ModeReseauController(ModeReseauView view)
    {
        this.view = view;
    }

    public void actionPerformed(ActionEvent arg0) 
    {
        if(arg0.getSource() == view.getBoutonCreer())
        {
            InetAddress ia = null;
            
            try
            {                            
                Enumeration interfaces = NetworkInterface.getNetworkInterfaces();

                while (interfaces.hasMoreElements())
                {
                    NetworkInterface ni;
                    Enumeration adresses;

                    ni = (NetworkInterface) interfaces.nextElement();

                    if(ni.getDisplayName().equals("wlan0"))
                   {
                        adresses = ni.getInetAddresses();
                        while (adresses.hasMoreElements())
                        {
                            ia = (InetAddress) adresses.nextElement();
                        }
                    }
                }

            } catch(Exception e){}

            serverName = ia.toString().replace("/", "");

            fenetre.changerVue(new MessageView("<html>Attente d'un joueur en cours...<br/>Adresse I.P. de la partie: " + serverName + "<html>"));

            Thread connexion = new Thread() {
                public void run() 
                {
                    try
                    {
                        ServerSocket s = new ServerSocket(serverPort);
                        
                        socket = s.accept();
                        
                        out = new ObjectOutputStream(socket.getOutputStream());
                        out.flush();
                        
                        in = new ObjectInputStream(socket.getInputStream());

                        fenetre.getModele().setTypePartie(TypePartie.ALERTE);

                        Humain h1 = new Humain("Joueur 1", fenetre.getModele().getOptions().getTailleGrille());
                        Humain h2 = new Humain("Joueur 2", fenetre.getModele().getOptions().getTailleGrille());

                        fenetre.getModele().ajouterJoueur(h1);
                        fenetre.getModele().ajouterJoueur(h2);

                        ajouterBateaux(h1); 
                        ajouterBateaux(h2);

                        fenetre.changerVue(new MessageView("Connexion réussie !", new PlacementView(), true));
                    } 
                    catch(Exception e){}
                }
            };

            connexion.start();

        }
        else if(arg0.getSource() == view.getBoutonRejoindre())
        {
            fenetre.changerVue(new AdresseView());
        }
        else if(arg0.getSource() == view.getBoutonRetour())
        {
            fenetre.changerVue(new ChoixModeView());
        }
    }
}

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

/**
 * Classe <code> ModeReseauController </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class ModeReseauController extends AbstractController implements ActionListener
{
    /**
     *  La vue a controler
     */
    private ModeReseauView view;

    /**
     *  Le numero de port a utiliser pour la connexion
     */
    private final int serverPort = 9999;

    /**
     *  L'IP du serveur pour la connexion
     */
    private String serverName = "127.0.0.1";
    
    /**
     * Construit un <code>ModeController</code> a partir d'une ModeReseauView
     * @param view vue a controler
     */
    public ModeReseauController(ModeReseauView view)
    {
        this.view = view;
    }

    /**
     *  Les differentes actions a executer selon les boutons utilises
     */
    public void actionPerformed(ActionEvent arg0) 
    {
        if(arg0.getSource() == view.getBoutonCreer())
        {
           connexionClient();
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

    /**
     *  On creer un socket serveur et on attend la connexion d'un client
     */
    public void connexionClient()
    {
        serverName = adresseIP().replace("/", "");

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

                    fenetre.changerVue(new MessageView("Connexion réussie !", new TypeView(), true));
                } 
                catch(Exception e){}
            }
        };

        connexion.start();
    }

    /**
     *  Adresse IP du Serveur
     *  @return adresse IP wlan0 du serveur
     */
    public String adresseIP()
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

        return ia.toString();
    }
}

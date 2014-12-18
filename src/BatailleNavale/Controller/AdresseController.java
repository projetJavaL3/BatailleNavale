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

public class AdresseController extends AbstractController implements ActionListener
{
    private AdresseView view;

    private final int serverPort = 9999;
    private  String serverName;
    
    public AdresseController(AdresseView view)
    {
        this.view = view;
    }

    public void actionPerformed(ActionEvent arg0) 
    {
        if(arg0.getSource() == view.getBoutonValider())
        {
            int ip1 = (int) view.getSpinner1().getValue();
            int ip2 = (int) view.getSpinner2().getValue();
            int ip3 = (int) view.getSpinner3().getValue();
            int ip4 = (int) view.getSpinner4().getValue();

            serverName = ip1 + "." + ip2 + "." + ip3 + "." + ip4;

            fenetre.changerVue(new MessageView("Recherche de la partie..."));

            Thread connexion = new Thread() {
                public void run() 
                {
                    try 
                    {
                        socket = new Socket(serverName, serverPort);

                        out = new ObjectOutputStream(socket.getOutputStream());
                        out.flush();

                        in = new ObjectInputStream(socket.getInputStream());

                        fenetre.changerVue(new MessageView("Connexion réussie !", new MessageView("Attente du placement..."), true));

                        recevoirModele();

                        fenetre.changerVue(new PlacementView());

                    } catch(Exception e){}
                }
            };

            connexion.start();
        }
        else if(arg0.getSource() == view.getBoutonRetour())
        {
            fenetre.changerVue(new ModeReseauView());
        }
    }
}

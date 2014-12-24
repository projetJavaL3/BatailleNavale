package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class MessageController extends AbstractController implements ActionListener
{
    private MessageView view;

	public MessageController(MessageView view)
	{
       this.view = view;
	}

    public void actionPerformed(ActionEvent arg0) 
    {
        if(arg0.getSource() == view.getBouton())
        {
            vueSuivante();
        }
	}  

    public void vueSuivante()
    {
        fenetre.changerVue(view.getVueSuivante());
    }
}

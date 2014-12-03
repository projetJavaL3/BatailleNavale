package BatailleNavale.Controller;

import BatailleNavale.Model.*;
import BatailleNavale.View.*;

import java.awt.event.*;

public class CreditsController extends AbstractController implements ActionListener
{
	private CreditsView view;
	private int indiceb = 0 ;
	private int indicem = 0 ;
	private int indicet = 0 ;
	private int indicey = 0 ;
	

	public CreditsController(CreditsView view, Modele modele)
	{
        	super(view.getFenetre(), modele);
		this.view = view;
	}

    	public void actionPerformed(ActionEvent arg0) 
	{
    		if(arg0.getSource() == view.getBoutonBrady() && (indiceb % 2) == 0 )
    			{
				indiceb++;
    				view.getTextBrady().setVisible(true);
    			}
		else if(arg0.getSource() == view.getBoutonBrady() && (indiceb % 2) != 0)
			{	
				indiceb++;
				view.getTextBrady().setVisible(false);
			}
    		else if(arg0.getSource() == view.getBoutonTheo()  && (indicet % 2) == 0)
    			{	
				indicet++;
    				view.getTextTheo().setVisible(true);
    			}
		else if(arg0.getSource() == view.getBoutonTheo() && (indicet % 2) != 0)
			{	
				indicet++;
				view.getTextTheo().setVisible(false);
			}
		else if(arg0.getSource() == view.getBoutonMaxime()  && (indicem % 2) == 0)
    			{	
				indicem++;
    				view.getTextMaxime().setVisible(true);
    			}
		else if(arg0.getSource() == view.getBoutonMaxime() && (indicem % 2) != 0)
			{	
				indicem++;
				view.getTextMaxime().setVisible(false);
			}
		else if(arg0.getSource() == view.getBoutonYanis()  && (indicey % 2) == 0)
    			{	
				indicey++;
    				view.getTextYanis().setVisible(true);
    			}
		else if(arg0.getSource() == view.getBoutonYanis() && (indicey % 2) != 0)
			{	
				indicey++;
				view.getTextYanis().setVisible(false);
			}
		else if(arg0.getSource() == view.getBoutonRetour())
			{
				fenetre.changerVue(new AccueilView(fenetre , modele));
			}			
    
	}  
}

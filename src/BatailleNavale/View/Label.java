
package BatailleNavale.View;

import java.awt.Font;
import javax.swing.JLabel;

public class Label extends JLabel{

    public Label (String nom){
        super(nom);
        setFont(new Font("Impact",Font.ITALIC,12));
    }
    
    public Label (String nom, int taille_police){
        super(nom);
        setFont(new Font("Impact",0,taille_police));
    }

            


}

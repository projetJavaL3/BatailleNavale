package BatailleNavale.View;

import java.awt.Font;
import javax.swing.JLabel;

/** 
 * Classe <code> Label </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Label extends JLabel
{
    /**
     *  Construit une <code>Label</code> a partir d'un String
     *  @param nom texte du label
     */
    public Label (String nom)
    {
        super(nom);
        setFont(new Font("Impact",Font.ITALIC,12));
    }
    
    /**
     *  Construit une <code>Label</code> a partir d'un String et d'un int
     *  @param nom texte du label
     *  @param taille_police taille de l'ecriture du label
     */
    public Label (String nom, int taille_police)
    {
        super(nom);
        setFont(new Font("Impact", 0, taille_police));
    }
}

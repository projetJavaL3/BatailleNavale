package BatailleNavale.View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.BorderLayout;

/** 
 * Classe <code> Panneau </code> 
 * @author Maxime Kermarquer - Brady Abderemane - Theo Chelim - Yanis Boukari
 */
public class Panneau extends JPanel
{
    /**
     *  Construit une <code>Panneau</code> 
     */
	public Panneau()
	{
		super();
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(200,200,200));
		this.setForeground(Color.black);
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	}
}
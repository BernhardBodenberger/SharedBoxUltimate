import java.awt.Color;

import javax.swing.*;
public class HierKoenteIhreKlasseStehen extends JFrame{
	
	
	public HierKoenteIhreKlasseStehen(String s) {
		super (s);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white);
		this.getContentPane().add(new JLabel("Hier Könnte Ihre Klasse Stehen!"));
		this.setVisible(true);
	}
	
}

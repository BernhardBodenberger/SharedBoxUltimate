
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainGUI extends JFrame implements ActionListener {
	
	// Creates a new File instance by converting the given pathname string
    // into an abstract pathname
	File Currend = new File("D:\\Program Files");
	JFrame frame = null;
	
	public void PopuoMenu(File file) {
		final JPopupMenu menu = new JPopupMenu("Menu");
		//set menu Items
		JMenuItem name = new JMenuItem(file.toString());
		JMenuItem cut = new JMenuItem("Cut");
		JMenuItem copy = new JMenuItem("Copy");
		JMenuItem props = new JMenuItem("Schow Properties");
		//add Items to the Menu
		menu.add(name);
		menu.add(cut);
		menu.add(copy);
		menu.add(props);
	}
	public void listFiles() {
		//create new frame
		frame = new JFrame("Auflistung von Datein");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLocation(80,80);
		frame.getContentPane().setBackground(Color.white); 
		frame.setLayout(new FlowLayout());
		JButton b1 = new JButton("test"); 
		b1.addActionListener(this);
		frame.getContentPane().add(b1);
		
		
		String[] pathnames;


        // Populates the array with names of files and directories
        pathnames = Currend.list();

        //** go through the array
        for (int i = 0; i < pathnames.length; ++i) {
            //create buttons for each element in pathnames
            JButton btn = new JButton(pathnames[i]);
            btn.addActionListener(this);
            frame.getContentPane().add(btn);
           
        }
        frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 mainGUI gui = new mainGUI();
		 gui.listFiles();
		 
	}
	public void actionPerformed(ActionEvent ev) {
		
		JButton test = new JButton();
		test = (JButton) ev.getSource();
		frame.getContentPane().add(new JLabel(Currend.getAbsolutePath() + "\\"+ test.getText() ));
		//File Mover = new File(Currend.getAbsolutePath() + "\\"+ test.getText() );
		//Currend = Mover;
		
		frame.validate();
		
		
		
		
	}

}

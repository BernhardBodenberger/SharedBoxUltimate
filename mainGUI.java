
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainGUI extends JFrame implements ActionListener {
	
	// Creates a new File instance by converting the given pathname string
    // into an abstract pathname
	//File Currend = new File("D:\\Program Files");
	File CurrendWindow;
	File AblageGUI;
	
	public mainGUI(String s, File Currend, File Ablage) {
		super(s);
		CurrendWindow = Currend;
		AblageGUI = Ablage;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLocation(80,80);
		this.getContentPane().setBackground(Color.white); 
		this.setLayout(new FlowLayout());
		JButton b1 = new JButton("test"); 
		b1.addActionListener(this);
		this.getContentPane().add(b1);
	}
	
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
		
		
		
		
		String[] pathnames;


        // Populates the array with names of files and directories
        pathnames = CurrendWindow.list();

        //** go through the array
        for (int i = 0; i < pathnames.length; ++i) {
            //create buttons for each element in pathnames
            JButton btn = new JButton(pathnames[i]);
            btn.addActionListener(this);
            this.getContentPane().add(btn);
           
        }
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mainGUI frame = new mainGUI("Auflistung von Datein", new File("D:\\Program Files"), null); 
		
		frame.listFiles();
		frame.setVisible(true);
		 
	}
	public void actionPerformed(ActionEvent ev) {
		
		JButton test = new JButton();
		test = (JButton) ev.getSource();
		this.getContentPane().add(new JLabel(CurrendWindow.getAbsolutePath() + "\\"+ test.getText() ));
		//File Mover = new File(Currend.getAbsolutePath() + "\\"+ test.getText() );
		
		File Mover = new File(CurrendWindow.getAbsolutePath() + "\\"+ test.getText());
		if(Mover.isDirectory()) {
			CurrendWindow = Mover;
			mainGUI neu = new mainGUI("test", CurrendWindow, AblageGUI);
			neu.listFiles();
			neu.setVisible(true);
			this.dispose();
			this.validate();
		}
		
		
		
		
	}

}

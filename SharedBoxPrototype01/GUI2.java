

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI2 extends JFrame implements ActionListener {
	
	// Creates a new File instance by converting the given pathname string
    // into an abstract pathname
	//File Currend = new File("D:\\Program Files");
	
	File CurrendWindow;
	File AblageGUI;
	File Mover;
	JPanel panel = new JPanel();
	JScrollPane scroller = new JScrollPane(panel);
	JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	JButton back = new JButton("back");
	
	JButton editUser;
	JButton editAbteilung;
	JButton logout;
	
	//needed Popup variables 
	final JPopupMenu popupmenu;
	JButton fileButton;
	JMenuItem cut;
	JMenuItem copy;
	JMenuItem paste;
	JMenuItem rename;
	JMenuItem move;
	JMenuItem delete;
	JMenuItem replace;
	JMenuItem showProperties;
	JMenuItem upload;
	JMenuItem download;
	JMenuItem open;
	JMenuItem invite;
	static FileDirectory file;
	
	public GUI2(String s, File Currend, File Ablage) {
		super(s);
		CurrendWindow = Currend;
		AblageGUI = Ablage;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.white); 
		
		JPanel UserInterface = new JPanel();
		
		UserInterface.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		c.weighty = 1.0;
		
		
		UserInterface.add(new JLabel(" beispieluser@test.com "), c);
		
		editUser = new JButton("edit User");
		editUser.addActionListener(this);
		
		
		editAbteilung = new JButton("edit Abteilung");
		editAbteilung.addActionListener(this);
		c.gridx = 1;
		c.gridy = 1;
		UserInterface.add(editUser, c);
		c.gridx = 1;
		c.gridy = 2;
		UserInterface.add(editAbteilung, c);
		logout = new JButton("Logout");
		logout.addActionListener(this);
		c.gridy = 3;
		UserInterface.add(new JLabel("  "), c);
		c.gridy = 4;
		UserInterface.add(new JLabel("  "), c);
		c.gridy = 5;
		UserInterface.add(new JLabel("  "), c);
		c.gridy = 6;
		UserInterface.add(new JLabel("  "), c);
		c.gridy = 7;
		UserInterface.add(new JLabel("  "), c);
		c.gridy = 8;
		UserInterface.add(new JLabel("  "), c);
		c.gridy = 9;
		UserInterface.add(new JLabel("  "), c);
		c.gridy = 10;
		UserInterface.add(new JLabel("  "), c);
		c.gridy = 11;
		c.anchor = GridBagConstraints.SOUTH;
		UserInterface.add(logout, c);
		
		split.setLeftComponent(UserInterface);
		this.getContentPane().add(split);
		
		back.addActionListener(this);
		
		//Popup Constructor
		popupmenu = new JPopupMenu("Edit");
		
		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		rename = new JMenuItem("Rename");
		move = new JMenuItem("Move");
		delete = new JMenuItem("Delete");
		replace = new JMenuItem("Replace");
		showProperties = new JMenuItem("Show Properties");
		upload = new JMenuItem("Upload");
		download = new JMenuItem("Download");
		open = new JMenuItem("Open");
		invite = new JMenuItem("Invite");

		popupmenu.add(open);
		popupmenu.add(cut);
		popupmenu.add(copy);
		popupmenu.add(paste);
		popupmenu.add(rename);
		popupmenu.add(move);
		popupmenu.add(delete);
		popupmenu.add(replace);
		popupmenu.add(showProperties);
		popupmenu.add(upload);
		popupmenu.add(download);
		popupmenu.add(invite);
		
		
		//Popup action listeners
		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);
		rename.addActionListener(this);
		move.addActionListener(this);
		delete.addActionListener(this);
		replace.addActionListener(this);
		showProperties.addActionListener(this);
		upload.addActionListener(this);
		download.addActionListener(this);
		invite.addActionListener(this);
		open.addActionListener(this);
		
	}
	
	
	
	public void refreshScroller() {
		panel.remove(back);
		scroller.remove(panel);
		split.remove(scroller);
		this.validate();
		panel = new JPanel();
		scroller = new JScrollPane(panel);
		this.listFiles();
		this.setTitle(CurrendWindow.toString());
		this.validate();
	}
	
	public void listFiles() {
		//create new frame
		
		
		
		
		String[] pathnames;
		
		panel.setLayout(new GridLayout(0,1));
		
		split.setRightComponent(scroller);

        // Populates the array with names of files and directories
        pathnames = CurrendWindow.list();

        //** go through the array
        
        for (int i = 0; i < pathnames.length; ++i) {
            //create buttons for each element in pathnames
            JButton btn = new JButton(pathnames[i]);
            btn.addActionListener(this);
            btn.setBounds(300, 30, 80, 40);
            panel.add(btn);
             
        }
       
       
 	   panel.add(back);
 	   //if (CurrendWindow.toString() != "C:\\Users\\justu\\eclipse-workspace\\SE1 Projekt\\SharedBoxTestOrdner"  ) {
    	   
    	   
    	   
       //}
       
        
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI2 frame = new GUI2("Auflistung von Datein", new File("Server"), null); 
		
		frame.listFiles();
		frame.setVisible(true);
		 
	}
	public void actionPerformed(ActionEvent ev) {
		
		if (ev.getSource() == editUser) {
			HierKoenteIhreKlasseStehen edit = new HierKoenteIhreKlasseStehen("edit User");
		}
		if (ev.getSource() == editAbteilung) {
			HierKoenteIhreKlasseStehen edit = new HierKoenteIhreKlasseStehen("edit Abteilung");
		}
		if (ev.getSource() == logout) {
			HierKoenteIhreKlasseStehen edit = new HierKoenteIhreKlasseStehen("Logout");
		}
		
		if (ev.getSource() == open) {
			
			if(Mover.isDirectory()) {
				
				
				CurrendWindow = Mover;
				this.refreshScroller();
			}
			if(Mover.isFile()) {
				try {
					Desktop.getDesktop().open(Mover);
				}catch (Exception e) {}
			}
		}
		
		if (ev.getSource() == delete) {
			System.out.println("file deleted!");
			file.deleteDirectory();
			this.refreshScroller();
		}
		// DONE
		if (ev.getSource() == cut) {
			System.out.println("file was cut!");
			FileDirectory copy = file.cutOut();
			this.refreshScroller();
		}
		// DONE
		if (ev.getSource() == copy) {
			FileDirectory copy = file.copy();
			System.out.println(copy.speicherplatz);
		}
		// TODO
		if (ev.getSource() == paste) {
			file.paste(file, "I was pasted here");
			this.refreshScroller();
		}
		// DONE
		if (ev.getSource() == rename) {
			new OpenWindow(true, false, false, false, false);
			this.refreshScroller();

		}
		// DONE
		if (ev.getSource() == replace) {
			new OpenWindow(false, false, true, false, false);
			this.refreshScroller();
		}
		// DONE
		if (ev.getSource() == showProperties) {
			String s = file.showProperties();
			new ShowProperties(s);

			
		}
		// DONE
		if (ev.getSource() == upload) {
			new OpenWindow(false, false, false, true, false);
		}
		// DONE
		if (ev.getSource() == download) {
			new OpenWindow(false, false, false, false, true);
		}
		// TODO
		if (ev.getSource() == invite) {
			System.out.println("file deleted!");

		}
		// DONE
		if (ev.getSource() == move) {
			new OpenWindow(false, true, false, false, false);
		}
		
		if (ev.getSource() == back) {
			Mover = new File(CurrendWindow.getParent());
			CurrendWindow = Mover;
			System.out.println(CurrendWindow.getParent());
			
			this.refreshScroller();
		}
		if (ev.getSource().getClass() == JButton.class && ev.getSource() != back && ev.getSource() != editUser && ev.getSource() != editAbteilung && ev.getSource() != logout ) {
			JButton test = new JButton();
			test = (JButton) ev.getSource();
			Mover = new File(CurrendWindow.getAbsolutePath() + "\\"+ test.getText());
			file = new FileDirectory(CurrendWindow.getAbsolutePath() + "\\"+ test.getText());
			popupmenu.show(this, test.getX()+ 100, test.getY());
		}
		
		
		
		
		
	}

}


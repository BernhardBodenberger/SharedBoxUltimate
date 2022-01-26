

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Diese Klasse beinhaltet das Haupt-Interface für das Projekt SharedBox Ulitimate.
 * Mit diesem Interface kann sich der User in der Verzeichnisstruktur bewegen und
 * mit Hilfe eines Popupmenus die verschiedenen Operationene für Verzeichnisse oder Dateien ausführen.
 * Außerdem kann mit dem Interface die Bearbeitung der User-Informationen aufgerufen werden,
 * um die Informationen des eingelogten Users zu bearbeiten. 
 * Eine Option damit der User sich wieder auslogen kann ist auch integriert.  
 * 
 * 
 * @author SE1 Projektgruppe 7
 * @version 2.1
 *
 */

public class GUI2 extends JFrame implements ActionListener {
	
	/*Zuerst werden einige Variablen festgelgt, welche für die Funktion des
	 * Interfaces essenziell sind
	 */
	
	//Diese Objekte der Klasse FileDirectory werden gebraucht um die Verzeichnissstruktur zu navigieren
	FileDirectory CurrendWindow;
	FileDirectory Mover;
	static FileDirectory file;
	
	//Dieses Objekt dient als Ablage für die Operationen 'copy', 'cut' und 'paste'
	FileDirectory AblageGUI;
	
	//Der String 'User' dient um den eingelogten User zu identifizierne
	String User;
	
	//Container zur darstellung der Verzeichnissstruktur
	JPanel panel = new JPanel();
	JScrollPane scroller = new JScrollPane(panel);
	JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	//Diese Knöpfe werde hinzugefügt um alles Funktionen des Interfaces abzudecken
	JButton back = new JButton("back");
	JButton editUser;
	JButton createDirectory;
	JButton refresh;
	JButton logout;
	
	//hier werden die Benötigten Menü-Objekte erzeugt 
	final JPopupMenu popupmenu;
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
	
	/**
	 * 
	 * @param s
	 * @param Currend
	 * @param a
	 */
	public GUI2(String s, FileDirectory Currend, String a) {
		super(s);
		CurrendWindow = Currend;
		User = a;
		
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
		
		
		UserInterface.add(new JLabel(" "+User+" "), c);
		
		editUser = new JButton("edit User");
		editUser.addActionListener(this);
		editUser.setForeground(Color.WHITE);
		editUser.setBackground(Color.GRAY);
		
		refresh = new JButton("refresh");
		refresh.addActionListener(this);
		refresh.setForeground(Color.WHITE);
		refresh.setBackground(Color.GRAY);
		
		c.gridx = 1;
		c.gridy = 1;
		UserInterface.add(editUser, c);
		
		createDirectory = new JButton("create Directory");
		createDirectory.addActionListener(this);
		createDirectory.setForeground(Color.WHITE);
		createDirectory.setBackground(Color.GRAY);
		c.gridy = 2;
		UserInterface.add(createDirectory, c);
		
		c.gridx = 1;
		c.gridy = 3;
		UserInterface.add(refresh, c);
		logout = new JButton("Logout");
		logout.addActionListener(this);
		logout.setForeground(Color.WHITE);
		logout.setBackground(Color.GRAY);
		
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
		
		
		this.setVisible(true);
		
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
            btn.setBackground(Color.WHITE);
            panel.add(btn);
             
        }
       
       
 	   
 	   if (CurrendWindow.toString() != new File("SharedBoxTestOrdner").toString()  ) {
 		  back.setBackground(Color.WHITE); 
 		  panel.add(back);
 		  System.out.println( new File("SharedBoxTestOrdner").getAbsolutePath().toString());
    	   
       }
       
        
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI2 frame = new GUI2("Auflistung von Datein", new FileDirectory("SharedBoxTestOrdner"), "serge@naver.com"); 
		frame.listFiles();
		
		
		 
	}
	public void actionPerformed(ActionEvent ev) {
		
		if (ev.getSource() == editUser) {
			readFile gui = new readFile();
	    	try {
	    		gui.edit("user.txt", User);
	    		} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    		}
		}
		
		if (ev.getSource() == createDirectory) {
			new File(CurrendWindow.toString() + "/Neues Verzeichnis").mkdirs();
			this.refreshScroller();
		}
		
		if (ev.getSource() == refresh) {
			this.refreshScroller();
		}
		if (ev.getSource() == logout) {
			UserLogin login = new UserLogin();
			login.los();
			this.dispose();
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
			AblageGUI = new FileDirectory(copy.absolutePath);
			this.refreshScroller();
		}
		// DONE
		if (ev.getSource() == copy) {
			FileDirectory copy = file.copy();
			AblageGUI = new FileDirectory(copy.absolutePath);
			System.out.println(AblageGUI.toString());
		}
		// TODO
		if (ev.getSource() == paste) {
			file.paste(AblageGUI, file.toString());
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
			try {
	    		file.upload(file.toString());
	    		} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    		}
			//new OpenWindow(false, false, false, true, false);
		}
		// DONE
		if (ev.getSource() == download) {
			try {
	    		file.download(file.toString());
	    		} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    		}
			//new OpenWindow(false, false, false, false, true);
		}
		// TODO
		if (ev.getSource() == invite) {
			System.out.println("User invited");

		}
		// DONE
		if (ev.getSource() == move) {
			System.out.println(file.toString());
			new OpenWindow(false, true, false, false, false);
		}
		
		if (ev.getSource() == back) {
			Mover = new FileDirectory(CurrendWindow.getParent());
			CurrendWindow = Mover;
			System.out.println(CurrendWindow);
			
			this.refreshScroller();
		}
		if (ev.getSource().getClass() == JButton.class && ev.getSource() != back && ev.getSource() != editUser && ev.getSource() != refresh && ev.getSource() != logout && ev.getSource() != createDirectory ) {
			JButton test = new JButton();
			test = (JButton) ev.getSource();
			Mover = new FileDirectory(CurrendWindow.toString() + "\\"+ test.getText());
			file = new FileDirectory(CurrendWindow.getAbsolutePath() + "\\"+ test.getText());
			popupmenu.show(this, test.getX()+ 100, test.getY());
		}
		
		
		
		
		
		
	}

}


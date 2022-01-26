import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class PopupGUI extends JFrame implements ActionListener {
	// File CurrendWindow;
	final JFrame f;
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

	PopupGUI() {
		// CurrendWindow = Currend;
		f = new JFrame("PopupMenu Example");
		fileButton = new JButton("I am a file");
		fileButton.setBounds(50, 100, 150, 50);
		fileButton.addActionListener(this);
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
		open = new JMenuItem("Open Directory");
		invite = new JMenuItem("Invite");

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
		f.add(popupmenu);
		f.add(fileButton);
		// f.addMouseListener(this);
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);
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
	}

	public static void main(String args[]) {
		new PopupGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fileButton) {
			file = new FileDirectory("C:/Users/Dell/Desktop/test/test.pdf");
			popupmenu.show(f, fileButton.getX(), fileButton.getY());
		}
		// DONE
		if (e.getSource() == delete) {
			System.out.println("file deleted!");
			file.deleteDirectory();
		}
		// DONE
		if (e.getSource() == cut) {
			System.out.println("file was cut!");
			FileDirectory copy = file.cutOut();
		}
		// DONE
		if (e.getSource() == copy) {
			FileDirectory copy = file.copy();
			System.out.println(copy.speicherplatz);
		}
		// TODO
		if (e.getSource() == paste) {
			file.paste(file, "I was pasted here");
		}
		// DONE
		if (e.getSource() == rename) {
			new OpenWindow(true, false, false, false, false);

		}
		// DONE
		if (e.getSource() == replace) {
			new OpenWindow(false, false, true, false, false);
		}
		// DONE
		if (e.getSource() == showProperties) {
			String s = file.showProperties();
			new ShowProperties(s);

			System.out.println("file deleted!");
		}
		// DONE
		if (e.getSource() == upload) {
			new OpenWindow(false, false, false, true, false);
		}
		// DONE
		if (e.getSource() == download) {
			new OpenWindow(false, false, false, false, true);
		}
		// TODO
		if (e.getSource() == invite) {
			System.out.println("file deleted!");

		}
		// DONE
		if (e.getSource() == move) {
			new OpenWindow(false, true, false, false, false);
		}
	}
}

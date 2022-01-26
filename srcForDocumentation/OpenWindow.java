import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Klasse, welche je nachdem welche Datei-Operation ausgewählt wurde, ein Fenster zum eingeben von Dateipfaden 
 * oder Dateinamen öffnet
 * @author SE1 Projektgruppe 7
 */
public class OpenWindow extends JFrame implements ActionListener {
	//Deklaration der Klassenvariablen
	boolean rename;
	boolean move;
	boolean replace;
	boolean upload;
	boolean download;
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();

	static JButton pathButton = new JButton("Submit");
	static JTextField textField = new JTextField();
	static String path;
	
	/**
	 * Konstruktor mit boolean Werten für ausgewähle Datei-Operationen
	 * @param rename: falls umbenennen ausgewählt wird, rename=true
	 * @param move: falls verschieben ausgewählt wird, move=true
	 * @param replace: falls ersetzen ausgewählt wird, replace=true
	 * @param upload: falls upload ausgewählt wird, upload=true
	 * @param download: falls download ausgewählt wird, download=true
	 */
	OpenWindow(boolean rename, boolean move, boolean replace, boolean upload, boolean download) {
		this.rename = rename;
		this.move = move;
		this.replace = replace;
		this.upload = upload;
		this.download = download;
		if (rename) {
			label.setText("Enter a new filename!");
		}
		if (move) {
			label.setText("Enter a path to move the file to!");
		}
		if (replace) {
			label.setText("Enter a path to the file that should replace this file!");
		}
		if (upload) {
			label.setText("Enter the path to the file you want to upload");
		}
		if (download) {
			label.setText("Enter the path to where you want to download the file");
		}
		
		// Layout und hinzufügen der Komponenten zum Frame
		textField.setPreferredSize(new Dimension(350, 40));
		pathButton.addActionListener(this);
		label.setHorizontalAlignment(JLabel.LEFT);
		label.setVerticalAlignment(JLabel.BOTTOM);
		frame.add(textField);
		frame.add(pathButton);
		frame.add(label);
		frame.setLayout(new FlowLayout());
		frame.setSize(350, 350);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();

	}
	/**
	 * Methode, welche das Actionevent e auswertet
	 */
	@Override
	public void actionPerformed(ActionEvent e) {	
		if (e.getSource() == pathButton && move == true) { //Falls pathButton gedrückt wurde und move ausgewählt wurde
			path = textField.getText() + "/" + GUI2.file.name; //Speichert den Pfad der ausgewählten Datei in path
			GUI2.file.move(path); // Führt die move Methode auf file mit dem Parameter path aus
			frame.dispose(); //Schließt das Fenster zum eingeben des Pfades
		}
		if (e.getSource() == pathButton && rename == true) { //Falls pathButton gedrückt wurde und rename ausgewählt wurde
			path = textField.getText(); //Speichert den Pfad der ausgewählten Datei in path
			GUI2.file.rename(path); // Führt die rename Methode auf file mit dem Parameter path aus
			frame.dispose(); //Schließt das Fenster zum eingeben des Pfades
		}
		if (e.getSource() == pathButton && replace == true) { //Falls pathButton gedrückt wurde und replace ausgewählt wurde
			path = textField.getText(); //Speichert den Pfad der ausgewählten Datei in path
			GUI2.file.replace(path); // Führt die replace Methode auf file mit dem Parameter path aus
			frame.dispose(); //Schließt das Fenster zum eingeben des Pfades
		}
		/*if (e.getSource() == pathButton && upload == true) {
			path = textField.getText();
			GUI2.file.upload(path);
		}
		if (e.getSource() == pathButton && download == true) {
			path = textField.getText();
			GUI2.file.download(path);
		}*/
	}

}

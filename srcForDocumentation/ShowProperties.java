import javax.swing.JFrame;
import javax.swing.JTextArea;
/**
 * Kleine Klasse zur Erstellung eines JFrames, welche die Eigenschaften einer Datei bzw. eines Verzeichnisses
 * anzeigt
 * @author SE1 Projektgruppe 7
 */
public class ShowProperties extends JFrame {
	//Deklaration von Klassenvariablen
	String properties;
	/**
	 * Konstruktor der ShowProperties Klasse
	 * @param properties: String, welcher die Eigenschaften einer Datei bzw. eines Verzeichnisses speichert.
	 */
	ShowProperties(String properties) {
		this.properties = properties;
		JFrame frame = new JFrame("Properties of the file");
		JTextArea pane = new JTextArea();
		frame.setSize(600, 150);
		pane.setText(properties);
		frame.add(pane);
		frame.setVisible(true);
	}
}

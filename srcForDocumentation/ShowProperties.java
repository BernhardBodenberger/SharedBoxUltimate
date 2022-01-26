import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ShowProperties extends JFrame {
	String properties;

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

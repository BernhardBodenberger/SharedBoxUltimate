import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class OpenWindow extends JFrame implements ActionListener {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == pathButton && move == true) {
			path = textField.getText() + "/" + GUI2.file.name;
			GUI2.file.move(path);
			frame.dispose();
		}
		if (e.getSource() == pathButton && rename == true) {
			path = textField.getText();
			GUI2.file.rename(path);
			frame.dispose();
		}
		if (e.getSource() == pathButton && replace == true) {
			path = textField.getText();
			GUI2.file.replace(path);
			frame.dispose();
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

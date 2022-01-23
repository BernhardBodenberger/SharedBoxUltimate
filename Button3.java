import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.util.Scanner;

public class Button3 extends JFrame {
   public static void main(String[] args) {
      Button3 gui = new Button3();
      gui.los();
   }
   public void los() {
	   JPanel p = new JPanel();
       p.setLayout(null);
       JLabel label = new JLabel(new ImageIcon("C:\\123.JPG"));
		add(label);
		Label t1= new Label("HI.");
		add(t1);
		TextField b4 = new TextField();
		add(b4);
		TextField b5 = new TextField();
		add(b5);
		b5.setEchoChar('*');
		JButton b6 = new JButton("login");
		add(b6);
		JButton b7 = new JButton("register");
		add(b7);
		label.setBounds(0, 5, 350, 255);
		t1.setBounds(350, 5, 70, 40);
		b4.setBounds(150, 265, 200, 30);
		b5.setBounds(150, 305, 200, 30);
		b6.setBounds(380, 265, 80, 30);
		b7.setBounds(380, 305, 90, 30);
		add(p);
		setSize(700, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("login");
		setVisible(true);
		b7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyFrame f2= new MyFrame();
			}
		});;
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2) {
				try{
					String s;
					String[] array;
					BufferedReader bos = new BufferedReader(new FileReader("C:\\FMP\\user.txt"));
					while((s=bos.readLine())!=null){
						array=s.split("/");
						Scanner scan = new Scanner(s);
			            String line = scan.nextLine();
			            if(line.contains(b4.getText()))
						{
			            	if(line.contains(b5.getText())) 
			            	{
			            		if(b4.getText().equals(array[1])&&b5.getText().equals(array[2])) 
			            		{
			            			JOptionPane.showMessageDialog(null, "loged in successfully!!");
			            		}
			            		else 
								{
									JOptionPane.showMessageDialog(null, "failed to login.");
								}
			            	}
						}

					}
					bos.close();
					dispose();
				}catch (IOException E10){
					E10.printStackTrace();
				}
			}
		});
	}
}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.util.Scanner;
import java.nio.file.Files;

public class Button3 extends JFrame {
   public static void main(String[] args) {
      Button3 gui = new Button3();
      gui.los();
   }
   public void los() {
	   JPanel p = new JPanel();
       p.setLayout(null);
       
        Label lable_1= new Label("Username:");	
        Label lable_2 = new Label("Password: ");
        add(lable_1);
        add(lable_2);
		TextField text_user = new TextField();
		TextField text_pass = new TextField();
		add(text_user);
		add(text_pass);
		text_pass.setEchoChar('*');
		JButton b6 = new JButton("Login");
		JButton b7 = new JButton("Register");
		
		b6.setForeground(Color.WHITE);
		b6.setBackground(Color.GRAY);
		b7.setForeground(Color.WHITE);
		b7.setBackground(Color.GRAY);
		
		add(b6);
		add(b7);
		lable_1.setBounds(100,100,70,30);
		text_user.setBounds(220, 100, 250, 25);
		lable_2.setBounds(100,150,70,30);
		text_pass.setBounds(220, 150, 250,25);
		b6.setBounds(220, 215, 115, 25);
		b7.setBounds(355, 215, 115, 25);
		add(p);
		setSize(700, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SharedBox Ultimate LOGIN");
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

					if(text_user.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Enter your ID.");
					}
					if(!text_user.getText().isEmpty()){
			            int a =0;
						while((s=bos.readLine())!=null){
						array=s.split("/");
						Scanner scan = new Scanner(s);
			            String line = scan.nextLine();

				            if(line.contains(text_user.getText()))
							{
				            	a=a+1;
				            	if(text_user.getText().equals(array[2]) && text_pass.getText().equals(array[3])) 
				            		{
				            			JOptionPane.showMessageDialog(null, "logged in successfully!!");
				    					dispose();
				    						// TODO Auto-generated method stub
				    					String bc="C:\\"+text_user.getText()+"\\";
				    					File d = new File("C:\\"+text_user.getText()+"\\");
				    					if(d.exists()) {
				    						GUI2 frame = new GUI2("Auflistung von Datein", new File(bc), null, text_user.getText());
				    						frame.listFiles();
				    						frame.setVisible(true);
				    					}
				    					else {
				    						d.mkdir();
				    						GUI2 frame = new GUI2("Auflistung von Datein", new File(bc), null, text_user.getText());
				    						frame.listFiles();
				    						frame.setVisible(true);
				    					}
				            		}
				            	else 
								{
									JOptionPane.showMessageDialog(null, "failed to login.");

								}
							}

						}
						if(a!=1) {
							JOptionPane.showMessageDialog(null, "Email doesn't exist.");
						}
					}
					bos.close();
				}catch (IOException E10){
					E10.printStackTrace();
				}
			}
		});
	}
}

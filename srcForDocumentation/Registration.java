
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;

public class Registration extends JFrame {
	public Registration(){
		  	JPanel p = new JPanel();
		  	Label l1= new Label("vor name");	
	        Label l2 = new Label("nach name");
	        Label l3= new Label("e-mail");
	        Label l4 = new Label("password");
	        Label l5 = new Label("address");
	        Label l6 = new Label("abteilung");
	        add(l1);
	        add(l2);
	        add(l3);
	        add(l4);
	        add(l5);
	        add(l6);
	        TextField t1 = new TextField();
	        TextField t2 = new TextField();
	        TextField t3 = new TextField();
	        TextField t4 = new TextField();
	        TextField t5 = new TextField();
	        TextField t6 = new TextField();
	        add(t1);
	        add(t2);
	        add(t3);
	        add(t4);
	        add(t5);
	        add(t6);
	        t4.setEchoChar('*');
	        JButton j1 = new JButton("save");
	        j1.setForeground(Color.WHITE);
	        j1.setBackground(Color.GRAY);
	        JButton j2 = new JButton("cancel");
	        j2.setForeground(Color.WHITE);
	        j2.setBackground(Color.GRAY);
	        add(j1);
	        add(j2);
	        l1.setBounds(40, 13, 70, 40);
	        l2.setBounds(40, 55, 70, 40);
	        l3.setBounds(40, 95,70,40);
	        l4.setBounds(40, 135, 70, 40);
	        l5.setBounds(40, 175, 70, 40);
	        l6.setBounds(40, 215, 70, 40);
	        t1.setBounds(120, 20, 200, 30);
	        t2.setBounds(120, 60, 200, 30);
	        t3.setBounds(120, 100, 200, 30);
	        t4.setBounds(120, 140, 200, 30);
	        t5.setBounds(120, 180, 200, 30);
	        t6.setBounds(120, 220, 200, 30);
	        j1.setBounds(125, 330, 80, 30);
	        j2.setBounds(240, 330, 80, 30); 
	    add(p);
		setSize(550,550);
		setLocationRelativeTo(null);
		setTitle("registration");
		//by clicking x on frame, it closes only current frame.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setVisible(true);
       j1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent T) {
			try{
				String txt_path = "user.txt";
				BufferedReader s = new BufferedReader(new FileReader("user.txt"));
				BufferedWriter bos = new BufferedWriter(new FileWriter(txt_path,true));
				Scanner scan = new Scanner(s);
	            String line = scan.nextLine();
	            //email should be unique. so it checks whether same email exists or not. (check duplicates)
				if(line.contains(t3.getText())) {
					JOptionPane.showMessageDialog(null, "The E-mail already exists!!");
				}
				else {
					bos.write(t1.getText()+"/");
					bos.write(t2.getText()+"/");
					bos.write(t3.getText()+"/");
					bos.write(t4.getText()+"/");
					bos.write(t5.getText()+"/");
					bos.write(t6.getText()+"\r\n");
					bos.close();
					JOptionPane.showMessageDialog(null, "congratulation!! register completed!!");
					dispose();
				}
			}catch (Exception ex){
				JOptionPane.showMessageDialog(null, "failed to register.");
			}
		}
	});
       
    // by clicking cancel, only current frame is closed.
    j2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent T) {	
    		dispose();
    	}
    });
	}
}

 

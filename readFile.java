import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class readFile extends JFrame
{
	public void read() throws IOException{
        BufferedReader obj = new BufferedReader(new FileReader("C:\\FMP\\user.txt"));
        String s;
        while ((s=obj.readLine())!=null) {
        	String[] array;
        	array = s.split("/");
        	String a = "fabi@naver.com";
			Scanner scan = new Scanner(s);
            String line = scan.nextLine();
        	if(a.equals(array[2])) {
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
    	        TextField t1 = new TextField(array[0]);
    	        TextField t2 = new TextField(array[1]);
    	        TextField t3 = new TextField(array[2]);
    	        TextField t4 = new TextField(array[3]);
    	        TextField t5 = new TextField(array[4]);
    	        TextField t6 = new TextField(array[5]);
    	        add(t1);
    	        add(t2);
    	        add(t3);
    	        add(t4);
    	        add(t5);
    	        add(t6);
    	        t1.setEnabled(false);
    	        t2.setEnabled(false);
    	        t3.setEnabled(false);
    	        t4.setEchoChar('*');
    	        JButton j1 = new JButton("save");
    	        JButton j2 = new JButton("cancel");
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
    		setTitle("membership information");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);

           j1.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent T) {
       			try{	
       				   String dummy = "";
       				   try {
       				   	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\FMP\\user.txt")));
       				   	String[] array;
       				   	String line;
       				   	while((line = br.readLine())!=null) {
       				   		if(line.contains(a)) {
       				   			continue;
       				   		}
       				   		else {
       			    	   		dummy += (line + "\r\n" ); 
       				   		}
       				   	}
       				   	FileWriter fw = new FileWriter("C:\\FMP\\user.txt");
       				   	fw.write(dummy);			
       				   	fw.close();
       				   	br.close();	   	
       				   	}catch (Exception e) {
       			        	   	e.printStackTrace();
       			         }
       				String txt_path = "C:\\FMP\\user.txt";
       				BufferedReader s = new BufferedReader(new FileReader("C:\\FMP\\user.txt"));
       				BufferedWriter bos = new BufferedWriter(new FileWriter(txt_path,true));
   					bos.write(t1.getText()+"/");
   					bos.write(t2.getText()+"/");
   					bos.write(t3.getText()+"/");
   					bos.write(t4.getText()+"/");
   					bos.write(t5.getText()+"/");
   					bos.write(t6.getText()+"\r\n");
   					bos.close();
   					JOptionPane.showMessageDialog(null, "user information has been changed!!");
   					dispose();
       			}catch (Exception ex){
       				JOptionPane.showMessageDialog(null, "failed to register.");
       			}
       		}
       		});
           j2.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent T) {	
           		dispose();
           	}
           });
			}
		}
    }
    public static void main(String[] args) throws Exception
    {
    	readFile gui = new readFile();
        gui.read();
    }
}

import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

import org.w3c.dom.css.RGBColor;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.lang.ProcessBuilder.Redirect;
import java.util.Date;
import java.awt.event.ActionEvent;



public class LoginGUI implements ActionListener{
	
	JFrame LoginFrame= null;
	JLabel benutzerlabel, passwordlabel;
	JButton registerButton, loginButton;
	JTextField benutzerField;
	JPasswordField passwordField;
	
	public static void main(String[] args) {
		LoginGUI login= new LoginGUI();
		login.start();
	}

	public void start() {
	//  Erstellung eines neuen JFrames	
		LoginFrame= new JFrame("Ultimate Shared Box");
		LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginFrame.setSize(1600,900);
		LoginFrame.setLayout(null);

	
	// Textlabel für das Benutzer-Email Feld	
		benutzerlabel= new JLabel("Email-Adresse");
		benutzerlabel.setBounds(550,300,100,25);
		
	// Das Textlabel für das Passwortfeld	
		passwordlabel= new JLabel("Passwort");
		passwordlabel.setBounds(550,325,100,25);
		
		
	// Feld zum Engeben der Benutzer-Email-Adresse	
		benutzerField= new JTextField();
		benutzerField.setBounds(700,300,100,25);
		
	// Feld zum Eingeben des Passworts
		passwordField= new JPasswordField();
		passwordField.setBounds(700,325,100,25);
		
	// Button zum Einloggen	
		loginButton= new JButton("Einloggen");
		loginButton.setBounds(625,360,150,25);
		loginButton.addActionListener(this);
	
	// Button zum Registrieren
		registerButton= new JButton("Registrieren");
		registerButton.setBounds(625,400,150,25);		
		registerButton.addActionListener(this);
		
	// Hier wird alles zum JFrame hinzugefügt	
		LoginFrame.add(registerButton);
		LoginFrame.add(loginButton);
		LoginFrame.add(passwordlabel);
		LoginFrame.add(passwordField);
		LoginFrame.add(benutzerField);
		LoginFrame.add(benutzerlabel);
		
		
		LoginFrame.setVisible(true);
	
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == registerButton) 
		{
			registerGUI reg = new registerGUI();
			reg.register();
			/*Wenn ich den registerButton betätige dann öffnet 
			 * sich ein neues Fenster mit dem Register Formular*/
		}
		if(e.getSource() == loginButton) 
		{	String username =benutzerField.getText(); 
		/*der Variable username wurde der Inhalt übergeben der beim betätigen des Buttons
		 im Textfeld enthalten war*/
		
			if( username == null)
			{
				
				passwordField.setBackground(null);
				/*Code für fehlende Engabe im Benutzer Textfelt*/
			}
		
			String password =passwordField.getText(); // Inhalt PAsswort Feld wurd an die String Variable password übergeben
			if(password== null)
			{
			/*Code für fehlende Password-Eingabe */	
			}
			
			
			
			System.out.println(username + password);
			// Passwort Feld darf nicht leer sein
			// Textfeld für den Benutzernamen darf nicht leer sein
			// muss min ein @ enthaltne damit es sich um eine Email handelt
			/* Klasse von Justus wird neu aufgerufen und ein neues Objekt erstellt
			 * Dabei muss noch überprüft werden ob der Nutzer überhaupt als Benutzer registriert ist
			 * Dann muss der Die BusinessEmail Adresse mit der "DAtenbank" verglichen werden genauso wie das Passwort.
			 * Wenn das alles passt muss der Nutzer zu seinr jeweiligen Ansicht geleitet werden mit allen Ordnern usw.
			 * auf die er Zugriff hat*/
		}
	}
	public class registerGUI implements ActionListener{
		JFrame registerFrame= null;
		JPanel panl;
		JButton interruptButton, continueButton;
		JTextField businessEmail, fullName, preName; 
		JLabel LabelbusinessEmail, LabelfullName, LabelpreName, lpassword;
		JPasswordField upassword;

		public void register() {
			registerFrame= new JFrame("Nutzerregistrierung");
			registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			registerFrame.setSize(1600,900);
			registerFrame.setVisible(true); 
			registerFrame.setLayout(null);
			
			interruptButton= new JButton("Abbrechen");
			interruptButton.setSize(100,25);
			interruptButton.setLocation(600,550);
			interruptButton.addActionListener(this);
			registerFrame.add(interruptButton);
			
			continueButton= new JButton("Registrieren");
			continueButton.setSize(100,25);
			continueButton.setLocation(700,550);
			continueButton.addActionListener(this);
			registerFrame.add(continueButton);
			
			// Textfeld Email
			businessEmail= new JTextField();
			businessEmail.setBounds(600,250,200,25);
			registerFrame.add(businessEmail);
			
			// Textfeld Vorname
			preName= new JTextField();
			preName.setBounds(600,275,200,25);
			registerFrame.add(preName);
			
			// Textfeld für den Nachnamen
			fullName= new JTextField();
			fullName.setBounds(600,300,200,25);
			registerFrame.add(fullName);
			
			upassword= new JPasswordField();
			upassword.setBounds(600,325,200,25);
			registerFrame.add(upassword);
			
			
			// Label Email
			LabelbusinessEmail= new JLabel("Business Email");
			LabelbusinessEmail.setBounds(450,250,100,25);
			registerFrame.add(LabelbusinessEmail);
			
			// Label für das Vorname Feld
			LabelpreName= new JLabel("Vorname");
			LabelpreName.setBounds(450,275,100,25);
			registerFrame.add(LabelpreName);
			
			// Label Nachname Feld
			LabelfullName= new JLabel("Nachname");
			LabelfullName.setBounds(450,300,100,25);
			registerFrame.add(LabelfullName);
			
			// Label Passwortfeld
			lpassword= new JLabel("Passwort");
			lpassword.setBounds(450,325,100,25);
			registerFrame.add(lpassword);
			
			
		
			
		}

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == continueButton) {
				String newPassword = upassword.getText();
				String newUser = businessEmail.getText();
				String newFullname = fullName.getText();
				String newPrename = preName.getText();
				Date regDate = new Date();
				System.out.println(newFullname+newPassword+newUser+newPrename+"####"+ regDate);
				
			}
			if(e.getSource() == interruptButton) {	
				System.exit(0);
			}

		}
	}

}

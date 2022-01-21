package UML;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;

public class UserClass_serge {

	public UserClass_serge() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		System.out.println("Vorname: ");
		Scanner v_name = new Scanner(System.in);
		v_name.next();
		
		System.out.println("Nachname: ");
		Scanner n_name = new Scanner(System.in);
		n_name.next();
		
		String full_name = n_name + " " + v_name;
		v_name.close();
		n_name.close();
		
		return full_name;
	}
	
	
	public String getEmail() {
		System.out.println("Email: ");
		Scanner e_mail = new Scanner(System.in);
		String new_e = e_mail.nextLine();
		e_mail.close();
		String regex = "^(.+)@(.+)";
		Pattern r = Pattern.compile(regex);
		Matcher m = r.matcher(new_e);
		if(m.find()) {
			return new_e;
		}else {
			System.out.println("wrong format!!!");
			return null;
		}
	}
	
	public String getPassword() throws IOException{
		System.out.println("Passwort: ");
		Scanner pass = new Scanner(System.in);
		String new_p = pass.nextLine();
		pass.close();
		String regex_pass = "^(?=.*[a-z])(?=.*[A-Z])(?=.[0-9])(?=.*[!@#&()-[{}]:;',?/*~$^+=<>]){8,20}$";
		Pattern pattern = Pattern.compile(regex_pass);
		Matcher matcher = pattern.matcher(new_p);
		boolean is_valid = matcher.matches();

		if(is_valid) {
			System.out.println("Valid");
			return new_p;
		}else {
			System.out.println("invalid");
			return null ;
		}

	}

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		String res = new UserClass_serge().getEmail();
		//System.out.println(res);
		//String res = new UserClass_serge().getPassword();
		System.out.println(res);
		String txt_path = "C:\\FMP\\Users.txt";
		File file = new File(txt_path);
		FileWriter filewriter = new FileWriter(file, true);
		filewriter.write(res+"\n");
		filewriter.flush();
		filewriter.close();
	}

}

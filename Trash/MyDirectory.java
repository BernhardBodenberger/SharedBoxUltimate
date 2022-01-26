import java.io.IOException;
import java.util.ArrayList;

public class MyDirectory extends FileDirectory {
	String owner;
	ArrayList<String> access;

	public MyDirectory(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	public static void VerzeichnisErstellen(String name) {
		try {
			String currentPath = new java.io.File(".").getCanonicalPath();
			MyDirectory directory = new MyDirectory(currentPath + "/" + name);
			if (!directory.exists()) {
				System.out.println("worked");
				directory.mkdirs();
			} else {
				System.out.println("didnt work");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void NutzerEntfernen(MyDirectory directory) {

	}

	public void NutzerEinladen(MyDirectory directory) {

	}

}

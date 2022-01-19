import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.*;

//Test
public class Replace extends File {
	String name;
	String absolutePath; 
	double speicherplatz;

	public Replace(String path) {
		super(path);
		this.name = this.getName();
		this.absolutePath = this.getAbsolutePath();
		this.speicherplatz = this.length();
	}

	public void moveFile(String fileDestination) {
		try {
			Files.move(this.toPath(), new Replace(fileDestination).toPath(),
					StandardCopyOption.REPLACE_EXISTING);
			System.out.println("File move successful");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Replace file1 = new Replace("C:\\MPC_WP.JPG"); 

		file1.moveFile("C:\\FMP\\" + file1.name);
		File file2 = new File("C:\\FMP\\12.txt");
		file2.delete();
	}

}
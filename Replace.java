import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.*;

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

	public Replace fileCopy() {
		Replace originalFile = this; //
		return (originalFile);
	}

	public void filePaste(String pathToCopy) {
		Replace newFile = new Replace(pathToCopy);
		try {
			Files.copy(this.toPath(), newFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Replace file1 = new Replace("C:\\MPC_WP.JPG"); 

		Replace copy = file1.fileCopy();
		copy.filePaste("C:\\FMP\\" + copy.name);
		File file2 = new File("C:\\FMP\\12.txt");
		file2.delete();
	}

}

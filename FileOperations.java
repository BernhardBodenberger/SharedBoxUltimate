import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileOperations extends File { // Klasse FileOperations erbt von File.
	// Klassenattribute die alle Objekte vom Typ FileOperations haben

	String name; // Speichert den Namen des Files
	// String type; // Speichert den Typ des Files.
	String absolutePath; // Speichert den Pfad des Files
	double speicherplatz; // Speichert die Größe des Files in KB

	public FileOperations(String path) { // Konstruktor für die Klase
		super(path); // This constructor creates a new File instance by converting the given pathname
						// string into an abstract pathname. // FileOperations
		this.name = this.getName();
		this.absolutePath = this.getAbsolutePath();
		// this.type = type; // toDo
		this.speicherplatz = this.length(); // toDo
	}

	// Method to move a file
	public void moveFile(String fileDestination) {
		try {
			Files.move(this.toPath(), new FileOperations(fileDestination).toPath(),
					StandardCopyOption.REPLACE_EXISTING);
			System.out.println("File move successful");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method to copy a file
	public FileOperations fileCopy() {
		FileOperations originalFile = this; //
		return (originalFile);
	}

	public void filePaste(String pathToCopy) {
		FileOperations newFile = new FileOperations(pathToCopy);
		try {
			Files.copy(this.toPath(), newFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// MAIN METHOD
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOperations file1 = new FileOperations(".\\src\\FileList.java"); // read File of type FileOperations
		FileOperations file2 = new FileOperations(".\\src\\HelloWorld.java"); // read File of type FileOperations
		// print out properties of original file
		// System.out.println(file1.name);
		System.out.println(file1.speicherplatz);
		// System.out.println(file1.absolutePath);

		// Copy a given File
		FileOperations copy = file1.fileCopy();
		// print out properties of copy
		// System.out.println(copy.name);
		// System.out.println(copy.absolutePath);
		// System.out.println(copy.speicherplatz);
		// paste the copy to test folder
		copy.filePaste(".\\src\\test\\" + copy.name);

		// Call the moveFile method
		file2.moveFile(".\\src\\test\\" + file2.name);

	}

}

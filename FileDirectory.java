import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;

public class FileDirectory extends File {
	String name; // Speichert den Namen des Files
	// String type; // Speichert den Typ des Files.
	String absolutePath; // Speichert den Pfad des Files
	double speicherplatz; // Speichert die Größe des Files in KB

	public FileDirectory(String path) {
		super(path);
		this.name = this.getName();
		this.absolutePath = this.getAbsolutePath();
		this.speicherplatz = this.length(); //
	}

	public void move(String fileDestination) {
		try {
			Files.move(this.toPath(), new FileDirectory(fileDestination).toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("File move successful");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FileDirectory copy() {
		FileDirectory originalFile = this; //
		return (originalFile);
	}

	public void paste(String pathToCopy) {
		FileDirectory newFile = new FileDirectory(pathToCopy);
		try {
			Files.copy(this.toPath(), newFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void rename(String newName) {
		try {
			Path source = Paths.get(this.absolutePath);
			// rename a file in the same directory
			Files.move(source, source.resolveSibling(newName));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FileDirectory fileCutOut() {
		FileDirectory copy = this;
		this.delete();
		return (copy);
	}

	public void showProperties() {
		try {
			String path = this.absolutePath;
			Path pathOfFile = Paths.get(path);
			BasicFileAttributes attr = Files.readAttributes(pathOfFile, BasicFileAttributes.class);
			System.out.println("filename         = " + this.name);
			System.out.println("creationTime     = " + attr.creationTime());
			System.out.println("isDirectory      = " + attr.isDirectory());
			System.out.println("isOther          = " + attr.isOther());
			System.out.println("isRegularFile    = " + attr.isRegularFile());
			System.out.println("size             = " + attr.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteDirectory() {
		try {
			Path path = Paths.get(this.absolutePath);
			Files.walk(path).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void replace(FileDirectory originalFile) { // takes the file we want to replace this file with
		String name = originalFile.getName();
		String directory = this.getParent().toString();
		String newPath = (directory + "\\" + name);
		FileDirectory newFile = new FileDirectory(newPath);
		System.out.println(newFile.absolutePath);
		try {
			Files.copy(originalFile.toPath(), newFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.deleteDirectory();
	}

}
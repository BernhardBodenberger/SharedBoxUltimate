import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import javax.swing.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.net.URL;

/**
 * Klasse, welche Objekte vom Typ Datei oder Verzeichnis modelliert. 
 * In dieser Klasse befinden sich alle Methoden, die auf Dateien und Verzeichnisse ausgeführt werden können.
 * @author SE1 Projektgruppe 7
 *
 */

public class FileDirectory extends File {
	String name; // Speichert den Namen des Files
	String absolutePath; // Speichert den Pfad des Files
	double speicherplatz; // Speichert die Größe des Files in KB
	
	// Konstruktor für die Klasse File Directory. String path wird an die Superklasse File weitergegeben
	public FileDirectory(String path) {
		super(path);
		this.name = this.getName();
		this.absolutePath = this.getAbsolutePath();
		this.speicherplatz = this.length(); //
	}
	/**
	 * Verschiebt eine Datei/Verzeichnis zu einem angegebenen Pfad. Der Pfad sollte wie folgt angegeben werden: C:/Users/Dell/Desktop/test.pdf
	 * Am Ende des Pfades muss der neue name der Datei/Verzeichnis angegeben werden (hier test.pdf).
	 * @param fileDestination = Pfad wohin die Datei/Verzeichnis hin verschoben wird
	 */
	public void move(String fileDestination) {
		try {
			Files.move(this.toPath(), new FileDirectory(fileDestination).toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("File move successful");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Kopiert die Datei/Verzeichnis auf welches diese Methode ausgeführt wird
	 * @return = gibt Datei/Verzeichnis zurück
	 */
	public FileDirectory copy() {
		FileDirectory originalFile = this; //
		return (originalFile);
	}
	/**
	 * Fügt eine Datei/Verzeichnis ins momentane Verzeichnis ein
	 * @param ablage     = Die Datei/Verzeichnis welches momentan in der Ablage gespeichert ist
	 * @param currentDir = der Pfad zum momentanen Verzeichnis
	 */
	public void paste(FileDirectory ablage, String currentDir) {
		try {
			Files.copy(ablage.toPath(), Paths.get(currentDir + "/" + ablage.name));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Benennt ein Verzeichnis/Datei um. Der neue name muss mit der richtigen Endung angegeben werden (z.B. test.pdf)
	 * @param newName = der neue Name der Datei/Verzeichnis
	 */
	public void rename(String newName) {
		try {
			Path source = Paths.get(this.absolutePath);
			// rename a file in the same directory
			Files.move(source, source.resolveSibling(newName));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Schneided eine Datei/Verzeichnis aus. D.h., dass die Datei/Verzeichnis auf welches diese Methode ausgeführt wird gelöscht wird
	 * und dann zurückgegeben wird.
	 * @return = gibt ausgeschnitte Datei/Verzeichnis zurück
	 */
	public FileDirectory cutOut() {
		FileDirectory copy = this;
		this.deleteDirectory();
		return (copy);
	}
	/**
	 * Zeigt die Eigenschaften einer Datei/Verzeichnis an. Hierzu gehören: Name des Files, Erstellungsdatum, ob die Datei ein Verzeichnis,
	 * eine Datei oder etwas anderes ist.
	 * @return = String mit den Eigenschaften der Datei/Verzeichnis
	 */
	public String showProperties() {
		String newLine = System.getProperty("line.separator");
		try {
			String path = this.absolutePath;
			Path pathOfFile = Paths.get(path);
			BasicFileAttributes attr = Files.readAttributes(pathOfFile, BasicFileAttributes.class);
			String s = ("filename         = " + this.name + newLine + "creationTime         = " + attr.creationTime()
					+ newLine + "isDirectory         = " + attr.isDirectory() + newLine + "isOther         = "
					+ attr.isOther() + newLine + "isRegularFile         = " + attr.isRegularFile() + newLine
					+ "isRegularFile         = " + attr.isRegularFile());
			return (s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ("");
	}
	/**
	 * Löscht die Datei/Verzeichnis auf welches diese Methode ausgeführt wird.
	 */
	public void deleteDirectory() {
		try {
			Path path = Paths.get(this.absolutePath);
			Files.walk(path).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void download(String source) throws IOException 
	{		
			File sourceFile = new File(source);
			JFileChooser dirChooser = new JFileChooser();
			int choiceDir = dirChooser.showSaveDialog(null);
			
			if(choiceDir == JFileChooser.APPROVE_OPTION) 
			{
				File dDir = dirChooser.getSelectedFile();				
				System.out.println(dDir);
				URL fetchWebsite = sourceFile.toURI().toURL();
				ReadableByteChannel readableByteChannel = Channels.newChannel(fetchWebsite.openStream());
	        
	        try (FileOutputStream fos = new FileOutputStream(dDir)) 
	        { 
	            fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
	        }
			}
	}
	
	
	public void upload(String destinationString) throws IOException 
	{  
		JFileChooser fileChooser = new JFileChooser();
		int choice = fileChooser.showOpenDialog(null);
		if(choice == JFileChooser.APPROVE_OPTION) {
			File uploadFile = new File(fileChooser.getSelectedFile(), "");
			URL sourceUrl = uploadFile.toURI().toURL();
			System.out.println(sourceUrl);
			ReadableByteChannel readByteChannel = Channels.newChannel(sourceUrl.openStream());
        try (FileOutputStream fos = new FileOutputStream(destinationString)) 
        { 
            fos.getChannel().transferFrom(readByteChannel, 0, Long.MAX_VALUE);
        }	
		}
	}
	/*public void upload(String fileToUpload) {
		System.out.println("moved");
		try {
			FileDirectory upload = new FileDirectory(fileToUpload);
			FileDirectory uploadTo = new FileDirectory(this.absolutePath + "/" + upload.name);
			Files.copy(upload.toPath(), uploadTo.toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.print(Paths.get(upload.absolutePath));
			System.out.print(Paths.get(uploadTo.absolutePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void download(String pathToDownload) {
		try {
			Files.copy(new FileDirectory(this.absolutePath).toPath(),
					new FileDirectory(pathToDownload + this.name).toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	/**
	 * Ersetzt die Datei/Verzeichnis auf welches diese Methode ausgeführt wird durch
	 * eine angegebene Datei/Verzeichnis. Der Pfad zur Datei die ersetzt werden soll sollte wie folgt angegeben werden:
	 * z.B. C:/Users/Dell/Desktop/test.pdf
	 * @param pathToFile = Gibt den Pfad zur Datei/Verzeichnis an durch welches die
	 * Datei/Verzeichnis ersetzt werden soll
	 */
	public void replace(String pathToFile) { // takes the file we want to replace this file with
		FileDirectory originalFile = new FileDirectory(pathToFile);
		String name = originalFile.getName();
		String directory = this.getParent().toString();
		String newPath = (directory + "\\" + name);
		FileDirectory newFile = new FileDirectory(newPath);
		try {
			Files.copy(originalFile.toPath(), newFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.deleteDirectory();
	}

}
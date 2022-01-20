import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class newDirectory {
	
	void my_deleteDirectory(Path path) throws IOException {
		  Files.walk(path)
		    .sorted(Comparator.reverseOrder())
		    .map(Path::toFile)
		    .forEach(File::delete);
		}
	void renameDirectory(File file) {
		
		System.out.println("Enter new name! \n");
		Scanner sc = new Scanner(System.in);
		String sc_input = sc.next();
		File newName = new File(file.getParent() + "//" + sc_input);
		file.renameTo(newName);
	}
	
	
	public static void main(String[] args) {
		
		File oldname = new File("/path/to/folder/folder");		
		new newDirectory().renameDirectory(oldname);
	}
}







public class MyFile extends FileDirectory {
	public MyFile(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	// MAIN METHOD
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// MyFile file1 = new MyFile(".\\src\\FileList.java"); // read
		// File of type FileOperations
		// FileOperations file2 = new FileOperations(".\\src\\Test"); // read File of
		// type FileOperations
		// print out properties of original file
		// System.out.println(file1.name);
		// System.out.println(file1.speicherplatz);
		// System.out.println(file1.absolutePath);

		// Copy a given File
		// FileOperations copy = file1.fileCopy();
		// print out properties of copy
		// System.out.println(copy.name);
		// System.out.println(copy.absolutePath);
		// System.out.println(copy.speicherplatz);
		// paste the copy to test folder
		// copy.filePaste(".\\src\\test\\" + copy.name);

		// Call the moveFile method
		// file2.moveFile(".\\src\\test\\" + file2.name);
		// file2.showProperties();
		// file2.fileRename("HelloWorld2.java");
		// String from = file1.absolutePath;
		// System.out.println(Paths.get(from));
		// FileOperations file3 = new FileOperations("C:/Users/Dell/Downloads/123.txt");
		// System.out.println(file3.speicherplatz);
		// System.out.println(file3.name);
		// file3.delete();
		// Path path =
		// Paths.get("C:/Users/Dell/eclipse-workspace/Studying/src/test/123.txt");
		// file2.deleteDirectory();
		// MyFile file2 = new
		// MyFile("C:/Users/Dell/eclipse-workspace/Studying/src/projectoutline_bb.pdf");
		// MyFile file3 = new
		// MyFile("C:/Users/Dell/eclipse-workspace/Studying/src/test/Einreiseanmeldung.pdf");
		// file2.replace(file3);
		// file1.showProperties();
		MyDirectory.VerzeichnisErstellen("this_is_a_test");

	}

}

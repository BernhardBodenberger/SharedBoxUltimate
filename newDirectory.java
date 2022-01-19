import java.io.File;
import java.io.IOException;
import java.util.*;

public class newDirectory {
/*	
	public void createUserDir(String dirName) throws IOException{
	    //File homeDir = new File(System.getProperty("user.home"));
		
	    String path = "/home/lontsipenn/eclipse-workspace";
	    File dir = new File(path, dirName);
	    boolean isCreated = dir.mkdirs();
	    if(isCreated) {
	    	System.out.println("Directory created");
	    } else if (dir.exists()){
	    	throw new IOException(dir.getAbsolutePath());
	    } else {
	    	throw new IOException("File could not be created!!!");
	    }
	}
*/
	public void renameUserDir(String dirName) throws IOException {
		//String path = "/home/lontsipenn/Destop/java_SE";
		File homeDir = new File(System.getProperty("user.home"));
		File dir = new File(homeDir,dirName);
		boolean isCreated = dir.mkdirs();
		
		if (isCreated) {
			System.out.println("Directory has been created!");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter new name of directory");
			String new_name = sc.nextLine();
			File newDir = new File(new_name);
			//File newDir = new File(dir.getParent() + "\\" + new_name);
			if (dir.renameTo(newDir)) {
				System.out.println("Directory renamed succesfully");
			} else {
				System.out.println("Unsuccesful attempt to rename");
			}
		}else {
			throw new IOException("File could not be created!!!");
		}
		
	}
	
	public void deleteDirectory(File file) throws IOException{
		if(file.isDirectory()) {
			File[] entries = file.listFiles();
			if(entries != null) {
				for (File entry : entries) {
					deleteDirectory(entry);
				}
			}
		}
		if (!file.delete()) {
			throw new IOException("Failed to delete " + file);
		}
	}
	
	public static boolean deleteDir(File dir) {
		File[] files = dir.listFiles();
		if(files != null) {
			for(File file : files) {
				if(file.isDirectory()) {
					deleteDir(file);
				} else {
					file.delete();
				}
			}
		}
		return dir.delete();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/home/lontsipenn/Desktop/java_SE/new_folder";
		//File homeDir = new File(System.getProperty("user.home"));
		File dir = new File(path);
		boolean iscreated = dir.mkdirs();
		if (iscreated) {	
			try {
				new newDirectory().deleteDirectory(dir);
			}catch(IOException e) {
				System.err.println("this " + e.getMessage());
			}
		}
	}	

}







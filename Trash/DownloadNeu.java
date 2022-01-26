import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;


public class DownloadNeu {

	
	public static void main(String[] args) throws IOException 
	{
		DownloadNeu upload1 = new DownloadNeu();
		//upload1.uploadDir("/Users/fabiandittrich/Desktop/SE1", "/Users/fabiandittrich/Desktop/AI");
		upload1.downloadFile("/Users/fabiandittrich/Desktop/BGB2.pdf");
		/*download1.download("/Users/fabiandittrich/desktop/", "UserData.csv"); 
		download1.upload("/Users/fabiandittrich/downloads/BGB3.pdf", "/Users/fabiandittrich/desktop/BGB.pdf");*/
	}
		
	
	
	public void downloadFile(String source) throws IOException 
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
	
	
	public void uploadFile(String destinationString) throws IOException 
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
	
	public void uploadDir(String sourceDirectoryString, String destinationStringDirectoryString) throws IOException{
		Files.walk(Paths.get(sourceDirectoryString))
		.forEach(source -> {
			Path destinationPath = Paths.get(destinationStringDirectoryString, source.toString()
					.substring(sourceDirectoryString.length()));
			try {
				Files.copy(source, destinationPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	/*public void uploadDir(String sourceDirectoryString, String destinationStringDirectoryString) throws IOException{
		Files.walk(Paths.get(sourceDirectoryString))
		.forEach(source -> {
			Path destinationPath = Paths.get(destinationStringDirectoryString, source.toString()
					.substring(sourceDirectoryString.length()));
			try {
				Files.copy(source, destinationPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			
		});
	}*/
}
	


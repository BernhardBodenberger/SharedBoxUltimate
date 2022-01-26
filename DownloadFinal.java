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


public class DownloadFinal {

	
	public static void main(String[] args) throws IOException 
	{
		DownloadFinal upload1 = new DownloadFinal();
		//upload1.uploadDir("/Users/fabiandittrich/Desktop/SE1", "/Users/fabiandittrich/Desktop/AI");
		//upload1.downloadFile("/Users/fabiandittrich/Desktop/BGB2.pdf");
		//download1.download("/Users/fabiandittrich/desktop/", "UserData.csv"); 
		//upload1.uploadFile("/Users/fabiandittrich/downloads/b");
		//upload1.uploadDir("/Users/fabiandittrich/Desktop/Server/");// Hier wieder auf das Slash achten
		upload1.downloadDir("/Users/fabiandittrich/Desktop/Testdirectory");
	}
		
	
	
	public void downloadFile(String source) throws IOException 
	{		
			File sourceFile = new File(source);
			JFileChooser dirchooser = new JFileChooser();
			int choiceDir = dirchooser.showSaveDialog(null);
			
			if(choiceDir == JFileChooser.APPROVE_OPTION) 
			{
				File dDir = dirchooser.getSelectedFile();				
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
	
	@SuppressWarnings("static-access")
	public void uploadDir(String destinationStringDirectoryString) throws IOException{
		JFileChooser updirChooser = new JFileChooser();
		updirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int opt = updirChooser.showOpenDialog(null);
		if (opt == updirChooser.APPROVE_OPTION) {
			File upDir =updirChooser.getSelectedFile();
			String upDirString= upDir.toString();
	
			String dirNameString = updirChooser.getName(upDir);
		
			Files.walk(Paths.get(upDirString))
			.forEach(source -> {
				Path destinationPath = Paths.get(destinationStringDirectoryString+dirNameString, source.toString()
						.substring(upDirString.length()));
				try {
					Files.copy(source, destinationPath);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
	}
	@SuppressWarnings("static-access")
	public void downloadDir(String sourceDirectoryString) throws IOException{
		
		JFileChooser downdirChooser = new JFileChooser();
		downdirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option = downdirChooser.showSaveDialog(null);
		
		if (option == downdirChooser.APPROVE_OPTION) 
		{
			File downDir =downdirChooser.getSelectedFile();
			String downDirString= downDir.toString();
			/* Wir bekommen nur den sourceDirectory String übergeben und suchen anhand eines Dialogfenster suchen wir den Zielpfad*/
			
			Files.walk(Paths.get(sourceDirectoryString))
			.forEach(source -> 
			{
				Path destinationPath = Paths.get(downDirString, source.toString()
						.substring(sourceDirectoryString.length()));
				try {
					Files.copy(source, destinationPath);
				} catch (IOException e) {
					e.printStackTrace();
				}	
			});
		}

	}
}
	


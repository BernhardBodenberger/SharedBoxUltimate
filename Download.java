import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


public class Download {

	
	/*public static void main(String[] args) throws IOException 
	{
		Download download1 = new Download();
		download1.download("/Users/fabiandittrich/desktop/", "UserData.csv"); 
		download1.upload("/Users/fabiandittrich/downloads/BGB3.pdf", "/Users/fabiandittrich/desktop/BGB.pdf");
	}*/
		
	
	
	public void download(String sourcePath, String fileName) throws IOException {

	        URL fetchWebsite = new URL("file://localhost"+sourcePath+fileName); 
	        ReadableByteChannel readableByteChannel = Channels.newChannel(fetchWebsite.openStream());
	        try (FileOutputStream fos = new FileOutputStream("/Users/fabiandittrich/desktop/UserDataTest.csv")) { 
	            fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
	        }
	    }
		
	public void upload(String destinationString, String soURLString) throws IOException {//
		
		URL sourceUrl = new File(soURLString).toURI().toURL();
		System.out.println(sourceUrl);
        ReadableByteChannel readByteChannel = Channels.newChannel(sourceUrl.openStream());
        try (FileOutputStream fos = new FileOutputStream(destinationString)) { 
            fos.getChannel().transferFrom(readByteChannel, 0, Long.MAX_VALUE);

	}
		
	}


		
	}


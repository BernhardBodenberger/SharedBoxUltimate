import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;


public class Download {
	
		public static void main(String[] args) throws IOException {

	        URL fetchWebsite = new URL("https://www.sueddeutsche.de/image/sz.1.4713503?v=1575642916&format=webp");
	        ReadableByteChannel readableByteChannel = Channels.newChannel(fetchWebsite.openStream());

	        try (FileOutputStream fos = new FileOutputStream("/Users/fabiandittrich/desktop/Intro.png")) {
	            fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
	        }
	    }
	}


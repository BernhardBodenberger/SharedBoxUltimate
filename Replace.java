import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Replace{
	public static void main(String[] args)throws IOException {
	    File inputFile = new File("C:\\FMP\\test.txt");
	    File tempFile = new File("C:\\sss.txt");

	    BufferedReader reader;
	    reader = new BufferedReader(new FileReader(inputFile));

	    BufferedWriter writer;
	    writer = new BufferedWriter(new FileWriter(tempFile));

	    String currentLine;
	    String lineToRemove = null;
	    

	    while((currentLine = reader.readLine()) != null) {
	        if(!currentLine.trim().equals(lineToRemove)){
	            writer.write(currentLine +     System.getProperty("line.separator"));
	        }
	    }
	    writer.close();
	    reader.close();

	    System.out.println("Input to temp1: " + tempFile.renameTo(inputFile));
	}
}
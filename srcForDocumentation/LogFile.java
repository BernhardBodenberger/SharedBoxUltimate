
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
/** @author SE1 Projektgruppe 7
 * @param 
 * @version 1.0
 * 
 * 
 * 
 * */
public class LogFile {
	

	public static void main(String[]args) {
		/*@param args Kommandozeilenoperator
		 *  */
		LogFile testLogFile = new LogFile();
		//testLogFile.creatLogFile("/Users/fabiandittrich/Desktop");
		testLogFile.editLogFile("Fabian", "File", "kopiert", "/Users/fabiandittrich/Desktop/");
		
	}
	
	public void creatLogFile(String nDirPath) 
	{	
	/* @param Sting der den Pfad repräsentiert des neuen Verzeichnisses an dem ein LogFile generiert werden soll
	 * @return void
	*/
		File nLog = new File(nDirPath,"LogFile.csv");
		try 
		{
			FileWriter logWriter = new FileWriter(nLog);
			BufferedWriter bWriter= new BufferedWriter(logWriter);
			PrintWriter pWriter= new PrintWriter(bWriter);
			pWriter.println("Nutzer: " + GUI2.User + "\nDatei/Verzeichnis: " + nDirPath + "\nOperation: Erstellt\nUhrzeit: " + new Date().toString() + "\n");
			pWriter.flush();
			pWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void editLogFile(String curUser, String curFioDir, String curOperation, String curDirectory) 
	/*Ale curUser sollte die eingelogte Email übergeben werden; Als curFioDir sollte der Pfad übergeben werden zur Datei oder
	 * dem Verzeichnis mit dem operiert wurde; Als curOperation die durchgeführte Operation; 
	 * Als curDirectory der Pfad des Verzeichnisses in dem das LogFile aktualisiert werden soll*/
	{
		String logFile = (curDirectory+"/LogFile.csv");
		
	
		try 
		{
			FileWriter logWriter = new FileWriter(logFile, true);
			BufferedWriter bWriter= new BufferedWriter(logWriter);
			PrintWriter pWriter= new PrintWriter(bWriter);
			Date timeString = new Date();
			timeString.toString();
			pWriter.println("Nutzer: " + curUser + "\nDatei/Verzeichnis: " + curFioDir+"\nOperation: " + curOperation +"\nUhrzeit: " + timeString + "\n");
			pWriter.flush();
			pWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
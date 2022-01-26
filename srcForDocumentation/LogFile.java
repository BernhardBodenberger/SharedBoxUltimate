
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
/**
* @author SE1 Projektgruppe 7
* @version 1.0
*/
public class LogFile {
	

	/*public static void main(String[]args) {
		LogFile testLogFile = new LogFile();
		//testLogFile.creatLogFile("/Users/fabiandittrich/Desktop");
		testLogFile.editLogFile("Fabian", "File", "kopiert", "/Users/fabiandittrich/Desktop/");
		
	}*/
/** 	
* @param nDirPath Variable um den Pfad des neu erstellten Directorys zu übergeben an dem das Logfile erstellt werden soll
* @return void
*	Die Funktion wird immer dann aufgerufen wenn ein neues Verzeichnis erstellt wird und 
*	sie sorgt dafür das in diesem neuen Verzeichnis auch dementsprechend eine Logdatei angelegt wird
*/
	public void creatLogFile(String nDirPath) 
	{	
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
/**
* @param curDirectory	Dieser Parameter repäsentiert den Pfad des Verzeichnisses, in dessen Log-Datei protokolliert werden soll
* @param curOperation	Dieser String Parameter repräsentiert die ausgeführte Operation
* @param curFioDir	Dieser Parameter repräsentiert die Datei oder das Verzeichnis auf dem die Operation ausgeführt wird
* @param curUser	Dieser Parameter steht für den User der die Operation ausführt
* @return void 		Die Methoden haben keinen Rückgabewert. Alle Aktionen werden innerhalb der Methode ausgeführt
* Die Methode editLogFile dient dazu jede Operation die von einem Anwender ausgführt wird mit folgenden Daten in der Log Datei zu dokumentieren
* In der Log-Datei wird dokumentiert Welcher User,auf welcher Datei oder Verzeichnis, welche Methode, zu welcher Zeit angewendet hat.
*/
	
	
	public void editLogFile(String curUser, String curFioDir, String curOperation, String curDirectory) 
	
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

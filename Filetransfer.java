/**
 * 
 */

/**
 * @author justus
 *
 */
//test
import java.io.*;
import java.util.*;
import java.awt.datatransfer.*;

public class Filetransfer implements Transferable {
	
	private Vector fileList;
	
	public Filetransfer(File file) {
		fileList = new Vector();
		fileList.add(file);
	}
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException{
		if( flavor.equals(DataFlavor.javaFileListFlavor))
			return fileList;
		
		throw new UnsupportedFlavorException(flavor);
	
	}
	public DataFlavor[] getTransferDataFlavors(){
	    return new DataFlavor[] {DataFlavor.javaFileListFlavor} ;
	}

	   
	public boolean isDataFlavorSupported(DataFlavor flavor){
	   return flavor.equals(DataFlavor.javaFileListFlavor) ;
	}


}

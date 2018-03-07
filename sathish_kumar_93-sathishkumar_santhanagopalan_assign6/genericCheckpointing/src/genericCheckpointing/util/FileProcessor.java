package genericCheckpointing.util;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class FileProcessor {

	private File fileObject;
	private Scanner scannerObject;

	public FileProcessor(String fileName) {
		//MyLogger.writeMessage("FileProcessor Constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		fileObject = new File(fileName);  
		try {
			if(!fileObject.exists())
				throw new FileNotFoundException();
			scannerObject = new Scanner(fileObject); 
		}catch(FileNotFoundException fileNotFoundException){
			System.err.println("Specified file not found");
			fileNotFoundException.printStackTrace();
			System.exit(0);
		}finally {
			//I do not find any usage for this block currently. 
			//Left empty on purpose, as specified by professor.
		}
	}

	//Method to read a line from file
	public String readLine() {
		String returnValue = null;		
		if(scannerObject.hasNextLine()) {
			returnValue = scannerObject.nextLine();
		}
		return returnValue;	
	}
		
}
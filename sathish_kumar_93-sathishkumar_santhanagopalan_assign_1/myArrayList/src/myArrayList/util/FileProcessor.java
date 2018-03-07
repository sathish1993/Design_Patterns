package myArrayList.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor{

	private int lineIndex;
	private File fileObject;
	private Scanner scannerObject;

	public FileProcessor(String fileName){
		lineIndex = 0;
		fileObject = new File(fileName);  
		try {
			if(!fileObject.exists())
				throw new FileNotFoundException();
			scannerObject = new Scanner(fileObject);
		}catch(FileNotFoundException fileNotFoundException){
			System.err.println("Specified file not found");
			fileNotFoundException.printStackTrace();
			System.exit(0);
		}finally{
			//I do not find any usage for this block currently. 
			//Left empty on purpose, as specified by professor.
		}
	}

	//Method to read a line from file
	public String readLine(){
		String returnValue = null;		
		for(int i = 0; i < lineIndex; i++)
			continue;

		if(scannerObject.hasNextLine()){
			returnValue = scannerObject.nextLine();
			lineIndex++;
		}
		return returnValue;	
	}
		
}
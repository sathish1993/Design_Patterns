package wordTree.store;

import wordTree.util.FileDisplayInterface;
import wordTree.util.StdoutDisplayInterface;
import wordTree.util.MyLogger;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private List<String> resultList = null;
	private String fileName = null;

	public Results(String fileNameI){
		MyLogger.writeMessage("Results constructor initialized", MyLogger.DebugLevel.CONSTRUCTOR);
		resultList = new ArrayList<String>();
		fileName = fileNameI;
	}

	//Method to return the result list
	public List<String> getResults(){
		return resultList;
	}

	//Method to store a new result into result list
	public void storeNewResult(String result){
		resultList.add(result);
	}

	//Method to write to file
	public void writeSchedulesToFile(){
		try{
			PrintWriter	printWriterObject = new PrintWriter(fileName, "UTF-8");	
			for(String result: resultList){
				printWriterObject.println(result);
			}
			printWriterObject.close();
		}catch(IOException e){
	    System.err.println("File not found");
	    e.printStackTrace();
	  }finally{
	   	//Left empty as specified by professor
	  }
	}

	//Method to write to console
	public void writeToScreen(){
		for(String result: resultList){
			System.out.println(result);
		}
	}

}
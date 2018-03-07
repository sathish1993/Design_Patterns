package airportSecurityState.util;

import airportSecurityState.util.MyLogger;

import java.util.List;
import java.util.ArrayList;

import java.io.PrintWriter;
import java.io.IOException;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {

	private List<String> resultsList = null;
	private PrintWriter printWriterObject = null;

	public Results(String file){
		try{
			MyLogger.writeMessage("Results Constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
			resultsList = new ArrayList<String>();
			printWriterObject = new PrintWriter(file, "UTF-8");	
		}catch(IOException e){
			System.err.println("File not found");
	    	e.printStackTrace();
		}
	}

	public List<String> getResults(){
		return resultsList;
	} 

	public void storeNewResult(String result){
		resultsList.add(result);
	}

	public void writeToFile(String s){
		printWriterObject.println(s);
	}

	public void writeToStdout(String s){
		System.out.println(s);
	}

	public void close(){
		printWriterObject.close();
	}

}
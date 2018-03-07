package myArrayList.util;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

	private List<String> resultList = null;
	private PrintWriter printWriterObject = null;

	public Results(String fileName){
		try{
			resultList = new ArrayList<String>();
			printWriterObject = new PrintWriter(fileName, "UTF-8");	
		}catch(IOException e){
	    	System.err.println("File not found");
	    	e.printStackTrace();
	    }finally{
	    	//Left empty as specified by professor
	    }
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
	public void writeToFile(String s){
		printWriterObject.println(s);
	}

	//Method to write to console
	public void writeToStdout(String s){
		System.out.println(s);
	}

	//Method to close printWriter object
	public void close(){
		printWriterObject.close();
	}
}
package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;

import java.io.PrintWriter;
import java.io.IOException;

public class Results implements StdoutDisplayInterface, FileDisplayInterface{

	private Map<Integer, List<String>> resultsMap = null;
	private PrintWriter printWriterObject = null;

	public Results(String file){
		try{
			resultsMap = new TreeMap<Integer, List<String>>();
			printWriterObject = new PrintWriter(file, "UTF-8");	
		}catch(IOException e){
			System.err.println("File not found");
	    	e.printStackTrace();
		}
	}

	public Map<Integer, List<String>> getResults(){
		return resultsMap;
	} 

	//Method to traverse tree in pre-order way and store node in a map
	public void printNodes(Node rootP){
		if(rootP == null)
			return;
		printNodes(rootP.left);
		resultsMap.put(rootP.getBNumber(), rootP.getCourseList());
		printNodes(rootP.right);
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
package myArrayList.driver;

import myArrayList.MyArrayList;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;
import myArrayList.test.MyArrayListTest;

import java.util.List;

public class Driver{

	public static void main(String[] args){
		
		if(args[0].equals("${arg0}") || args[1].equals("${arg1}")){
			System.err.println("Error!!! \n Usage: ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt");
			System.exit(0);				
		}

	    MyArrayList myArrayListObject = new MyArrayList();
	    FileProcessor fileProcessorObject = new FileProcessor(args[0]);
	    Results resultsObject = new Results(args[1]);
	    MyArrayListTest myArrayListTestObject = new MyArrayListTest(myArrayListObject, fileProcessorObject);
	    myArrayListTestObject.testMe(myArrayListObject, resultsObject);
			   
	    List<String> resultsList = resultsObject.getResults();
	    resultsObject.writeToFile("The sum of all the values in the array list is: " + myArrayListObject.sum());

	    if(resultsList != null){
	    		for(String result : resultsList){
	    			resultsObject.writeToFile(result);
	    			resultsObject.writeToStdout(result);
	    		}
	    }else{
	    		resultsObject.writeToFile("No results found currently");
	    		resultsObject.writeToStdout("No results found currently");
	    }
	    resultsObject.close();	    
	}
}

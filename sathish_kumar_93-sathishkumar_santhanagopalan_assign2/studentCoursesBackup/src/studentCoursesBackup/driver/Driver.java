package studentCoursesBackup.driver;

import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Observable;
import studentCoursesBackup.util.Results;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.SubjectI;

import java.lang.NumberFormatException;
import java.util.List;
import java.util.Map;

public class Driver{
	
	//Method to read input file and build tree based on input
	private void processInputFile(FileProcessor fileProcessorInput, TreeBuilder treeBuilder){
		Node node = null;
		while(true){
			String input = fileProcessorInput.readLine();
			if(input == null)
				break;
			String[] parts = input.split(":");
			try{
				int bNum = Integer.parseInt(parts[0]);
				String course = parts[1];
				if(bNum < 1000 || bNum > 9999 || course.charAt(0) < 65 || course.charAt(0) > 75 || parts.length > 2)
					continue;
				node = new Node(bNum);	
			}catch(NumberFormatException e){
				System.err.println("Parse Exception");
				e.printStackTrace();
			}finally{
				//Left empty as specified by professor
			}
			Node root = treeBuilder.getOriginalRoot();
			Node tempNode = treeBuilder.searchNode(root, node.getBNumber());
			if(tempNode == null){
				List<String> tempList = node.getCourseList();
				tempList.add(parts[1]);
				node.setCourseList(tempList);
				treeBuilder.insertNode(node);
			}else{
				Node tempClone1 = treeBuilder.getClone1Root();
				Node tempNodeClone1 = treeBuilder.searchNode(tempClone1, node.getBNumber());
				Node tempClone2 = treeBuilder.getClone2Root();
				Node tempNodeClone2 = treeBuilder.searchNode(tempClone2, node.getBNumber());
				appendCourse(tempNode, parts[1]);
				appendCourse(tempNodeClone1, parts[1]);
				appendCourse(tempNodeClone2, parts[1]);
			}
		}
	}

	//Method to read delete.txt and remove a course in the tree
	private void processDeleteFile(FileProcessor fileProcessorOutput, TreeBuilder treeBuilder, Observable observable){
		int delNode = 0;
		while(true){
			String input = fileProcessorOutput.readLine();
			if(input == null)
				break;
			String[] parts = input.split(":");
			try{
				int bNum = Integer.parseInt(parts[0]);
				String course = parts[1];
				if(bNum < 1000 || bNum > 9999 || course.charAt(0) < 65 || course.charAt(0) > 75 || parts.length > 2)
					continue;
				delNode = Integer.parseInt(parts[0]);
			}catch(NumberFormatException e){
				System.err.println("Parse Exception");
				e.printStackTrace();
			}finally{
				//Left empty as specified by professor
			}

			Node root = treeBuilder.getOriginalRoot();
			Node tempNode = treeBuilder.searchNode(root, delNode);
			if(tempNode != null){
				List<String> tempList = tempNode.getCourseList();
				if(tempList.contains(parts[1])){
					tempList.remove(parts[1]);
					tempNode.setCourseList(tempList);
					observable.notifyObservers(tempNode, parts[1]);
				}
			}
		}
	} 

	//Method to append course into a list
	private void appendCourse(Node node, String course){
		List<String> tempList = node.getCourseList();
		if(!tempList.contains(course)){
			tempList.add(course);
			node.setCourseList(tempList);
		}
	}

	//Method to print tree results into stdout and file
	private void printResults(Results results){
		Map<Integer, List<String>> resultsList = results.getResults();
		if(resultsList != null){
			for(Map.Entry<Integer, List<String>> result : resultsList.entrySet()){
					String course_List = "";
					for(String course : result.getValue())
						course_List += course + " ";
	    			results.writeToFile(result.getKey() + " : " + course_List);
	    	}
		}else{
	    	results.writeToFile("No results found currently");
	    	results.writeToStdout("No results found currently");
	    }
	}

	public static void main(String args[]){
		if(args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || 
				args[2].equals("${arg2}") || args[3].equals("${arg3}") || args[4].equals("${arg4}")){
			System.err.println("Error!!! Usage: ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=delete.txt -Darg2=output1.txt -Darg3=output2.txt -Darg4=output3.txt");
			System.exit(0);
		}

		FileProcessor fileProcessorInput = new FileProcessor(args[0]);
		FileProcessor fileProcessorOutput = new FileProcessor(args[1]);
		Driver driver = new Driver();

		TreeBuilder treeBuilder = new TreeBuilder();
		Observable observable = new Observable();
		
		driver.processInputFile(fileProcessorInput, treeBuilder);
		driver.processDeleteFile(fileProcessorOutput, treeBuilder, observable);
		
		Results resultsOriginal = new Results(args[2]);
		resultsOriginal.printNodes(treeBuilder.getOriginalRoot());
		driver.printResults(resultsOriginal);
	    
		Results resultsClone1 = new Results(args[3]);
		resultsClone1.printNodes(treeBuilder.getClone1Root());
		driver.printResults(resultsClone1);    

		Results resultsClone2 = new Results(args[4]);
		resultsClone2.printNodes(treeBuilder.getClone2Root());
		driver.printResults(resultsClone2);

	    resultsOriginal.close();
	    resultsClone1.close();
	    resultsClone2.close();

	}
}
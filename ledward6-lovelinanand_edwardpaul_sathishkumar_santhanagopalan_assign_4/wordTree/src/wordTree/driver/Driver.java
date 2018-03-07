package wordTree.driver;

import wordTree.util.MyLogger;
import wordTree.util.WordStatistics;
import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.treeBuilder.TreeBuilder;
import wordTree.threadMgmt.CreateWorkers;

import java.util.List;

public class Driver {

	public static void main(String args[]) {

		try {
			if(args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}") || args[4].equals("${arg4}") || Integer.parseInt(args[4]) < 0 
				|| Integer.parseInt(args[4]) > 4) {
				System.err.println("Error!!! Usage: ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=NumberOfThreads -Darg3=DeleteWords -Darg4=[0-4]");
				System.exit(0);
			}
		}catch(NumberFormatException e) {
			System.err.println("Number Format Exception!! Please enter proper value between 0 and 4. Number Format Exception");
			e.printStackTrace();
			System.exit(0);		
		}
		String[] delWords = args[3].split("\\s+");
		int NUM_THREADS = Integer.parseInt(args[2]);
		if(delWords.length != NUM_THREADS) {
			System.err.println("Delete words length did not match the count of NUM_THREADS");
			System.exit(0);
		}

		int debugLevel = Integer.parseInt(args[4]);
		MyLogger.setDebugValue(debugLevel);

		FileProcessor fileProcessorInput = new FileProcessor(args[0]);
		TreeBuilder treeBuilder = new TreeBuilder();
		Results results = new Results(args[1]);
		CreateWorkers createWorkers = new CreateWorkers(fileProcessorInput, delWords, treeBuilder);
		createWorkers.startPopulateWorkers(NUM_THREADS);
		// System.out.println("***************************************************");
		createWorkers.startDeleteWorkers(NUM_THREADS);
		WordStatistics wordStatistics = new WordStatistics(treeBuilder.getRootNode());
		results.storeNewResult("The total number of words: " + wordStatistics.getWordCount());
		results.storeNewResult("The total number of characters: " + wordStatistics.getCharCount());
		results.storeNewResult("The total number of unique words: " + wordStatistics.getUniqueWordCount());
		results.writeSchedulesToFile();
		if(debugLevel == 1){
			results.writeToScreen();
		}
	}
}
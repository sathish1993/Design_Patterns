package fileVisitors.driver;

import fileVisitors.treeBuilder.TreeBuilder;
import fileVisitors.wordManipulation.WordManipulation;
import fileVisitors.util.MyLogger;
import fileVisitors.visitor.VisitorI;
import fileVisitors.visitor.PalindromeHighlight;
import fileVisitors.visitor.PrimeLength;
import fileVisitors.visitor.PrintTree;
import fileVisitors.visitor.PopulateVisitor;
import fileVisitors.util.Results;
public class Driver {

	public static void main(String args[]) {

		try {
			if(args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") ||
				Integer.parseInt(args[2]) < 0 || Integer.parseInt(args[2]) > 4) {
				System.err.println("Error!!! Usage: ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=[0-4]");
				System.exit(0);
			}
		}catch(NumberFormatException e) {
			System.err.println("Number Format Exception!! Please enter proper value between 0 and 4. Number Format Exception");
			e.printStackTrace();
			System.exit(0);		
		}

		int debugLevel = Integer.parseInt(args[2]);
		MyLogger.setDebugValue(debugLevel);
		Results results = new Results();

		TreeBuilder treeBuilder = new TreeBuilder();
		WordManipulation wordManipulation = new WordManipulation(treeBuilder);
		
		VisitorI populateVisitor = new PopulateVisitor(args[0]);
		VisitorI printTree = new PrintTree(results);
		VisitorI palindromeHighlight = new PalindromeHighlight();
		VisitorI primeLength = new PrimeLength();

		wordManipulation.accept(populateVisitor);
		wordManipulation.accept(palindromeHighlight);		
		wordManipulation.accept(primeLength);
		wordManipulation.accept(printTree);
		if(debugLevel == 1){
			results.writeToStdout();
		}

		results.writeToFile(args[1]);
	}
}
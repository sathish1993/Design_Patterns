package airportSecurityState.driver;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.Results;
import airportSecurityState.airportStates.Airport;
import airportSecurityState.airportStatesHelper.AirportMetrics;

import java.util.List;

import java.lang.NumberFormatException;
import airportSecurityState.util.MyLogger;

//http://www.newthinktank.com/2012/10/state-design-pattern-tutorial/
public class Driver {
	
	public static void main(String args[]) {

		try {
			if(args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
				System.err.println("Error!!! Usage: ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=[0-4]");
				System.exit(0);
			}
			if(Integer.parseInt(args[2]) < 0 && Integer.parseInt(args[2]) > 5) {
				System.err.println("Error!!! Usage: ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=[0-4]");
				System.exit(0);		
			}	
		}catch(NumberFormatException e) {
			System.err.println("Number Format Exception!! Pleasae enter proper value between 0 and 4. Number Format Exception");
			e.printStackTrace();
			System.exit(0);		
		}

		int debugLevel = Integer.parseInt(args[2]);
		MyLogger.setDebugValue(debugLevel);
		
		FileProcessor fileProcessor = new FileProcessor(args[0]);
		Results results = new Results(args[1]);
		Airport airport = new Airport();
		AirportMetrics airportMetrics = new AirportMetrics();
		List<String> prohibitedItems = airport.getProhibitedItems();

		while(true) {
			MyLogger.writeMessage("Line read from input.txt", MyLogger.DebugLevel.READ_INPUT);
			String input = fileProcessor.readLine();
			if(input == null)
				break;

			airportMetrics.parseInput(airport, results, prohibitedItems, input);
		}

		List<String> resultsList = results.getResults();
		if(resultsList != null) {
    		for(String result : resultsList) {
    			results.writeToFile(result);
    		}
    	}else {
    		results.writeToFile("No results found currently");
    	}
    	results.close();	    
	}
}
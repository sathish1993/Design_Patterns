package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStatesHelper.StateFinder;


public class LowRisk implements AirportStateI {

	private Airport airport;

	public LowRisk(Airport newAirport){
		MyLogger.writeMessage("LowRisk Constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		airport = newAirport;
	}

	public void tightenOrLoosenSecurity(int avgTraffic, int avgItems) {
		StateFinder stateFinder = new StateFinder();
		stateFinder.calculateStateWithMetrics(airport, avgTraffic, avgItems);
	}

	public String doOperations() {
		MyLogger.writeMessage("Operations are carried out for Low Risk", MyLogger.DebugLevel.OPERATIONS);
		return "1 3 5 7 9";
	}
}
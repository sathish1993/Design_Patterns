package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStatesHelper.StateFinder;


public class HighRisk implements AirportStateI {

	private Airport airport;

	public HighRisk(Airport newAirport) {
		MyLogger.writeMessage("HighRisk Constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		airport = newAirport;
	}

	public void tightenOrLoosenSecurity(int avgTraffic, int avgItems) {
		StateFinder stateFinder = new StateFinder();
		stateFinder.calculateStateWithMetrics(airport, avgTraffic, avgItems);
	}

	public String doOperations() {
		MyLogger.writeMessage("Operations are carried out for High Risk", MyLogger.DebugLevel.OPERATIONS);
		return "2 4 6 8 10";
	}
}
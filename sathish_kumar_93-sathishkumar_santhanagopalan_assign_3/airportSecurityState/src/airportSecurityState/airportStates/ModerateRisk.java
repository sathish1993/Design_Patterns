package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStatesHelper.StateFinder;

public class ModerateRisk implements AirportStateI {

	private Airport airport;

	public ModerateRisk(Airport newAirport){
		MyLogger.writeMessage("ModerateRisk Constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		airport = newAirport;
	}

	public void tightenOrLoosenSecurity(int avgTraffic, int avgItems) {
		StateFinder stateFinder = new StateFinder();
		stateFinder.calculateStateWithMetrics(airport, avgTraffic, avgItems);
	}

	public String doOperations() {
		MyLogger.writeMessage("Operations are carried out for Moderate Risk", MyLogger.DebugLevel.OPERATIONS);
		return "2 3 5 8 9";
	}
}
package airportSecurityState.airportStatesHelper;

import airportSecurityState.airportStates.Airport;
import airportSecurityState.util.MyLogger;

public class StateFinder {

	public void calculateStateWithMetrics(Airport airport, int avgTraffic, int avgItems) {
		System.out.println("avgTraffic " + avgTraffic + " avgItems" + avgItems);
		if((avgTraffic >= 8) || (avgItems >= 2)) {
			MyLogger.writeMessage("Airport State Changed to High Risk", MyLogger.DebugLevel.IN_RUN);
			airport.setAirportSecurityState(airport.getHighRiskState());
		}else if((avgTraffic >= 4 && avgTraffic < 8) || (avgItems >= 1 && avgItems < 2)) {
			MyLogger.writeMessage("Airport State Changed to Moderate Risk", MyLogger.DebugLevel.IN_RUN);
			airport.setAirportSecurityState(airport.getModerateRiskState());
		}else if((avgTraffic >= 0 && avgTraffic < 4) || (avgItems >= 0 && avgItems < 1)) {
			MyLogger.writeMessage("Airport State C hanged to Low Risk", MyLogger.DebugLevel.IN_RUN);
			airport.setAirportSecurityState(airport.getLowRiskState());
		}	
	}
}
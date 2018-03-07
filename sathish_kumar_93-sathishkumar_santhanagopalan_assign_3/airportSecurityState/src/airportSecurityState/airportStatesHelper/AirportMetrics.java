package airportSecurityState.airportStatesHelper;

import airportSecurityState.airportStates.Airport;
import airportSecurityState.util.Results;


import java.util.List;

public class AirportMetrics {
	
	public int findAverageTrafficPerDay(int totalTravellers, int totalDays) {
		return totalTravellers/totalDays;
	}

	public int findAverageProhibitedItemsPerDay(int totalProhibitedItems, int totalDays) {
		return totalProhibitedItems/totalDays;
	}

	public void parseInput(Airport airport, Results results, List<String> prohibitedItems, String input) {
		int itemCount = airport.getItemCount();
		String[] strArr = input.split(";");
		int avgItems = 0, avgTraffic = 0;
		// if(strArr.length != 4)
			// continue;

		airport.setTravellerCount(airport.getTravellerCount() + 1);
		String[] day = strArr[0].split(":", 2);
		airport.setDayCount(Integer.parseInt(day[1]));

		String[] item = strArr[3].split(":", 2);
		if(prohibitedItems.contains(item[1]))
			airport.setItemCount(++itemCount);

		avgTraffic = findAverageTrafficPerDay(airport.getTravellerCount(), airport.getDayCount());
		avgItems = findAverageProhibitedItemsPerDay(airport.getItemCount(), airport.getDayCount());
		String operations = airport.checkSecurityLevel(avgTraffic, avgItems);
		results.storeNewResult(operations);
	}	
}


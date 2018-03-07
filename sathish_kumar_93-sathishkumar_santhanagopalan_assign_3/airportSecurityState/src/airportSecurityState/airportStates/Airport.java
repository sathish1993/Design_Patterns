package airportSecurityState.airportStates;

import airportSecurityState.airportStates.AirportStateI;
import airportSecurityState.util.MyLogger;
import airportSecurityState.airportStatesHelper.AirportMetrics;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Airport {

	private AirportStateI lowRisk;
	private AirportStateI moderateRisk;
	private AirportStateI highRisk;
	private AirportStateI currentState;
	
	List<String> itemsList = null;
	private int travellerCount;
	private int dayCount;
	private int itemCount;

	public Airport() {
		MyLogger.writeMessage("Airport Constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
		lowRisk = new LowRisk(this);
		moderateRisk = new ModerateRisk(this);
		highRisk = new HighRisk(this);
		currentState = lowRisk;

		travellerCount = 0;
		dayCount = 0;
		itemCount = 0;
		itemsList = new ArrayList<String>();
		itemsList.add("Gun");
		itemsList.add("NailCutter");
		itemsList.add("Blade");
		itemsList.add("Knife");
	}

	public int getTravellerCount() {
		return travellerCount;
	}

	public void setTravellerCount(int newCount) {
		travellerCount = newCount;
	}

	public int getDayCount() {
		return dayCount;
	}

	public void setDayCount(int newCount) {
		dayCount = newCount;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int newCount) {
		itemCount = newCount;
	}	

	public AirportStateI getLowRiskState() {
		return lowRisk;
	}

	public AirportStateI getModerateRiskState() {
		return moderateRisk;
	}

	public AirportStateI getHighRiskState() {
		return highRisk;
	}

	public AirportStateI getCurrentState() {
		return currentState;
	}

	//Method to update current state
	public void setAirportSecurityState(AirportStateI newState) {
		currentState = newState;
	}

	//Method to check current state based on the input metrics
	public String checkSecurityLevel(int avgTraffic, int avgItems) {
		currentState.tightenOrLoosenSecurity(avgTraffic, avgItems);
		return currentState.doOperations();
	}

	public List<String> getProhibitedItems() {
		return itemsList;
	}

}
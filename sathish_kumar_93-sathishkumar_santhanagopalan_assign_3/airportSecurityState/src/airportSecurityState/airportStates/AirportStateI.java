package airportSecurityState.airportStates;

public interface AirportStateI {
	public void tightenOrLoosenSecurity(int avgTraffic, int avgItems);
	public String doOperations();
}
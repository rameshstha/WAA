package com.ramesh;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 *  
 * @author Ramesh
 *
 */
public class Data {
	private List<FlightDetails> flightDetails = new ArrayList<FlightDetails>();
	private List<String> airlineName=new ArrayList<String>();
	
	public Data() {
		flightDetails.add(new FlightDetails("Amsterdam", "New York", "12/11/16", "KLM", 790.80));
		flightDetails.add(new FlightDetails("Amsterdam", "New York", "12/11/16", "NorthWest", 795.55));
		flightDetails.add(new FlightDetails("Amsterdam", "New York", "12/11/16", "KLM", 820.00));
		flightDetails.add(new FlightDetails("Amsterdam", "New York", "12/11/16", "United Airlines", 825.50));
		flightDetails.add(new FlightDetails("Amsterdam", "New York", "12/11/16", "NorthWest", 875.00));
		flightDetails.add(new FlightDetails("Amsterdam", "New York", "12/11/16", "KLM", 989.00));
		flightDetails.add(new FlightDetails("Amsterdam", "New York", "12/11/16", "United Airlines", 1050.00));
	}

	public List<FlightDetails> getFlightDetails() {
		return flightDetails;
	}


    public List<FlightDetails> findByAirline(String airline){
    	List<FlightDetails> flightByAirlines = new ArrayList<FlightDetails>();
        for(FlightDetails fd: flightDetails){
           if((fd.getAirline().compareTo(airline)==0))
           {
        	   flightByAirlines.add(fd);
           }
       }
       return flightByAirlines;
    }
    
    public List<String> airlines(){
    	airlineName.add("All");	
    	for(FlightDetails fd: flightDetails){
    		airlineName.add(fd.getAirline());
    	}
    	
    	return airlineName.stream().distinct().collect(Collectors.toList());
    }
}

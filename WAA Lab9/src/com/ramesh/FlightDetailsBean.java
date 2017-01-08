package com.ramesh;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ValueChangeEvent;

/**
 *  
 * @author Ramesh
 *
 */

public class FlightDetailsBean {
    private String selectedAirline="All";//default
    private Data db;
    List<FlightDetails> airlineDetails=new ArrayList<FlightDetails>();
    List<String> airline=new ArrayList<String>();
    
    
    public FlightDetailsBean(){
    	db=new Data();
    	airlineDetails=db.getFlightDetails();
    }
    
	public Data getDb() {
		return db;
	}

	public String getSelectedAirline() {
		return selectedAirline;
	}

	public void setSelectedAirline(String selectedAirline) {
		this.selectedAirline = selectedAirline;
	}

	public List<FlightDetails> getAirlineDetails() {
		return airlineDetails;
	}
    
	public List<String> getAirline() {
		return db.airlines();
	}
	
	public void airlineChanged(ValueChangeEvent e){
		airlineDetails=db.findByAirline(e.getNewValue().toString());
	}


}

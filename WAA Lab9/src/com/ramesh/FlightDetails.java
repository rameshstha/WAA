package com.ramesh;

public class FlightDetails {
	private String source;
	private String destination;
	private String date;
	private String airline;
	private double fare;

	public FlightDetails(String source, String destination, String date, String airline, double fare) {
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.airline = airline;
		this.fare = fare;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}
}

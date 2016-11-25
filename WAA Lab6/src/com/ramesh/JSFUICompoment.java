/**
 * 
 */
package com.ramesh;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;

import org.apache.catalina.tribes.util.Arrays;

/**
 * @author Ramesh
 *
 */
@ManagedBean
@ReferencedBean
public class JSFUICompoment {
	public String from_source;
	public String to_destination;
	
	public String depart_date;
	public String return_date;
	public String trip;
	
	public String[] options;
	
	public JSFUICompoment() {}

	public String getFrom_source() {
		return from_source;
	}

	public void setFrom_source(String from_source) {
		this.from_source = from_source;
	}

	public String getTo_destination() {
		return to_destination;
	}

	public void setTo_destination(String to_destination) {
		this.to_destination = to_destination;
	}

	public String getDepart_date() {
		return depart_date;
	}

	public void setDepart_date(String depart_date) {
		this.depart_date = depart_date;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public String getTrip() {
		return trip;
	}

	public void setTrip(String trip) {
		this.trip = trip;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}
	
	public String output(){
		System.out.println("From:"+getFrom_source());
		System.out.println("To:"+getTo_destination());
		System.out.println("Departure date:"+getDepart_date());
		System.out.println("Return date:"+getReturn_date());
		System.out.println(getTrip());
		System.out.println("Options:"+Arrays.toString(getOptions()).replace("{", "").replace("}", ""));
		
		return null;
	}
}

package com.ramesh;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DateTempConversion {
	private Date date;
	private String temperature;
	private String outputDate;
	
	public DateTempConversion() {}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

		public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
    
	public String getOutputDate() {
		return outputDate;
	}

	public void setOutputDate(String outputDate) {
		this.outputDate = outputDate;
	}


	public String outputConv(){
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
        outputDate=formatter.format(date);
        
        return "outputConvert";
	}
}

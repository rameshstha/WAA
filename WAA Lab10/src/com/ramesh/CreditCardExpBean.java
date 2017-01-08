package com.ramesh;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CreditCardExpBean {
	private int month;
	private int year;
	
	private int maxMonth;
	private int minMonth;
	private int maxYear;
	private int minYear;

	public CreditCardExpBean() {
		minMonth=1;
		maxMonth=31;
		minYear=2000;
		maxYear=2022;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMaxMonth() {
		return maxMonth;
	}

	public void setMaxMonth(int maxMonth) {
		this.maxMonth = maxMonth;
	}

	public int getMinMonth() {
		return minMonth;
	}

	public void setMinMonth(int minMonth) {
		this.minMonth = minMonth;
	}

	public int getMaxYear() {
		return maxYear;
	}

	public void setMaxYear(int maxYear) {
		this.maxYear = maxYear;
	}

	public int getMinYear() {
		return minYear;
	}

	public void setMinYear(int minYear) {
		this.minYear = minYear;
	}

	public String decrementmonthAction() {
		if(month<=minMonth)
			year=minMonth;
		else
		month -= 1;
		return null;
	}

	public String decrementyearAction() {
		if(year<=minYear)
			year=minYear;
		else
		year -= 1;
		return null;
	}

	public String incrementmonthAction() {
		if(month>=maxMonth)
			month=maxMonth;
		else
		month += 1;
		return null;
	}

	public String incrementyearAction() {
		if(year>=maxYear)
			year=maxYear;
		else
		year += 1;
		return null;
	}
	
	public String nextButtonAction(){
		return "creditCardExpInfo";
	}

}

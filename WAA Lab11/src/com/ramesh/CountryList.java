package com.ramesh;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CountryList {
	private List<String> country = new ArrayList<String>();
	private List<String> searchCountry=new ArrayList<String>();

	public CountryList() {

		String[] locales = Locale.getISOCountries();

		for (String countryCode : locales) {
			Locale obj = new Locale("", countryCode);
			country.add(obj.getDisplayCountry());
		}
	}

	public List<String> getCountry() {
		return country;
	}

	public void setCountry(List<String> country) {
		this.country = country;
	}
	
	 public List<String> countrySearch(String countryLetter){
	        for(String str : country){
	            if(str.toLowerCase().startsWith(countryLetter.toLowerCase())){
	                searchCountry.add(str);
	            }
	        }
	    	return searchCountry;
	 }
}

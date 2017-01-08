package com.ramesh;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@ViewScoped
public class MyBean {
	private String countryLetter;
	private List<String> countryList;
	private CountryList cl;
    
	public MyBean(){
	 	cl=new CountryList();
	 	countryList=cl.getCountry();
	}
	public CountryList getCl() {
		return cl;
	}

	public String getCountryLetter() {
		return countryLetter;
	}

	public void setCountryLetter(String countryLetter) {
		this.countryLetter = countryLetter;
	}

	public List<String> getCountryList() {
		return countryList;
	}

	public void country(AjaxBehaviorEvent e){
      countryList=cl.countrySearch(countryLetter);
        }
        
        
        
    
    

}

package com.ramesh;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.ramesh.TempConverter")
public class TempConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String temp) {
		String outputTemperature;
		
		if(!temp.matches("[cfCF]{1}[0-9]{2}")){
			return "Input Values should be like c45 or f56";
		}
		else{
		char unit=temp.charAt(0);
		if('c'==unit || 'C'==unit)
			outputTemperature=temp.substring(1, temp.length())+" "+"Celcius";
        
		else
			outputTemperature=temp.substring(1, temp.length())+" "+"Fahrenheit";
		
		return outputTemperature;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object temp) {
		// TODO Auto-generated method stub
		return temp.toString();
	}
	
}

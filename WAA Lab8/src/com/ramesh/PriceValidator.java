package com.ramesh;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator ("com.ramesh.PriceValidator")
public class PriceValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if(Integer.parseInt(value.toString())<1){
			FacesMessage msg =
					new FacesMessage("The value \""+value+"\" is smaller than the minumum value of 1");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
		}
		
		else if(Integer.parseInt(value.toString())>100000){
			FacesMessage msg =
					new FacesMessage("The value "+value+" is greater than the maximum value of 100000");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
		}
		
	}
 
}

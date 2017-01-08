package com.ramesh;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.ramesh.LicenseValidator")
public class LicenceValidator implements Validator {

		@Override
		public void validate(FacesContext context, UIComponent component,
				Object value) throws ValidatorException {
            
			if(!value.toString().matches("^[A-Z]{2}\\-[0-9]{2}\\-[A-Z]{2}$") || value.toString().equals(null)){

				FacesMessage msg =
					new FacesMessage("License plate is not valid");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);

			}

		}

}

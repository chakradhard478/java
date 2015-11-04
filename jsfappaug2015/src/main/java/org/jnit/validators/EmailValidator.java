package org.jnit.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

	static String emailRegex = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
	static Pattern pattern = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
	static Matcher matcher;

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		matcher = pattern.matcher(value.toString());
	    
	    if (!matcher.matches()) {
//	      context.addMessage(component.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
//	              "Enter valid email Id."));

	      FacesMessage msg =
	              new FacesMessage(" Please provide E-mail address in this format: abcd@abc.com ",
	              "E-mail validation failed.");
	      msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	      
	      throw new ValidatorException(msg);
	    }
	}

}

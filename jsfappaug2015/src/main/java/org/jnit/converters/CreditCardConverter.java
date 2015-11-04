package org.jnit.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("creditCardConverter")
public class CreditCardConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newValue) {
		String convertedValue = null;
	    if ( newValue == null ) {
	        return newValue;
	    }
	    // Since this is only a String to String conversion,
	    // this conversion does not throw ConverterException.
	    
	    convertedValue = newValue.trim();
	    if ( (convertedValue.contains("-")) ||
	         (convertedValue.contains(" "))) {
	        char[] input = convertedValue.toCharArray();
	        StringBuilder builder = new StringBuilder(input.length);
	        for ( int i = 0; i < input.length; ++i ) {
	            if ( input[i] == '-' || input[i] == ' '  ) {
	                continue;
	            } else {
	                builder.append(input[i]);
	            }
	        }
	        convertedValue = builder.toString();
	    }
	    return convertedValue;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String inputVal = null;
	    if ( value == null ) {
	        return null;
	    }
	    // value must be of a type that can be cast to a String.
	    try {
	        inputVal = (String)value;
	    } catch (ClassCastException ce) {
	        FacesMessage errMsg = new FacesMessage("Credit card conversion failed");
	        FacesContext.getCurrentInstance().addMessage(null, errMsg);
	        throw new ConverterException(errMsg.getSummary());
	    }
	    // insert spaces after every four characters for better
	    // readability if they are not already present.
	    char[] input = inputVal.toCharArray();
	    StringBuilder builder = new StringBuilder(input.length + 3);
	    for ( int i = 0; i < input.length; ++i ) {
	        if ( (i % 4) == 0 && i != 0) {
	            if (input[i] != ' ' || input[i] != '-'){
	                builder.append(" ");
	                // if there are any "-"’s convert them to blanks.
	            } else if (input[i] == '-') {
	                builder.append(" ");
	            }
	         }
	         builder.append(input[i]);
	    }
	    String convertedValue = builder.toString();
	    return convertedValue;
	}

}

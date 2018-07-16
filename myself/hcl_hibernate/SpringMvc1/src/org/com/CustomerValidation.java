package org.com;

import org.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerValidation  implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Customer.class.isAssignableFrom(arg0);
	}
	

	@Override
	public void validate(Object arg0, Errors arg1) {
	
	ValidationUtils.rejectIfEmpty(arg1, "id", "id.required");	
	ValidationUtils.rejectIfEmpty(arg1, "name", "name.required");	
	ValidationUtils.rejectIfEmpty(arg1, "age", "age.required");	
	ValidationUtils.rejectIfEmpty(arg1, "city", "city.required");	
	ValidationUtils.rejectIfEmpty(arg1, "gender", "gender.required");	

	
    Customer cst=(Customer)	arg0;
	
    if(cst.getState().equals("None")){
    	arg1.rejectValue("state", "state.required");
    }    
    
    
    if(cst.getHobbies()==null)
      	arg1.rejectValue("hobbies", "hobbies.required");
      

	
	}

}

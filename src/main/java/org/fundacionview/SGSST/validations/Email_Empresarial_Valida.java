package org.fundacionview.SGSST.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Email_Empresarial_Valida implements ConstraintValidator<Email_Empresarial, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.endsWith("@gmail.com")) {
			return true;
		}else {
			return false;
		}
	}

}

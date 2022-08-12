package org.fundacionview.SGSST.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Email_Empresarial_Valida.class)
public @interface Email_Empresarial {

	public String value() default ""; 
	
	public String message() default "Solo son permitidos correos empresariales";
	
	public Class<?>[] groups() default{};
	
	public Class<? extends Payload>[] payload() default{};
}

package com.estilista.app.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.estilista.app.model.Direccion;

public class ValidarDireccion implements Validator  {

	@Override
	public boolean supports(Class<?> clazz) {
		return Direccion.class.equals(clazz); // clase del bean al que da soporte este validador

	}

	@Override
	public void validate(Object target, Errors errors) {
Direccion datosCoche = (Direccion) target;
		
		// la matrícula es obligatoria
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matricula", "field.matricula.required", 
				"La matrícula es obligatoria");
				
		validarFormatoMatricula(datosCoche.getCalleDireccion(), errors);
		
		if(datosCoche.getCalleDireccion() == null) {
			errors.rejectValue("anho", "field.anho.invalid", "El anho es incorrecto");
		}
	}
	
	private void validarFormatoMatricula (String matricula, Errors errors) {
		// valida la matrícula por expresión regular, si hay error lo añade a errors
	}

}

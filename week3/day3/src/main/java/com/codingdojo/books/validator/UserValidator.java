package com.codingdojo.books.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codingdojo.books.models.User;

@Component
public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User) target;
		
		if (!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}
	}

}

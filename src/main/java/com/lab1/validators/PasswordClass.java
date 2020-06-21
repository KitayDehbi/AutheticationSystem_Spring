package com.lab1.validators;

import com.lab1.Entities.User;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordClass implements ConstraintValidator<com.lab1.validators.Password,User> {    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getRepeatedPassword());
    }
}

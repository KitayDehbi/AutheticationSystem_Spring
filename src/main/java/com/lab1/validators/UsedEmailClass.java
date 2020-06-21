package com.lab1.validators;

import com.lab1.Entities.User;
import com.lab1.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsedEmailClass implements ConstraintValidator<UsedEmail, String> {
    @Autowired
    private UserService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    return service.getUserByEmail(value) ==null;
}
}

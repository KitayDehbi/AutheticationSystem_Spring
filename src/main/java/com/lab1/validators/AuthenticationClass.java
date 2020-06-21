package com.lab1.validators;

import com.lab1.Entities.AuthUser;
import com.lab1.Entities.User;
import com.lab1.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AuthenticationClass implements ConstraintValidator<Authentication, AuthUser> {
    @Autowired
    private UserService service;
    @Override
public boolean isValid(AuthUser value, ConstraintValidatorContext context) {
    return service.isExist(value.getEmail(),value.getPassword());
}
}

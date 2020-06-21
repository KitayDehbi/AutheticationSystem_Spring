package com.lab1.validators;

import com.lab1.Entities.PasswordReset;
import com.lab1.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RessetPasswordClass implements ConstraintValidator<Resetpassword, PasswordReset> {
   @Autowired
   private UserService userService ;

   public boolean isValid(PasswordReset obj, ConstraintValidatorContext context) {
   if (userService.verify(obj.getEmail(),obj.getCode())==null) return false;
   else if(!obj.getPassword().equals(obj.getRepeatedPassword())) return false;
   else return true;


   }
}

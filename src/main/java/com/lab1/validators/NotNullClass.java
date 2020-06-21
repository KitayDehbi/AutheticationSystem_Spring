package com.lab1.validators;

import com.lab1.Entities.PasswordReset;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullClass implements ConstraintValidator<NotEmty, PasswordReset> {
   public void initialize(NotEmty constraint) {
   }

   public boolean isValid(PasswordReset obj, ConstraintValidatorContext context) {
      if(obj.getPassword().isEmpty()|| obj.getEmail().isEmpty() || obj.getCode().isEmpty() || obj.getRepeatedPassword().isEmpty())
         return false;
      return true;
   }
}

package com.lab1.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(ElementType.TYPE )
@Constraint(validatedBy = RessetPasswordClass.class)
@Documented
public @interface Resetpassword {
    String message() default "Wrong cridentials or passwords are not match";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };}

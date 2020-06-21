package com.lab1.Entities;

import com.lab1.validators.ValidateEmail;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class Emailvalidation {
    @ValidateEmail
    @NotBlank
    private String email;
}

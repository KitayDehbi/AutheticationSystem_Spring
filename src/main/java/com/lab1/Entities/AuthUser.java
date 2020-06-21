package com.lab1.Entities;

import com.lab1.validators.Authentication;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Authentication
public class AuthUser {
    @NotEmpty(message = "email cannot be empty")
    private String email;
    @NotEmpty (message = "password cannot be empty")
    private String password;

}

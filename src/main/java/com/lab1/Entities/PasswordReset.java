package com.lab1.Entities;

import com.lab1.validators.NotEmty;
import com.lab1.validators.Password;
import com.lab1.validators.Resetpassword;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Resetpassword

public class PasswordReset {
    private String email;
    private String code;
    private String password;
    private String repeatedPassword;


}

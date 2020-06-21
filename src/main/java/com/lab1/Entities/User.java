package com.lab1.Entities;

import com.lab1.validators.Password;
import com.lab1.validators.UsedEmail;
import com.lab1.validators.Weakpassword;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Password
@ToString

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    @Column
    @Size(min =5, message = "please enter your full name")

    private String fullName;
    @Column
    @Email(message = "invalid email")
    @NotEmpty (message = "email cannot be empty")
    @UsedEmail
    private String email;
    @Column
    @Size(min = 8, message = "password must contains at least 8 characters")
    @Weakpassword
    private String password;
    @Transient
    private String repeatedPassword;
    @Column
    private String code;

}

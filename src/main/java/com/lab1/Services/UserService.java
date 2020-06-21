package com.lab1.Services;

import com.lab1.Entities.User;

public interface UserService {

    public void saveUser(User u );
    public boolean isExist(String email, String password);
    public void updateUserPassword(User u);
    public User getUserByEmail(String email);
    public String sendEmail(String email);
    public void setCode(String code,String email);
    public User verify (String email , String code);
    public void updatePassword(String email,String password);
}

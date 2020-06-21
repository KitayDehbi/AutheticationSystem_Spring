package com.lab1.Services;

import com.google.common.hash.Hashing;
import com.lab1.Entities.User;
import com.lab1.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Properties;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void saveUser(User u) {
        try {
            System.out.println(u.getPassword());
            u.setPassword(Hashing.sha256().hashString(u.getPassword(), StandardCharsets.UTF_8).toString());
            u.setRepeatedPassword(Hashing.sha256().hashString(u.getRepeatedPassword(), StandardCharsets.UTF_8).toString());
            System.out.println(u.getPassword());
            System.out.println(u.toString());
            userRepository.save(u);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    @Transactional
    public boolean isExist(String email, String password) {
        return userRepository.getUserByEmailAndPassword(email,Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString()) !=null;
    }

    @Override
    @Transactional
    public void updateUserPassword(User u) {
        userRepository.save(u);

    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public String sendEmail(String email) {
        final String username = "master4isi2019@gmail.com";
        final String password = "KitayDehbi";
        SecureRandom sr = new SecureRandom();

        final  String code = ""+sr.nextInt(999999);
        this.setCode(code,email);
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("master4isi2019@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse( email)
            );
            message.setSubject("Reset your password");
            message.setText("Hello there!, you forgot your password? nothing to worry about."
                    + "\n Please provide this code "+code+" to reset your password");

            Transport.send(message);

            return code;

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setCode(String code,String email) {
        userRepository.setCode(code,email);
    }

    @Override
    public User verify(String email, String code) {
        return userRepository.getUserByEmailAAndCode(email,code);
    }

    @Override
    public void updatePassword(String email, String password) {
        String pass = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        userRepository.updatePass(email,pass);
    }


}

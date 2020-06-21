package com.lab1.Contollers;

import com.lab1.Entities.AuthUser;
import com.lab1.Entities.Emailvalidation;
import com.lab1.Entities.PasswordReset;
import com.lab1.Entities.User;
import com.lab1.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;
    private String code = new String();

    @RequestMapping("")
    public String home(ModelMap model , AuthUser user){
        model.addAttribute("user",user);
        return "user/index";
    }
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") AuthUser user ,BindingResult result){
        if(result.hasErrors()){
            return "user/index";
        }
            return "user/welcome";
    }
    @RequestMapping("/signUp")
    public String signUp(ModelMap model , User user){
        model.addAttribute("user",user);
        return "user/addUser";
    }
    @PostMapping("/save")
    public String saveArticle(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if(result.hasErrors()){

            return "user/addUser";
        }
        userService.saveUser(user);
        return "redirect:/";
    }
    @RequestMapping("/sendCode")
    public String resetPassword(ModelMap model , Emailvalidation obj){
        model.addAttribute("obj",obj);
        return "user/email";
    }
    @PostMapping("/sendEmail")
    public String Validate(@Valid @ModelAttribute("obj") Emailvalidation obj, BindingResult result) {
        if(result.hasErrors()){
            return "user/email";
        }
        code =userService.sendEmail(obj.getEmail());
        return "redirect:/resetPassword";
    }

    @RequestMapping("/resetPassword")
    public String redirectResetPassword(ModelMap model , PasswordReset obj){
        model.addAttribute("rp",obj);
        return "user/reset";
    }
    @PostMapping("/validatePassword")
    public String reset(@Valid @ModelAttribute("rp") PasswordReset obj, BindingResult result) {
        if(result.hasErrors()){
            return "user/reset";
        }
        userService.updatePassword(obj.getEmail(),obj.getPassword());
        return "redirect:/";
    }
}

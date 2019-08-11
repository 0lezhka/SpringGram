package com.kopylchak.controllers;

import com.kopylchak.beans.UserProfile;
import com.kopylchak.dao.UserProfileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/userProfile")
public class UserProfileController {
    private UserProfileDAO dao;

    @Autowired
    public UserProfileController(UserProfileDAO dao){
        this.dao = dao;
    }


    @RequestMapping(value = "/logIn", method = RequestMethod.GET)
    public String showLogInForm(Model model){
        model.addAttribute("userProfile", new UserProfile());
        model.addAttribute("rememberMe");

        return "logIn";
    }

    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public String logIn(UserProfile userProfile, @RequestParam(value = "rememberMe", required = false) boolean rememberMe, Model model){
        if(dao.userExists(userProfile)){
            return "success";
        }
        model.addAttribute("isLoginDataInvalid", true);
        return "logIn";
    }


    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String showSignUpForm(Model model){
        model.addAttribute("userProfile", new UserProfile());

        return "signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(UserProfile userProfile, Model model){
        boolean canSignUp = true;

        if(dao.isEmailBusy(userProfile.getEmail())){
            model.addAttribute("isEmailBusy", true);
            canSignUp = false;
        }
        if(dao.isNicknameBusy(userProfile.getNickname())){
            model.addAttribute("isNicknameBusy", true);
            canSignUp = false;
        }
        if (dao.isPasswordBusy(userProfile.getPassword())){
            model.addAttribute("isPasswordBusy", true);
            canSignUp = false;
        }

        if(canSignUp){
            dao.addUser(userProfile);

            return "homePage";
        }else {
            return "signUp";
        }
    }
}

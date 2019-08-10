package com.kopylchak.controllers;

import com.kopylchak.beans.UserProfile;
import com.kopylchak.dao.UserProfileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/userProfile")
public class UserProfileController {
    private UserProfileDAO dao;

    @Autowired
    public UserProfileController(UserProfileDAO dao){
        this.dao = dao;
    }

    @RequestMapping(value = "/signOn", method = RequestMethod.GET)
    public String signOn(){
        return "helloWorld";
    }
}

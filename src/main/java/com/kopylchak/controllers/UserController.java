package com.kopylchak.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/controller")
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public String test(){
        return "helloWorld";
    }
}

package com.example.playGame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class userController {
    @GetMapping("/userPage")
    public String userPage(){
        return "userPage";
    }
}

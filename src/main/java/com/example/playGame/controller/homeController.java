package com.example.playGame.controller;

import com.example.playGame.models.News;
import com.example.playGame.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class homeController {
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        List<News> newsList = newsRepository.findAll();
        model.addAttribute("newsList",newsList);
        return "home";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
}


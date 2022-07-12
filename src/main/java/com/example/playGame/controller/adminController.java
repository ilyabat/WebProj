package com.example.playGame.controller;

import com.example.playGame.models.News;
import com.example.playGame.models.Product;
import com.example.playGame.models.User;
import com.example.playGame.repository.NewsRepository;
import com.example.playGame.repository.ProductRepository;
import com.example.playGame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class adminController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/adminPage")
    public String adminPage(Model model){
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList",userList);
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList",productList);
        List<News> newsList = newsRepository.findAll();
        model.addAttribute("newsList", newsList);
        return "adminPage";
    }

}

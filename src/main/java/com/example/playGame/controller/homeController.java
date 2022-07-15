package com.example.playGame.controller;

import com.example.playGame.models.News;
import com.example.playGame.models.Product;
import com.example.playGame.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
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
    @GetMapping("/addNews")
    public String addNews(Model model){
        return "addNews";
    }
    @PostMapping("/addNews")
    public String addNews(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, @RequestParam String image, Model model){
        News news = new News(title,anons,full_text,image);
        newsRepository.save(news);
        return "redirect:/adminPage";
    }
    @GetMapping("news/delete/{id}")
    public String deleteNews(@PathVariable("id") long id) {
        News news = newsRepository.findById(id);
        newsRepository.delete(news);
        return "redirect:/adminPage";
    }
    @GetMapping("news/edit/{id}")
    public String editNews(@PathVariable("id") long id, Model model) {
        News news = newsRepository.findById(id);
        model.addAttribute("editNews", news);
        return "editNews";
    }
    @PostMapping("news/edit/{id}")
    public String editNews(@PathVariable("id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, @RequestParam String image, Model model){
        News news = newsRepository.findById(id);

        news.setTitle(title);
        news.setImage(image);
        news.setAnons(anons);
        news.setFull_text(full_text);

        newsRepository.save(news);
        return "redirect:/adminPage";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
}


package com.example.playGame.controller;

import com.example.playGame.models.Product;
import com.example.playGame.repository.ProductRepository;
import com.example.playGame.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class cartController {
    @Autowired
    private ProductRepository productRepository;
    private final ShoppingCartService shoppingCartService;

    public cartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }


    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("products", shoppingCartService.productsInCart());
        model.addAttribute("totalPrice", shoppingCartService.totalPrice());
        return "cart";
    }
    @GetMapping("/cart/add/{id}")
    public String addProductToCart(@PathVariable("id") long id, Model model){
        Product product = productRepository.findById(id);
        if (product != null){
            shoppingCartService.addProduct(product);
            model.addAttribute("products", shoppingCartService.productsInCart());
            model.addAttribute("totalPrice", shoppingCartService.totalPrice());

        }
        return "cart";
    }
    @GetMapping("/cart/remove/{id}")
    public String removeProductFromCart(@PathVariable("id") long id, Model model) {
        Product product = productRepository.findById(id);
        if (product != null) {
            shoppingCartService.removeProduct(product);
        }
        return "cart";
    }


    @GetMapping("/cart/clear")
    public String clearProductsInCart(){
        shoppingCartService.clearProducts();

        return "cart";
    }
}

package com.example.playGame.repository;

import com.example.playGame.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(long id);
}

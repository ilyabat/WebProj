package com.example.playGame.repository;

import com.example.playGame.models.News;
import com.example.playGame.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
    News findById(long id);
}

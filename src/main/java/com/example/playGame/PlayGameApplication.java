package com.example.playGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.playGame.*")
public class PlayGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayGameApplication.class, args);
	}

}

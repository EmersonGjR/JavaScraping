package com.api.scrap.scrapingArticles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.api.scrap.scrapingArticles.service")
public class ScrapingArticlesApplication {
	public static void main(String[] args) {
		SpringApplication.run(ScrapingArticlesApplication.class, args);
	}
}

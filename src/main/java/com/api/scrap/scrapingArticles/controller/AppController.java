package com.api.scrap.scrapingArticles.controller;

import com.api.scrap.scrapingArticles.dto.ResponseDto;
import com.api.scrap.scrapingArticles.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class AppController {
    @Autowired
    AppService appService;

    @GetMapping("/first")
    public Set<ResponseDto> getNews(){
        return appService.getNew();
    }
}

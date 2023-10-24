package com.api.scrap.scrapingArticles.service;

import com.api.scrap.scrapingArticles.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface AppService {
    Set<ResponseDto> getNew();
}

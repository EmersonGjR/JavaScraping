package com.api.scrap.scrapingArticles.service.implement;

import com.api.scrap.scrapingArticles.dto.ResponseDto;
import com.api.scrap.scrapingArticles.service.AppService;
import lombok.NoArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class ServiceImp implements AppService {
    @Value("${website.urls}")
    String url;

    @Override
    public Set<ResponseDto> getNew(){
        Set<ResponseDto> responseDtos = new HashSet<>();
//        extractUrl(responseDtos, url);
        ExtractHackNews extract = new ExtractHackNews(url);
        extract.setResponseDtoSet();
        return extract.getResponseDtoSet();
//        return responseDtos;
    }
//    public String extractFinal(String url){
//        try {
//            Document document = Jsoup.connect(url).get();
//            Elements elements = document.getElementsByClass("story-title");
//            for (Element ads: elements) {
//                return ads.getElementsByTag("a").text();
//            }
//        }catch(IOException ex){
//            ex.printStackTrace();
//        }
//        return "error";
//    }
//    private void extractUrl(Set<ResponseDto> responseDtos, String url){
//        int i = 0;
//        try{
//            Document document = Jsoup.connect(url).get();
//            Elements elements = document.getElementsByClass("body-post clear");
//            for (Element ads: elements) {
//                ResponseDto responseDto = new ResponseDto();
//                Elements a = ads.getElementsByTag("a");
//                String href = a.attr("href");
//                if ( i < 3 && href.contains("thehackernews")) {
//                    responseDto.setIndex(i);
//                    responseDto.setUrl(extractFinal(href));
//                    responseDtos.add(responseDto);
//                    i++;
//                }
//            }
//        }catch(IOException ex){
//            ex.printStackTrace();
//        }
//    }

//    private void extractUrl(Set<ResponseDto> responseDtos, String url){
//        int i = 0;
//        try{
//            Document document = Jsoup.connect(url).get();
//            Elements elements = document.getElementsByClass("body-post clear");
//            for (Element ads: elements) {
//                ResponseDto responseDto = new ResponseDto();
//                ExtractHackNews extract = new ExtractHackNews();
//                extract.setUrl(ads);
//            }
//        }catch(IOException ex){
//            ex.printStackTrace();
//        }
//    }

}

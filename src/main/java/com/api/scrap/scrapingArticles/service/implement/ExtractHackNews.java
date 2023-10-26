package com.api.scrap.scrapingArticles.service.implement;

import com.api.scrap.scrapingArticles.dto.ResponseDto;
import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ExtractHackNews {
    String firstUrl;
    String url;
    @Getter
    String title;
    @Getter
    String text;
    @Getter
    Set<ResponseDto> responseDtoSet;

    public ExtractHackNews(String firstUrl){
        this.firstUrl = firstUrl;
        this.responseDtoSet = new HashSet<>();
    }

    public void setResponseDtoSet(){
        int i = 0;
        try{
            Document document = Jsoup.connect(this.firstUrl).get();
            Elements elements = document.getElementsByClass("body-post clear");
            for (Element ads: elements) {
                ResponseDto responseDto = new ResponseDto();
                Elements a = ads.getElementsByTag("a");
                this.url = a.attr("href");
                if ( i < 3 && this.url.contains("thehackernews")) {
                    setTitle();
                    setText();
                    responseDto.setIndex(i);
                    responseDto.setUrl(this.url);
                    responseDto.setTitle(getTitle());
                    responseDto.setText(getText());
                    responseDtoSet.add(responseDto);
                    i++;
                }
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void setText(){
        this.text = "";
        try {
            Document document = Jsoup.connect(this.url).get();
            Element element = document.getElementById("articlebody");
            Elements elements = element.getElementsByTag("p");
            for(Element ads: elements){
                this.text += ads.text();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void setTitle(){
        try {
            Document document = Jsoup.connect(this.url).get();
            Elements elements = document.getElementsByClass("story-title");
            for (Element ads: elements) {
                this.title =  ads.getElementsByTag("a").text();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}

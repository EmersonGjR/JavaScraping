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

        extract(responseDtos, url);

        responseDtos.stream().sorted();
        return responseDtos;
    }
    private void extract(Set<ResponseDto> responseDtos, String url){
        int i = 0;
        try{
            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByClass("story-link");
            for (Element ads: elements) {
                ResponseDto responseDto = new ResponseDto();
                String href = ads.attr("href");
                if (!StringUtils.isEmpty(ads.attr("href")) && i < 3 && href.contains("thehackernews")) {
                    //mapping data to the model class
                    responseDto.setIndex(i);
                    responseDto.setUrl(ads.attr("href"));
                    responseDtos.add(responseDto);
                    i++;
                }
//                if (responseDto.getUrl() != null) responseDtos.add(responseDto);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

}

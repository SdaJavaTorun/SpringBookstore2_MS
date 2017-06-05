package com.example.bookstore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

import javax.xml.ws.Response;

/**
 * Created by RENT on 2017-06-05.
 */
@Component
@Qualifier("bookDescriptionLipsum")
public class BookDescriptionLipsum implements BookDescriptionClient{

    private final String lipsumUrl;
    private final RestOperations restOperations;

    @Autowired
    public BookDescriptionLipsum(@Value("${lipsum.url}")String lipsumUrl,
                                  RestOperations restOperations) {
        this.lipsumUrl = lipsumUrl;
        this.restOperations = restOperations;
    }

    @Override
    public String getDescription(String bookId) {
        ResponseEntity<LipsumDto> result = restOperations.getForEntity(lipsumUrl+"/feed/json",LipsumDto.class);
        return result.getBody().getFeed().getLipsum();
    }
}

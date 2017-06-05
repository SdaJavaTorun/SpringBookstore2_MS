package com.example.bookstore.service;

import com.example.bookstore.model.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

/**
 * Created by RENT on 2017-06-03.
 */
@Component
@Qualifier("bookDescriptionLoripsum")
public class BookDescriptionLoripsum implements BookDescriptionClient{

    final private RestOperations restOperations;
    private final String loripsumUrl;

    @Autowired
    public BookDescriptionLoripsum(RestOperations restOperations, @Value("${loripsum.url}") String loripsumUrl){
        this.restOperations = restOperations;
        this.loripsumUrl = loripsumUrl;
    }
    @Override
    public String getDescription(String bookId) {
        restOperations.postForEntity("http://localhost:8090/api/books", new BookDto("title1","autor1"),BookDto.class);//wrzucenie książki z poziomu aplikacji
        return restOperations.getForEntity(loripsumUrl + "/api/plaintext",String.class).getBody();
    }
}

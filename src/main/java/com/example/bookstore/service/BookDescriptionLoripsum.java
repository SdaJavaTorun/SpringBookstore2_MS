package com.example.bookstore.service;

import com.example.bookstore.model.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

/**
 * Created by RENT on 2017-06-03.
 */
@Component
@Qualifier("bookDescriptionLoripsum")
public class BookDescriptionLoripsum implements BookDescriptionClient{

    final private RestOperations restOperations;

    @Autowired
    public BookDescriptionLoripsum(RestOperations restOperations){
        this.restOperations = restOperations;
    }
    @Override
    public String getDescription(String bookId) {
        restOperations.postForEntity("http://localhost:8090/api/books", new BookDto("title1","autor1"),BookDto.class);//wrzucenie książki z poziomu aplikacji
        return restOperations.getForEntity("http://loripsum.net/api/plaintext",String.class).getBody();
    }
}

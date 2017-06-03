package com.example.bookstore.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by RENT on 2017-06-03.
 */
@Component
@Qualifier("bookDescriptionDummy")
public class BookDescriptionDummy implements BookDescriptionClient{

    @Override
    public String getDescription(String bookId) {
        return "book description";
    }
}

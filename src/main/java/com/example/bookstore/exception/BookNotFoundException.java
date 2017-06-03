package com.example.bookstore.exception;

/**
 * Created by RENT on 2017-06-03.
 */
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String s){
        super(s);
    }

}

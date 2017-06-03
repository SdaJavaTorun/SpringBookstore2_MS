package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDto {
    @JsonProperty("title")
    private String name;
    private String author;

    public BookDto() {
    }

    public BookDto(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book fromDto() {
        return new Book(name, author);
    }


}

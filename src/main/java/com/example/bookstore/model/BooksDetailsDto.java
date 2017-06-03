package com.example.bookstore.model;

public class BooksDetailsDto {

    private final String title;
    private final String author;
    private final String description;


    public BooksDetailsDto(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BooksDetailsDto{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static BooksDetailsDto toDto(BookDetails bookDetailsById) {
            return new BooksDetailsDto(
                    bookDetailsById.getTitle(),
                    bookDetailsById.getAuthor(),
                    bookDetailsById.getDescription());
        }
    }


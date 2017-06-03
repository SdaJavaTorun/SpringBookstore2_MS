package com.example.bookstore.service;

import com.example.bookstore.exception.BookNotFoundException;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookDetails;
import com.example.bookstore.model.BookListing;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookDescriptionClient descriptionClient;

    @Autowired
    public BookService(BookRepository bookRepository,
                       @Qualifier("bookDescriptionLoripsum") BookDescriptionClient descriptionClient) {
        this.bookRepository = bookRepository;
        this.descriptionClient=descriptionClient;
    }

    public BookListing getListingData() {
        List<Book> books = bookRepository.findAll();

        return new BookListing(
                books,
                books.size()
        );
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        //if (book.isPresent()){bookRepository.delete(book.get());}
        book.ifPresent(bookRepository::delete);
    }

    public BookDetails getBookDetailsById(String id){
        Optional<Book> existingbook = bookRepository.findById(id);
//       bookRepository.findById(id);
//        if(book.isPresent()){
//            return new BookDetails(
//                      book.get().getTitle(),
//                      book.get().getAuthor(),
//                      descriptionClient.getDescription(book.get().getId()));
//        }
        return existingbook.map(book -> new BookDetails(
                book.getTitle(),
                book.getAuthor(),
                descriptionClient.getDescription(book.getId())
        )).orElseThrow(() -> new BookNotFoundException("Książka o numerze " + id + " nie została odnaleziona."));
    }
}

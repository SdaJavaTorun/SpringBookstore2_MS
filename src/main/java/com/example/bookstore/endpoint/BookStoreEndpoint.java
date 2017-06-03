package com.example.bookstore.endpoint;

import com.example.bookstore.model.BookDto;
import com.example.bookstore.model.BookListingDto;
import com.example.bookstore.model.BooksDetailsDto;
import com.example.bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping("/api/books")
public class BookStoreEndpoint {

    private final BookService bookService;

    public BookStoreEndpoint(BookService bookService){
        this.bookService = bookService;
    }


    @GetMapping(value = "/hello", produces = MediaType.TEXT_HTML_VALUE)
    public String hello(){
        return "<h1>Hello</h1><h2>World</h2>"; //TEXT_HTML_VALUE interpretuje kod html
    }

    @GetMapping("/book")
    public BookDto getBook(){
        return new BookDto("title","author");
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BookListingDto getBooks(){
        return BookListingDto.toDto(bookService.getListingData());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBooks(@RequestBody BookDto bookDto){
        bookService.addBook(bookDto.fromDto());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id,
                          RedirectAttributes redirectAttributes) {
        bookService.deleteBookById(id);
        redirectAttributes.addFlashAttribute("result", "Książka o id " + id + " została usunięta.");
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public BooksDetailsDto getBookDetails(@PathVariable String id){
            return  BooksDetailsDto.toDto(bookService.getBookDetailsById(id));
    }
}

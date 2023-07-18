package com.edstem.book.controller;

import com.edstem.book.contract.BookResponse;
import com.edstem.book.model.Book;
import com.edstem.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/findAllBooks")
    public ResponseEntity<List<BookResponse>> findAllBooks() {
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable int id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping("/addBook")
    public ResponseEntity<BookResponse> addBook(@RequestBody Book book) {
        BookResponse bookResponse = bookService.addBook(book);
        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
    }

    @PostMapping("/updateBookById/{id}")
    public ResponseEntity<BookResponse> updateBookById(@PathVariable int id, @RequestBody Book book) {
        BookResponse updatedBook = bookService.updateBookById(id, book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Book with ID " + id + " has been deleted");
    }

}
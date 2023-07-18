package com.edstem.book.service;

import com.edstem.book.contract.BookResponse;
import com.edstem.book.exception.BookNotFoundException;
import com.edstem.book.model.Book;
import com.edstem.book.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponse> findAllBooks() {
        List<Book> books = this.bookRepository.findAll();
        List<BookResponse> responses = new ArrayList<>();
        for (Book book : books) {
            responses.add(
                    BookResponse
                            .builder()
                            .id(book.getId())
                            .title(book.getTitle())
                            .author(book.getAuthor())
                            .isbn(book.getIsbn())
                            .publicationDate(book.getPublicationDate())
                            .build()
            );
        }
        return responses;
    }

    public BookResponse getBookById(int id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> {
            log.error("Book with id: {} not found", id);
            return new BookNotFoundException(id);
        });
        return BookResponse
                .builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .publicationDate(book.getPublicationDate())
                .build();
    }

    public BookResponse addBook(Book book) {
        book.setId(book.getId());
        book.setTitle(book.getTitle());
        book.setAuthor(book.getAuthor());
        book.setIsbn(book.getIsbn());
        book.setPublicationDate(book.getPublicationDate());

        Book savedBook = bookRepository.save(book);

        return BookResponse
                .builder()
                .id(savedBook.getId())
                .title(savedBook.getTitle())
                .author(savedBook.getAuthor())
                .isbn(savedBook.getIsbn())
                .publicationDate(savedBook.getPublicationDate())
                .build();
    }

    public BookResponse updateBookById(int id, Book book) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> {
            log.error("Movie with id: {} not found", id);
            return new BookNotFoundException(id);

        });
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setPublicationDate(book.getPublicationDate());

        Book updatedBook = bookRepository.save(existingBook);

        return BookResponse
                .builder()
                .id(updatedBook.getId())
                .title(updatedBook.getTitle())
                .author(updatedBook.getAuthor())
                .isbn(updatedBook.getIsbn())
                .publicationDate(updatedBook.getPublicationDate())
                .build();
    }

    public void deleteBookById(int id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }
}

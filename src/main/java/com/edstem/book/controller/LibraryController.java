package com.edstem.book.controller;


import com.edstem.book.contract.LibraryDto;
import com.edstem.book.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library-books")
public class LibraryController {
    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public ResponseEntity<List<LibraryDto>>libraryBooksList() {
        return new ResponseEntity<>(libraryService.libraryBooksList(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LibraryDto> getLibraryBooksById(@PathVariable int id) {
        return new ResponseEntity<>(libraryService.getLibraryBooksById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<LibraryDto> addLibraryBooks(@RequestBody LibraryDto libraryDto) {
        return new ResponseEntity<>(libraryService.addLibraryBooks(libraryDto), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LibraryDto>updateLibraryBooksById(@PathVariable int id, @Valid @RequestBody LibraryDto library){
        LibraryDto updateLibraryBooks=libraryService.updateLibraryBooksById(id, library);
        return new ResponseEntity<>(updateLibraryBooks, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteLibraryBooksById(@PathVariable int id){
        libraryService.deleteLibraryBooksById(id);
        return ResponseEntity.ok("Book with ID " + id + " has been deleted.");

    }

}

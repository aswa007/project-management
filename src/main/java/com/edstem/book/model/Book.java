package com.edstem.book.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_details")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String title;
    private String author;
    private long isbn;
    private LocalDate publicationDate;
}
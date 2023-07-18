package com.edstem.book.contract;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookResponse {
    private Integer id;
    private String title;
    private String author;
    private long isbn;
    private LocalDate publicationDate;
}

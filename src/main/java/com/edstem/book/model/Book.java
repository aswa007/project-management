package com.edstem.book.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_details")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 3, message = "Title must be minimum 3 characters")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    @Length(min = 3, message = "Author must be minimum 3 characters")
    private String author;

    @Min(value = 1, message = "ISBN must be a positive value")
    private long isbn;

    @PastOrPresent(message = "Publication date must be in past or present")
    private LocalDate publicationDate;


}
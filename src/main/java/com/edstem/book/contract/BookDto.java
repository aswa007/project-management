package com.edstem.book.contract;

import com.edstem.book.validation.books.ValidAuthor;
import com.edstem.book.validation.books.ValidIsbn;
import com.edstem.book.validation.books.ValidTitle;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Integer id;

    @ValidTitle private String title;

    @ValidAuthor private String author;

    @ValidIsbn private long isbn;

    @PastOrPresent(message = "Publication date must be in past or present")
    private LocalDate publicationDate;
}

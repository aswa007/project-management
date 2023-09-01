package com.edstem.book.contract;

import com.edstem.book.validation.library.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryDto {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)

    private Integer id;
   @ValidBookId
   private String bookId;
   @ValidUserId
    private String userId;
   @ValidRentedDate
    private LocalDate rentedDate;
   @ValidReturnDate
    private LocalDate returnDate;
@ValidStatus
    private LibraryStatus status;
    public enum LibraryStatus{
        Available,
        Taken

    }

}

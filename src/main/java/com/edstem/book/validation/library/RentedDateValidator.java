package com.edstem.book.validation.library;

import com.edstem.book.validation.books.ValidAuthor;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.cglib.core.Local;
import org.springframework.util.StringUtils;

import java.time.LocalDate;

public class RentedDateValidator implements ConstraintValidator<ValidRentedDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate rentedDate, ConstraintValidatorContext constraintValidatorContext) {
if (rentedDate == null){
    return false;
}
LocalDate currentDate = LocalDate.now();
return !rentedDate.isAfter(currentDate);
    }

}

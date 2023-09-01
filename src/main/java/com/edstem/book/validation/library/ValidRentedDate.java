package com.edstem.book.validation.library;

import com.edstem.book.validation.books.AuthorValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RentedDateValidator.class)
@Documented

public @interface ValidRentedDate {
    String message() default "Rented date should be in past or present";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

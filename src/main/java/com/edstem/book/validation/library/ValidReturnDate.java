package com.edstem.book.validation.library;

import com.edstem.book.validation.books.AuthorValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ReturnDateValidator.class)
@Documented

public @interface ValidReturnDate {
    String message() default "Return date should be in the present or future";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

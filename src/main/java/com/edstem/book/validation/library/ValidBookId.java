package com.edstem.book.validation.library;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BookIdValidator.class)
@Documented

public @interface ValidBookId {
    String message() default "Rented book id should be provided";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

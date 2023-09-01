package com.edstem.book.validation.library;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StatusValidator.class)
@Documented

public @interface ValidStatus {
    String message() default "Invalid status. Must be either 'Available' or 'Taken'.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

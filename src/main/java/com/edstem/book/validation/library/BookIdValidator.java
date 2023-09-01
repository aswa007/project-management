package com.edstem.book.validation.library;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class BookIdValidator implements ConstraintValidator<ValidBookId, String> {

    @Override
    public boolean isValid(String bookId, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(bookId) && !bookId.trim().isEmpty() && bookId.length() >= 2;
    }

}

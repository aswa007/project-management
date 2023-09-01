package com.edstem.book.validation.library;

import com.edstem.book.validation.books.ValidAuthor;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class UserIdValidator implements ConstraintValidator<ValidUserId, String> {

    @Override
    public boolean isValid(String userId, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(userId) && !userId.trim().isEmpty() && userId.length() >= 2;

    }
}

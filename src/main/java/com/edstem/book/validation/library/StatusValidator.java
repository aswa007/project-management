package com.edstem.book.validation.library;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class StatusValidator implements ConstraintValidator<ValidStatus, String> {

    private static final String[] ALLOWED_STATUSES={"Available","Taken"};


    @Override
    public boolean isValid(String status, ConstraintValidatorContext constraintValidatorContext) {
        if (status== null || status.trim().isEmpty()){
            return false;
        }

    return Arrays.asList(ALLOWED_STATUSES).contains(status);

}
}

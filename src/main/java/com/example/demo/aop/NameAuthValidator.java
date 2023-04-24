package com.example.demo.aop;

import com.example.demo.aop.annotation.NameAuth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameAuthValidator implements ConstraintValidator<NameAuth,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.equals("arshad"))
            return true;
        return false;
    }
}

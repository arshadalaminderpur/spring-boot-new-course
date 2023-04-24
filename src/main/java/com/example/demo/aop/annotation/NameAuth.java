package com.example.demo.aop.annotation;

import com.example.demo.aop.NameAuthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention( RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameAuthValidator.class)
@Documented
public @interface NameAuth {

    public String message() default "please enter name arshad";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

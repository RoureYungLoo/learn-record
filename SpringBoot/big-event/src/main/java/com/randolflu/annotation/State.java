package com.randolflu.annotation;

import com.randolflu.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(
        validatedBy = {
                StateValidation.class // 想要被哪个类校验
        }
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface State {
    /* 校验不通过的提示信息 */
    String message() default "State不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

package com.randolflu.validation;

import com.randolflu.annotation.State;
import com.randolflu.constants.EditState;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/* 继承 ConstraintValidator 接口 */
public class StateValidation implements ConstraintValidator<State, String> { // <要校验的注解，要校验的类型>


    /* value */
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value.equals(EditState.PUBLISHED) || value.equals(EditState.DRAFT)) {
            return true; // 校验通过
        }

        // 校验未通过
        return false;
    }
}

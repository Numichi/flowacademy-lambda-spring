package hu.flowacademy.lambda.elmelet.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<CustomString, String> {

    private boolean nullable;
    private String[] acceptable;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return nullable;
        }

        for (var content : acceptable) {
            return value.equals(content);
        }

        return false;
    }

    /**
     * Ez a rész nem kötelező.
     */
    @Override
    public void initialize(CustomString constraintAnnotation) {
        nullable = constraintAnnotation.nullable();
        acceptable = constraintAnnotation.acceptable();
    }
}
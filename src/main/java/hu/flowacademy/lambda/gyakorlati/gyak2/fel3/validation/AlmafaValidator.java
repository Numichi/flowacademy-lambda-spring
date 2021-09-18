package hu.flowacademy.lambda.gyakorlati.gyak2.fel3.validation;

import hu.flowacademy.lambda.gyakorlati.gyak2.fel3.GenomEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlmafaValidator implements ConstraintValidator<Almafa, String> {

    private boolean value;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null && this.value) {
            return true;
        }

        GenomEnum[] arr = GenomEnum.values();
        return arr[0].name().equals(value) || arr[1].name().equals(value);
    }

    @Override
    public void initialize(Almafa constraintAnnotation) {
        value = constraintAnnotation.nullable();
    }
}
package com.api.fastfood.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class EnumNamePatternValidator implements ConstraintValidator<EnumNamePatternConstraint, Enum<?>> {
    private Pattern pattern;

    @Override
    public void initialize(EnumNamePatternConstraint constraint) {
        try {
            pattern = Pattern.compile(constraint.regexp());
        }

        catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Given regex is invalid", e);
        }
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) return true;

        var matcher = pattern.matcher(value.name());
        return matcher.matches();
    }
}

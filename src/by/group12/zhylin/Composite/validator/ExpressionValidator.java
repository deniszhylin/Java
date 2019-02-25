package by.group12.zhylin.Composite.validator;

import by.group12.zhylin.Composite.composite.ComponentType;

import java.util.regex.Pattern;

public class ExpressionValidator {
    public boolean isBitExpression(String stringExpression){
        return Pattern.compile(ComponentType.EXPRESSION.getDescription()).matcher(stringExpression).matches();
    }
}
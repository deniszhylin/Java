package test.by.group12.zhylin.task2.validator;

import by.group12.zhylin.task2.validator.ExpressionValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpressionValidatorTest {

    @Test(description = "Validationt test")
    public void ExpressionValidator() {
        ExpressionValidator expressionValidator = new ExpressionValidator();
        boolean actualRezult = expressionValidator.isBitExpression("6&9|(3&4)");
        Assert.assertTrue(actualRezult,"Wrong expression");
    }
}

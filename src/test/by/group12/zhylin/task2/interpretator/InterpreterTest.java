package test.by.group12.zhylin.task2.interpretator;

import by.group12.zhylin.task2.exception.CustomException;
import by.group12.zhylin.task2.interpretator.Interpreter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InterpreterTest {
    Interpreter interpreter;
    String testString;

    @BeforeClass
    public void setUp() {
        interpreter = new Interpreter();
        testString = "(8^5|1&2<<(2|5>>2&71))|1200";
    }

    @AfterClass
    public void tierDown() {
        interpreter = null;
        testString = null;
    }

    @Test(description = "Test Script bool expression")
    public void InterpreterTest() throws CustomException {
        int expectedRezult = 1213;
        int actualRezult = interpreter.bitExpressionCalc(testString);
        Assert.assertEquals(expectedRezult, actualRezult, "Not correct parameter");
    }
}

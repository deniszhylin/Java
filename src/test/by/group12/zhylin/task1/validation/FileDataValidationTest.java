package test.by.group12.zhylin.task1.validation;

import by.group12.zhylin.task1.validation.FileDataValidation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDataValidationTest {

    @Test(description = "FileDataValidationTrue")
    public void FileDataValidationTest() {
        String source = "1.13,23.2,3.33,444.3,5.5,6.677";
        FileDataValidation fileDataValidation = new FileDataValidation();
        boolean rezult = fileDataValidation.dataValidation(source);
        Assert.assertTrue(rezult, "String incorrect!!!");
    }

    @Test(description = "FileDataValidationFalse")
    public void FileDataValidationTest1() {
        String source = "1111.1,2.2,3.3,4.4,5.5,6.677";
        FileDataValidation fileDataValidation = new FileDataValidation();
        boolean rezult = fileDataValidation.dataValidation(source);
        Assert.assertFalse(rezult, "String incorrect!!!");
    }
}
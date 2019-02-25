package test.by.group12.zhylin.Composite.read;

import by.group12.zhylin.Composite.exception.CustomException;
import by.group12.zhylin.Composite.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextReaderTest {
    private static final String FILE_PATH = "data/data2test.txt";
    TextReader textReader;

    @BeforeClass
    public void setUp() {
        textReader = new TextReader();
    }

    @AfterClass
    public void tierDown() {
        textReader = null;
    }

    @Test(description = "TestFileRead")
    public void textReadTestPositive() throws CustomException {
        String actualString = "Test string OK!";
        String expetedString = textReader.readText(FILE_PATH);
        Assert.assertEquals(actualString,expetedString);
    }

    @Test(expectedExceptions = CustomException.class)
    public void textReadTest()throws CustomException{
        textReader.readText("");
    }
}

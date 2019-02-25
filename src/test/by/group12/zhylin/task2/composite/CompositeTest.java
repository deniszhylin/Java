package test.by.group12.zhylin.task2.composite;

import by.group12.zhylin.task2.composite.Component;
import by.group12.zhylin.task2.composite.ComponentType;
import by.group12.zhylin.task2.composite.Composite;
import by.group12.zhylin.task2.exception.CustomException;
import by.group12.zhylin.task2.parser.TextParse;
import by.group12.zhylin.task2.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class CompositeTest {
    private static final String FILE_PATH = "data/data2test.txt";
    private TextReader textReader;
    private TextParse textParse;
    private Component component;
    private String text;

    @BeforeClass
    public void setUp() {
        textReader = new TextReader();
        textParse = new TextParse();
        component = new Composite(ComponentType.TEXT);
    }

    @AfterClass
    public void tierDown() {
        textReader = null;
        textParse = null;
        component = null;
    }

    @Test(description = "Composite test")
    public void compositeTextTest() {
        String actualString = null;
        String expetedString = "\n    Test string OK!";
        try {
            text = textReader.readText(FILE_PATH);
            textParse.parse(component, text);
            component = textParse.getTextComposite();
            actualString = component.toString();
        } catch (CustomException e) {
            fail();
        }
        Assert.assertEquals(actualString,expetedString);
    }
}
package test.by.group12.zhylin.Tetrahedron.parser;

import by.group12.zhylin.Tetrahedron.parser.ParseData;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.ArrayList;

public class ParseDataTest {

    ParseData parseData;
    ArrayList<String> arrayStringData;

    @BeforeClass
    public void setUp() {
        parseData = new ParseData();
        arrayStringData = new ArrayList<>();
        arrayStringData.add("2.1,4.5,6.5,2.4,1.5,4.4");
    }

    @AfterClass
    public void tierDown() {
        parseData = null;
        arrayStringData = null;
    }

    @Test(description = "Parse data 1 string")
    public void parseDataTest1() {
        String expected = "[2.1, 4.5, 6.5, 2.4, 1.5, 4.4]";
        String actual = parseData.parseDataList(arrayStringData).toString();
        Assert.assertEquals(expected, actual, "Method doesn`t work");
    }

    @Test(description = "Parse data 3 string")
    public void parseDataTest2() {
        arrayStringData.add("2.1,1.5,5.0,2.0,4.5,2.4");
        arrayStringData.add("2.2,4.5,4.5,2.2,4.5,2.4");
        String expected = "[2.1, 4.5, 6.5, 2.4, 1.5, 4.4, 2.1, 1.5, 5.0, 2.0, 4.5, 2.4, 2.2, 4.5, 4.5, 2.2, 4.5, 2.4]";
        String actual = parseData.parseDataList(arrayStringData).toString();
        Assert.assertEquals(expected, actual, "Method doesn`t work");
    }
}
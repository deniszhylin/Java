package by.group12.zhylin.task2.program;

import by.group12.zhylin.task2.comparator.WordCompare;

import by.group12.zhylin.task2.composite.Component;
import by.group12.zhylin.task2.composite.ComponentType;
import by.group12.zhylin.task2.composite.Composite;
import by.group12.zhylin.task2.exception.CustomException;
import by.group12.zhylin.task2.parser.TextParse;
import by.group12.zhylin.task2.reader.TextReader;

import java.util.Collections;

public class Main {
    public static void main(String[] args) throws CustomException {

        TextReader textReader = new TextReader();
        String text = textReader.readText(".\\data\\data2.txt");
        System.out.println(text);
        Composite composite = new Composite(ComponentType.TEXT);
        TextParse textParse = new TextParse();
        textParse.parse(composite, text);
        composite = (Composite) textParse.getTextComposite();
       /* String rez = composite.toString();
        System.out.println(rez);
*/
      //  WordCompare wordCompare = new WordCompare();
        Collections.sort(composite.getComponent(), new WordCompare());
        System.out.println(composite.toString());


    }
}
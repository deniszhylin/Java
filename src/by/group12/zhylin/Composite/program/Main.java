package by.group12.zhylin.Composite.program;

import by.group12.zhylin.Composite.comparator.WordCompare;

import by.group12.zhylin.Composite.composite.Component;
import by.group12.zhylin.Composite.composite.ComponentType;
import by.group12.zhylin.Composite.composite.Composite;
import by.group12.zhylin.Composite.exception.CustomException;
import by.group12.zhylin.Composite.parser.TextParse;
import by.group12.zhylin.Composite.reader.TextReader;

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
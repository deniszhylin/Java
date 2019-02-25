package by.group12.zhylin.task2.parser;

import by.group12.zhylin.task2.composite.Component;
import by.group12.zhylin.task2.composite.ComponentType;
import by.group12.zhylin.task2.composite.Simbol;

public class SimbolParse implements ParserTemplate {

    @Override
    public void parse(Component lexemComposite, String lexem) {
        for (int i = 0; i < lexem.length(); i++) {
            String chars = String.valueOf(lexem.charAt(i));
            Component componentChars = new Simbol(chars.charAt(0), ComponentType.SYMBOL);
            lexemComposite.addComponent(componentChars);
        }
    }
}
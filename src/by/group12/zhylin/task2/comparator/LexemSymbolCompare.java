package by.group12.zhylin.task2.comparator;

import by.group12.zhylin.task2.composite.Component;

import java.util.Comparator;

import static by.group12.zhylin.task2.composite.ComponentType.LEXEM;

public class LexemSymbolCompare implements Comparator<Component> {
    private char symbol;

    public LexemSymbolCompare(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public int compare(Component component1, Component component2) {
        if (LEXEM.equals(component1.getComponent()) && LEXEM.equals(component2.getComponent())) {
            String str2 = component2.toString();
            String str1 = component1.toString();
            int byCount = Integer.compare(charCount(str2), charCount(str1));
            if (byCount == 0) {
                if (str2.equals(str1)) {
                    return 0;
                }
                return str2.compareTo(str1);
            }
            return byCount;
        }
        return -1;
    }

    private int charCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }
}
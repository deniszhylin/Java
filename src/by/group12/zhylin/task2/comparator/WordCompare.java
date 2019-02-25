package by.group12.zhylin.task2.comparator;

import java.util.Comparator;

import by.group12.zhylin.task2.composite.Component;
import by.group12.zhylin.task2.composite.ComponentType;

import static by.group12.zhylin.task2.composite.ComponentType.LEXEM;

public class WordCompare implements Comparator<Component> {


    @Override
    public int compare(Component component1, Component component2) {
        if (LEXEM.equals(component1.componentTypes()) && LEXEM.equals(component2.componentTypes())) {
            return Integer.compare(component1.toString().length(), component2.toString().length());
        }
        return -1;
    }
}
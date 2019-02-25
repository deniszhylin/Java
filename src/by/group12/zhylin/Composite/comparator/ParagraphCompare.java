package by.group12.zhylin.Composite.comparator;

import by.group12.zhylin.Composite.composite.Component;

import java.util.Comparator;

import static by.group12.zhylin.Composite.composite.ComponentType.PARAGRAPH;

public class ParagraphCompare implements Comparator<Component> {
    @Override
    public int compare(Component component1, Component component2) {
        if (PARAGRAPH.equals(component1.componentTypes()) && PARAGRAPH.equals(component2.componentTypes())) {
            return Integer.compare(component1.getComponent().size(), component2.getComponent().size());
        }
        return -1;
    }
}
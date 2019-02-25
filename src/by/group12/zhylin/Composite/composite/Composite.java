package by.group12.zhylin.Composite.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    private List<Component> componentList = new ArrayList<>();
    private ComponentType componentType;

    public Composite(ComponentType componentType) {
        this.componentType = componentType;
    }

    @Override
    public void addComponent(Component component) {
        componentList.add(component);
    }

    public void removeComponent(Component component) {
        componentList.remove(component);
    }

    public Component getElementComponent(int index) {
        return componentList.get(index);
    }

    @Override
    public ComponentType componentTypes() {
        return componentType;
    }

    @Override
    public List<Component> getComponent() {
        return componentList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : componentList) {
            if (component.componentTypes() == componentType.PARAGRAPH) {
                stringBuilder.append("\n\t");
            }
            if (component.componentTypes() == componentType.LEXEM || component.componentTypes() == componentType.WORD) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(component.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return Objects.equals(componentList, composite.componentList) &&
                componentType == composite.componentType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentList, componentType);
    }
}
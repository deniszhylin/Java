package by.group12.zhylin.task2.composite;

import java.util.List;

public class Simbol implements Component {
    private char simbol;
    private ComponentType componentType;

    public Simbol(char simbol, ComponentType componentType) {
        this.simbol = simbol;
        this.componentType = componentType;
    }

    @Override
    public void addComponent(Component component) {

    }

    @Override
    public ComponentType componentTypes() {
        return componentType;
    }

    @Override
    public List<Component> getComponent() {
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(simbol);
    }
}
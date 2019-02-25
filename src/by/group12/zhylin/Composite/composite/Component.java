package by.group12.zhylin.Composite.composite;

import java.util.List;

public interface Component {

    void addComponent(Component component);

    ComponentType componentTypes();

    List<Component> getComponent();
}

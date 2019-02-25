package by.group12.zhylin.Tetrahedron.specification;

import by.group12.zhylin.Tetrahedron.entity.Tetrahedron;

public class ByNameSpecification implements Specification {
    private String name;

    public ByNameSpecification(String name) {
        this.name = name;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
        return tetrahedron.getNameFigure().equals(name);
    }
}

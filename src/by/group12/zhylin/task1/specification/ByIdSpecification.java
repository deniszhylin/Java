package by.group12.zhylin.task1.specification;

import by.group12.zhylin.task1.entity.Tetrahedron;

public class ByIdSpecification implements Specification {
    private long id;

    public ByIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
        return tetrahedron.getIdTetrahedron() == id;
    }
}
package by.group12.zhylin.Tetrahedron.specification;

import by.group12.zhylin.Tetrahedron.entity.Tetrahedron;

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
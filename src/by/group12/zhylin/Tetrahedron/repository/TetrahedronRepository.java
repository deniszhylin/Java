package by.group12.zhylin.Tetrahedron.repository;

import by.group12.zhylin.Tetrahedron.specification.Specification;

import java.util.List;

public interface TetrahedronRepository<T> {
    void add(T tetrahedron);

    void remove(T tetrahedron);

    void update(T tetrahedron);

    List<T> query(Specification specification);

}

package by.group12.zhylin.task1.repository;

import by.group12.zhylin.task1.entity.Tetrahedron;
import by.group12.zhylin.task1.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TetrahedronRepositoryImpl implements TetrahedronRepository<Tetrahedron> {
    private List<Tetrahedron> tetrahedronList = new ArrayList<>();
    private static TetrahedronRepositoryImpl instance = new TetrahedronRepositoryImpl();

    private TetrahedronRepositoryImpl() {
    }

    public static TetrahedronRepositoryImpl getInstance() {
        return instance;
    }

    @Override

    public void add(Tetrahedron tetrahedron) {
        tetrahedronList.add(tetrahedron);
    }

    @Override
    public void remove(Tetrahedron tetrahedron) {
        tetrahedronList.remove(tetrahedron);
    }

    @Override
    public void update(Tetrahedron tetrahedron) {
        tetrahedronList.removeIf(tetrahedron1 -> tetrahedron1.getIdTetrahedron() == tetrahedron.getIdTetrahedron());
        tetrahedronList.add(tetrahedron);
    }

    @Override
    public List<Tetrahedron> query(Specification specification) {
        List<Tetrahedron> result = new ArrayList<>();
        for (Tetrahedron t : tetrahedronList) {
            if (specification.specified(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public List<Tetrahedron> sortTetrahedronById() {
        List<Tetrahedron> tetrahedra = new ArrayList<>(tetrahedronList);

        tetrahedra.sort(Comparator.comparingLong(Tetrahedron::getIdTetrahedron));
        return tetrahedra;
    }

    public List<Tetrahedron> sortTetrahedronByName() {
        List<Tetrahedron> sortList = new ArrayList<>(tetrahedronList);
        sortList.sort(Comparator.comparing(Tetrahedron::getNameFigure));
        return sortList;
    }

    public List<Tetrahedron> sortTetrahedronByX_PointA() {
        List<Tetrahedron> sortList = new ArrayList<>(tetrahedronList);
        sortList.sort(Comparator.comparing(Tetrahedron::getX_PointA));
        return tetrahedronList;
    }

    public List<Tetrahedron> sortTetrahedronByY_PointA() {
        List<Tetrahedron> sortList = new ArrayList<>(tetrahedronList);
        sortList.sort(Comparator.comparing(Tetrahedron::getY_PointA));
        return tetrahedronList;
    }

    public List<Tetrahedron> sortTetrahedronByZ_PointA() {
        List<Tetrahedron> sortList = new ArrayList<>(tetrahedronList);
        sortList.sort(Comparator.comparing(Tetrahedron::getZ_PointA));
        return tetrahedronList;
    }

    public List<Tetrahedron> sortTetrahedronByX_PointB() {
        List<Tetrahedron> sortList = new ArrayList<>(tetrahedronList);
        sortList.sort(Comparator.comparing(Tetrahedron::getX_PointB));
        return tetrahedronList;
    }

    public List<Tetrahedron> sortTetrahedronByY_PointB() {
        List<Tetrahedron> sortList = new ArrayList<>(tetrahedronList);
        sortList.sort(Comparator.comparing(Tetrahedron::getY_PointB));
        return tetrahedronList;
    }

    public List<Tetrahedron> sortTetrahedronByZ_PointB() {
        List<Tetrahedron> sortList = new ArrayList<>(tetrahedronList);
        sortList.sort(Comparator.comparing(Tetrahedron::getZ_PointB));
        return tetrahedronList;
    }
}
package by.group12.zhylin.Tetrahedron.specification;

import by.group12.zhylin.Tetrahedron.action.Calculation;
import by.group12.zhylin.Tetrahedron.entity.Tetrahedron;

public class BySurfaceAreaSpecification implements Specification {
    double minArea;
    double maxArea;

    public BySurfaceAreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
        return minArea < Calculation.calcAreaSurfaceTetrahedron(tetrahedron) &&
                Calculation.calcAreaSurfaceTetrahedron(tetrahedron) < maxArea;
    }
}
package by.group12.zhylin.task1.specification;

import by.group12.zhylin.task1.action.Calculation;
import by.group12.zhylin.task1.entity.Tetrahedron;

public class ByVolumeSpecification implements Specification {
    double minArea;
    double maxArea;

    public ByVolumeSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(Tetrahedron tetrahedron) {
        return minArea < Calculation.calcVolumeTetrahedron(tetrahedron) &&
                Calculation.calcVolumeTetrahedron(tetrahedron) < maxArea;
    }
}

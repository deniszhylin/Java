package by.group12.zhylin.Tetrahedron.specification;

import by.group12.zhylin.Tetrahedron.action.Calculation;
import by.group12.zhylin.Tetrahedron.entity.Tetrahedron;

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

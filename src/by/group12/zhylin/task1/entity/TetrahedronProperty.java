package by.group12.zhylin.task1.entity;

public class TetrahedronProperty {
    private double areaSurfaceTetrahedron;
    private double volumeTetrahedron;

    public TetrahedronProperty(double areaSurfaceTetrahedron, double volumeTetrahedron) {
        this.areaSurfaceTetrahedron = areaSurfaceTetrahedron;
        this.volumeTetrahedron = volumeTetrahedron;
    }

    public double getAreaSurfaceTetrahedron() {
        return areaSurfaceTetrahedron;
    }

    public void setAreaSurfaceTetrahedron(double areaSurfaceTetrahedron) {
        this.areaSurfaceTetrahedron = areaSurfaceTetrahedron;
    }

    public double getVolumeTetrahedron() {
        return volumeTetrahedron;
    }

    public void setVolumeTetrahedron(double volumeTetrahedron) {
        this.volumeTetrahedron = volumeTetrahedron;
    }
}
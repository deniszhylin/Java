package by.group12.zhylin.Tetrahedron.entity;

import by.group12.zhylin.Tetrahedron.generator.IdGenerator;
import by.group12.zhylin.Tetrahedron.observer.TetrahedronObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tetrahedron {
    private long idTetrahedron;
    private String nameFigure;
    private Point pointA;
    private Point pointB;
    private List<TetrahedronObserver<Tetrahedron>> propertyTetrahedronObserver = new ArrayList<>();

    public Tetrahedron(Point pointA, Point pointB) {
        this.idTetrahedron = IdGenerator.generateId();
        StringBuilder stringBuilder = new StringBuilder("Tetrahedron");
        this.nameFigure = stringBuilder.append(idTetrahedron).toString();
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public void notifyObservers() {
        propertyTetrahedronObserver.forEach(tetrahedronObserver -> tetrahedronObserver.update(this));
    }

    public String getNameFigure() {
        return nameFigure;
    }

    public void setNameFigure(String nameFigure) {
        this.nameFigure = nameFigure;
    }

    public void add(TetrahedronObserver<Tetrahedron> tetrahedronObserver) {
        propertyTetrahedronObserver.add(tetrahedronObserver);
    }

    public void delete(TetrahedronObserver<Tetrahedron> tetrahedronObserver) {
        propertyTetrahedronObserver.remove(tetrahedronObserver);
    }

    public long getIdTetrahedron() {
        return idTetrahedron;
    }

    public void setIdTetrahedron(long idTetrahedron) {
        this.idTetrahedron = idTetrahedron;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
        notifyObservers();
    }

    public double getX_PointA() {
        return pointA.getX();
    }

    public double getY_PointA() {
        return pointA.getY();
    }

    public double getZ_PointA() {
        return pointA.getZ();
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
        notifyObservers();
    }

    public double getX_PointB() {
        return pointB.getX();
    }

    public double getY_PointB() {
        return pointB.getY();
    }

    public double getZ_PointB() {
        return pointB.getZ();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return idTetrahedron == that.idTetrahedron &&
                Objects.equals(nameFigure, that.nameFigure) &&
                Objects.equals(pointA, that.pointA) &&
                Objects.equals(pointB, that.pointB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTetrahedron, nameFigure, pointA, pointB);
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "idTetrahedron=" + idTetrahedron +
                ", nameFigure='" + nameFigure + '\'' +
                ", pointA=" + pointA +
                ", pointB=" + pointB +
                '}';
    }
}
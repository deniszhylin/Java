package by.group12.zhylin.Tetrahedron.entity;

public class Point {
    private double x;
    private double y;
    private double z;

    public Point() {
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int rezult = 1;
        rezult = prime * rezult + Double.valueOf(x).hashCode();
        rezult = prime * rezult + Double.valueOf(y).hashCode();
        rezult = prime * rezult + Double.valueOf(z).hashCode();
        return rezult;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0 && Double.compare(point.z, z) == 0;
    }

    @Override
    public String toString() {
        return "Point (x=" + x + ",y=" + y + ",z=" + z + ")";
    }
}
package by.group12.zhylin.task4.entity;


import java.util.Objects;

public class Specications {
    private String color;
    private boolean coated;
    private int pages;

    public Specications() {
    }

    public Specications(String color, boolean coated, int pages) {
        this.color = color;
        this.coated = coated;
        this.pages = pages;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isCoated() {
        return coated;
    }

    public void setCoated(boolean coated) {
        this.coated = coated;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specications that = (Specications) o;
        return coated == that.coated &&
                pages == that.pages &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, coated, pages);
    }
}
package by.group12.zhylin.XMLParsingWeb.entity;

import java.time.LocalDate;

public class Newspaper extends Paper {

    private int index;

    public Newspaper() {
    }

    public Newspaper(int index) {
        this.index = index;
    }

    public Newspaper(String name, int index, String id, LocalDate date, PapersType papersType,
                     Specications specications) {
        super(name, id, date, specications);
        this.index = index;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Newspaper newspaper = (Newspaper) o;
        return index == newspaper.index;
    }

    @Override
    public int hashCode() {
        final long prime = 31;
        int result = 1;
        result = (int) (prime * result + Double.valueOf(index));
        return result;
    }
}
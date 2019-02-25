package by.group12.zhylin.XMLParsingWeb.entity;

import java.time.LocalDate;

public class Booklet extends Paper {
    private boolean monthly;

    public Booklet() {
    }

    public Booklet(boolean monthly) {
        this.monthly = monthly;
    }

    public Booklet(String name, String id, LocalDate date, boolean monthly, PapersType papersType, Specications specications) {
        super(name, id, date, specications);
        this.monthly = monthly;
    }

    public boolean isMonthly() {
        return monthly;
    }

    public void setMonthly(boolean monthly) {
        this.monthly = monthly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Booklet booklet = (Booklet) o;
        return monthly == booklet.monthly;
    }

    @Override
    public int hashCode() {
        final long prime = 31;
        int result = 1;
        result = (int) (prime * result + (monthly ? 1231 : 1237));
        return result;
    }
}
package by.group12.zhylin.task4.entity;

import java.time.LocalDate;

public class Magazine extends Paper {
    private int index;
    private boolean monthly;

    public Magazine() {
    }

    public Magazine(int index, boolean monthly) {
        this.index = index;
        this.monthly = monthly;
    }

    public Magazine(String name, int index, String id, boolean monthly, LocalDate date, PapersType papersType,
                    Specications specications) {
        super(name, id, date, specications);
        this.index = index;
        this.monthly = monthly;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
        Magazine magazine = (Magazine) o;
        return index == magazine.index &&
                monthly == magazine.monthly;
    }

    @Override
    public int hashCode() {
        final long prime = 31;
        int result = 1;
        result = (int) (prime * result + Double.valueOf(index));
        result = (int) (prime * result + (monthly ? 1231 : 1237));
        return result;
    }
}
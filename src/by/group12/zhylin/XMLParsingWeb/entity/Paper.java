package by.group12.zhylin.XMLParsingWeb.entity;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Paper {
    private String name;
    private String id;
    private LocalDate date;
    private Specications specications;

    public Paper() {
        specications = new Specications();
    }

    public Paper(String name, String id, LocalDate date, Specications specications) {
        this.name = name;
        this.date = date;
        this.id = id;
        this.specications = specications;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Specications getSpecications() {
        return specications;
    }

    public void setSpecications(Specications specications) {
        this.specications = specications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paper paper = (Paper) o;
        return id == paper.id &&
                Objects.equals(name, paper.name) &&
                Objects.equals(date, paper.date) &&
                Objects.equals(specications, paper.specications);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((specications == null) ? 0 : specications.hashCode());
        return result;
    }
}
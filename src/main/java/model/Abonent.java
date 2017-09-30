package model;

import javax.persistence.*;

@Entity
@Table(name="abonents")
public class Abonent extends _IDEntity{

    @Column
    private String name;

    public Abonent() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Abonent abonent = (Abonent) o;

        return name != null ? name.equals(abonent.name) : abonent.name == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

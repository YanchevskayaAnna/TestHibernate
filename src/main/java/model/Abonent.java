package model;

import javax.persistence.*;

@Entity
@Table(name="abonents")
public class Abonent extends _IdEntity{

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
}

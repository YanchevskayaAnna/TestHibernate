package model;

import javax.persistence.*;

@Entity
@Table(name="services")
public class Service extends _IdEntity{

    @Column
    private String name;

    public Service() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package model;

import javax.persistence.*;

@MappedSuperclass
public class _IDEntity {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        _IDEntity idEntity = (_IDEntity) o;

        return id != null ? id.equals(idEntity.id) : idEntity.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

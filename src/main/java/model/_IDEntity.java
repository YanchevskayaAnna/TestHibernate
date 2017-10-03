package model;

import javax.persistence.*;

@MappedSuperclass
// It works !
public abstract class _IDEntity implements _iIDEntity{
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public Integer getId() {
        return id;
    }
}

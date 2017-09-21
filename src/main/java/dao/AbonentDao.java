package dao;

import model.Abonent;

import javax.persistence.EntityManagerFactory;

/**
 * Created by IT-Univer004 on 21.09.2017.
 */
public class AbonentDao extends AbstractDAO<Abonent>{

    public AbonentDao(EntityManagerFactory factory) {
        super(factory);
    }
}

package dao;

import model.Abonent;

import javax.persistence.EntityManagerFactory;


public class AbonentDao extends AbstractDAO<Abonent>{

    public AbonentDao(EntityManagerFactory factory) {
        super(factory, Abonent.class);
    }
}

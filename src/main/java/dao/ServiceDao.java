package dao;


import model.Service;

import javax.persistence.EntityManagerFactory;

public class ServiceDao extends AbstractDAO<Service>{
    public ServiceDao(EntityManagerFactory factory) {
        super(factory);
    }
}

package dao;


import model.Service;
import model.ServiceAbonent;

import javax.persistence.EntityManagerFactory;

public class ServiceAbonentDao extends AbstractDAO<ServiceAbonent>{
    public ServiceAbonentDao(EntityManagerFactory factory) {
        super(factory, ServiceAbonent.class);
    }
}

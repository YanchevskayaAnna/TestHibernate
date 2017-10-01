package dao;


import dao.interfaces.iServiceAbonentDao;
import model.Abonent;
import model.Service;
import model.ServiceAbonent;

import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.List;

public class ServiceAbonentDao extends AbstractDAO<ServiceAbonent> implements iServiceAbonentDao {
    public ServiceAbonentDao(EntityManagerFactory factory) {
        super(factory, ServiceAbonent.class);
    }

    @Override
    public List<Service> GetCurrentServices(Abonent abonent, Date date) {
        return null;
    }
}

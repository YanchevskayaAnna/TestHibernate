package dao;


import dao.interfaces.iServiceDao;
import model.Abonent;
import model.Service;

import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.List;

public class ServiceDao extends AbstractDAO<Service> implements iServiceDao {
    public ServiceDao(EntityManagerFactory factory) {
        super(factory, Service.class);
    }

    @Override
    public List<Abonent> getAllAbonentsWithService(Service service, int start, int end) {
        return null;
    }

    @Override
    public List<Abonent> getAllAbonentsWithServiceOnDate(Service service, Date date, int start, int end) {
        return null;
    }
}

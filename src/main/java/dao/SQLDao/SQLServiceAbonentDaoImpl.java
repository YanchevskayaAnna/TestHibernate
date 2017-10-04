package dao.SQLDao;


import dao.interfaces.ServiceAbonentDao;
import model.Abonent;
import model.Service;
import model.ServiceAbonent;

import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.List;

public class SQLServiceAbonentDaoImpl extends SQLAbstractDAOImpl<ServiceAbonent> implements ServiceAbonentDao {
    public SQLServiceAbonentDaoImpl(EntityManagerFactory factory) {
        super(factory, ServiceAbonent.class);
    }

    @Override
    public List<Service> GetCurrentServices(Abonent abonent, Date date) {
        return null;
    }
}

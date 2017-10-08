package dao.SQLDao;


import dao.interfaces.ServiceAbonentDao;
import model.Abonent;
import model.Service;
import model.ServiceAbonent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class SQLServiceAbonentDaoImpl extends SQLAbstractDAOImpl<ServiceAbonent> implements ServiceAbonentDao {
    public SQLServiceAbonentDaoImpl(EntityManagerFactory factory) {
        super(factory, ServiceAbonent.class);
    }

    @Override
    public List<Service> GetCurrentServices(Abonent abonent, Date date) {
        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT sa.abonent FROM ServiceAbonent sa where sa.service = :service and sa.dateFrom <= :date and (sa.dateTo >= :date or sa.dateTo IS NULL)";
//      String queryString = "SELECT sa.service FROM ServiceAbonent sa where sa.abonent = :abonent and sa.dateFrom <= :date";
        TypedQuery<Service> query = em.createQuery(queryString, Service.class);
        query.setParameter("abonent", abonent);
        query.setParameter("date", date);
//        query.setParameter("nulldate", null);
        return query.getResultList();

    }
}

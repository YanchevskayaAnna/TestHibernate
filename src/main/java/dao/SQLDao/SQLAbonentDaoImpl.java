package dao.SQLDao;

import dao.interfaces.AbonentDao;
import model.Abonent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Date;


public class SQLAbonentDaoImpl extends SQLAbstractDAOImpl<Abonent> implements AbonentDao {

    public SQLAbonentDaoImpl(EntityManagerFactory factory) {
        super(factory, Abonent.class);
    }

    @Override
    public int CalculateBalance(Abonent abonent, Date date) {
        return 0;
    }

    @Override
    public int CalculateDebts(Abonent abonent, Date date) {
        return 0;
    }
}

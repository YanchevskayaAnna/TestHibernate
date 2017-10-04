package dao.SQLDao;

import dao.interfaces.AbonentDao;
import model.Abonent;

import javax.persistence.EntityManagerFactory;
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
    public int CalculateDabts(Abonent abonent, Date date) {
        return 0;
    }
}

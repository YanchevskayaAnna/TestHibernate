package dao;

import dao.interfaces.iAbonentDao;
import model.Abonent;

import javax.persistence.EntityManagerFactory;
import java.util.Date;


public class AbonentDao extends AbstractDAO<Abonent> implements iAbonentDao {

    public AbonentDao(EntityManagerFactory factory) {
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

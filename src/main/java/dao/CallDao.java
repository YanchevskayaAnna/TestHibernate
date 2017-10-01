package dao;

import dao.interfaces.iCallDao;
import model.Abonent;
import model.Call;

import javax.persistence.EntityManagerFactory;
import java.util.Date;

public class CallDao extends AbstractDAO<Call> implements iCallDao {
    public CallDao(EntityManagerFactory factory) {
        super(factory, Call.class);
    }

    @Override
    public int getAverageDuration(Abonent abonent) {
        return 0;
    }

    @Override
    public int getAverageDuration(Abonent abonent, Date dateFrom, Date dateTo) {
        return 0;
    }
}

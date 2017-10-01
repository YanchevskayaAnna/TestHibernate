package dao;

import dao.interfaces.iCallDao;
import model.Abonent;
import model.Call;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<Abonent, Integer> getAverageDuration() {
        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT m.abonent,  AVG(m.duration) FROM Call m GROUP BY m.abonent";
        TypedQuery<Object[]> query = em.createQuery(queryString, Object[].class);
        List<Object[]> resultList = query.getResultList();

        HashMap<Abonent, Integer> map = new HashMap<Abonent, Integer>();

        for (int i = 0; i < resultList.size(); i++) {
            map.put((Abonent) resultList.get(i)[0], ((Double) resultList.get(i)[1]).intValue());
        }
        return map;
    }

    @Override
    public Map<Abonent, Integer> getAverageDuration(Date dateFrom, Date dateTo) {
        return null;
    }

    @Override
    public Map<User, Integer> getAverageDurationUser() {
        return null;
    }

    @Override
    public Map<User, Integer> getAverageDurationUser(Date dateFrom, Date dateTo) {
        return null;
    }
}

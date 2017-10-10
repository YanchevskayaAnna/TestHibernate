package dao.SQLDao;

import dao.interfaces.AbonentDao;
import model.Abonent;
import model.Service;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;


public class SQLAbonentDaoImpl extends SQLAbstractDAOImpl<Abonent> implements AbonentDao {

    public SQLAbonentDaoImpl(EntityManagerFactory factory) {
        super(factory, Abonent.class);
    }

    @Override
    public int CalculateBalance(Abonent abonent, Date date) {
//        EntityManager em = factory.createEntityManager();
//        //Строим таблицу с полями Сервис Дата с - Дата по
//        String queryString = "SELECT sa.service, s.subscriptionFee, sa.dateFrom, sa.dateTo FROM ServiceAbonent sa join sa.service s  WHERE sa.abonent = :abonent and sa.dateFrom <= :date";
//        TypedQuery<Object[]> query = em.createQuery(queryString, Object[].class);
//        query.setParameter("abonent",   abonent);
//        query.setParameter("date",   date);
//        List<Object[]> resultList = query.getResultList();
//        Double summ = 0.0;
//        Service service;
//        int subscriptionFee;
//        Date dateFrom;
//        Date dateTo;
//
//        for (int i = 0; i < resultList.size(); i++) {
//            service = (Service) resultList.get(i)[0];
//            subscriptionFee = ((Integer) resultList.get(i)[1]).intValue();
//            dateFrom = (Date) resultList.get(i)[2];
//            dateTo = (Date) resultList.get(i)[3];
//            System.out.printf("Сервис %s с абонплатой %d с %s по %s", service, subscriptionFee, dateFrom, dateTo);
//            while ((dateFrom.compareTo(date) < 0) && ((dateTo == null) || (dateTo.compareTo(date) > 0))) {
//                summ += subscriptionFee;
//                todo увеличиваем dateFrom на 1 месяц ???
//            }
//        }
//
//        //Запрашиваем общую сумму всех оплат
//        queryString = "SELECT SUM(p.value) FROM Payment p  WHERE p.paymentDay <= :date and p.abonent = :abonent";
//        TypedQuery<Long> queryPaymemt = em.createQuery(queryString, Long.class);
//        queryPaymemt.setParameter("date",  date);
//        queryPaymemt.setParameter("abonent",  abonent);
//        Double payment = queryPaymemt.getSingleResult().doubleValue();
//
//        return (int) (summ - payment);
        return 0;
    }

    @Override
    public int CalculateDebts(Abonent abonent, Date date) {
        Integer balance = CalculateBalance(abonent, date);
        return balance > 0 ? balance : 0;
    }
}

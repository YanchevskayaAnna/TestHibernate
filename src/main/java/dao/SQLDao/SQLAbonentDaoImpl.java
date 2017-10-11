package dao.SQLDao;

import dao.interfaces.AbonentDao;
import model.Abonent;
import model.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;


public class SQLAbonentDaoImpl extends SQLAbstractDAOImpl<Abonent> implements AbonentDao {

    public SQLAbonentDaoImpl(EntityManagerFactory factory) {
        super(factory, Abonent.class);
    }

    @Override
    public int CalculateBalance(Abonent abonent, LocalDate date) {
        EntityManager em = factory.createEntityManager();
        //Строим таблицу с полями Сервис Дата с - Дата по
        String queryString = "SELECT sa.service, s.subscriptionFee, sa.dateFrom, sa.dateTo FROM ServiceAbonent sa join sa.service s  WHERE sa.abonent = :abonent and sa.dateFrom <= :date";
        TypedQuery<Object[]> query = em.createQuery(queryString, Object[].class);
        query.setParameter("abonent",   abonent);
        query.setParameter("date",   date);
        List<Object[]> resultList = query.getResultList();
        int summ = 0;
        Service service;
        int subscriptionFee;
        LocalDate dateFrom;
        LocalDate dateTo;

        for (int i = 0; i < resultList.size(); i++) {
            service = (Service) resultList.get(i)[0];
            subscriptionFee = ((Integer) resultList.get(i)[1]).intValue();
            dateFrom = (LocalDate) resultList.get(i)[2];
            dateTo = (LocalDate) resultList.get(i)[3];
            System.out.printf("Сервис %s с абонплатой %d с %s по %s", service, subscriptionFee, dateFrom, dateTo);
            LocalDate dateEnd = ((dateTo == null) || (dateTo.compareTo(date) > 0)) ? date : dateTo;
            int monthCount = (dateEnd.getYear()*12 + dateEnd.getMonthValue()) - (dateFrom.getYear()*12 + dateFrom.getMonthValue());
            summ += monthCount*subscriptionFee;
        }
        //Запрашиваем общую сумму всех оплат
        queryString = "SELECT SUM(p.value) FROM Payment p  WHERE p.paymentDay <= :date and p.abonent = :abonent";
        TypedQuery<Long> queryPaymemt = em.createQuery(queryString, Long.class);
        queryPaymemt.setParameter("date",  date);
        queryPaymemt.setParameter("abonent",  abonent);
        Double payment = queryPaymemt.getSingleResult().doubleValue();

        return (int) (summ - payment);
    }

    @Override
    public int CalculateDebts(Abonent abonent, LocalDate date) {
        Integer balance = CalculateBalance(abonent, date);
        return balance > 0 ? balance : 0;
    }
}

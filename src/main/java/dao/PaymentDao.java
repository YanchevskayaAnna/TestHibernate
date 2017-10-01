package dao;

import dao.interfaces.iPaymentDao;
import model.Payment;
import model.User;

import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.Map;

public class PaymentDao extends AbstractDAO<Payment> implements iPaymentDao {
    public PaymentDao(EntityManagerFactory factory) {
        super(factory, Payment.class);
    }

    @Override
    public Map<User, Integer> getAveragePayment() {
        return null;
    }

    @Override
    public int getAllPayments(Date dateFrom, Date dateTo) {
        return 0;
    }
}

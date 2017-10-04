package dao.SQLDao;

import dao.interfaces.PaymentDao;
import model.Payment;
import model.User;

import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.Map;

public class SQLPaymentDaoImpl extends SQLAbstractDAOImpl<Payment> implements PaymentDao {
    public SQLPaymentDaoImpl(EntityManagerFactory factory) {
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

package dao.interfaces;

import model.Payment;
import model.User;

import java.util.Date;
import java.util.Map;

public interface PaymentDao extends AbstractDAO<Payment> {
    public Map<User, Integer> getAveragePayment();
    public int getAllPayments (Date dateFrom, Date dateTo);
}

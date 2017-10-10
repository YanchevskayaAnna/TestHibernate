package dao.interfaces;

import model.Payment;
import model.User;

import java.util.Date;
import java.util.Map;

public interface PaymentDao extends AbstractDAO<Payment> {
    public Map<User, Integer> getAveragePayment();
    public Double getAllPayments (Date dateFrom, Date dateTo);
}

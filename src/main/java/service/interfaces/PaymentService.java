package service.interfaces;

import model.Payment;
import model.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PaymentService {

    public List<Payment> getAllPayments();

    public Payment getPaymentById(Integer id);

    public boolean createPayment(Payment payment);

    public boolean updatePayment(Payment payment);

    public boolean deletePayment(Payment payment);

    public Map<User, Integer> getAveragePayment();
    public Double getAllPayments (Date dateFrom, Date dateTo);
}

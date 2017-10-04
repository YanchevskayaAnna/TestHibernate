package service;


import dao.interfaces.PaymentDao;
import model.Payment;

import java.util.List;

public class PaymentController {

    private PaymentDao paymentDAO;

    public PaymentController(PaymentDao paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public List<Payment> getAllPayments() {
        return paymentDAO.getAll();
    }

    public Payment getPaymentById(Integer id)  {
        return paymentDAO.getEntityById(id);
    }

    public boolean createPayment(Payment payment)   {
        return paymentDAO.create(payment);
    }

    public boolean updatePayment(Payment payment)   {
        return paymentDAO.update(payment);
    }

    public boolean deletePayment(Payment payment)   {
        return paymentDAO.delete(payment);
    }

}

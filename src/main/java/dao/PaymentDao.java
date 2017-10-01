package dao;

import model.Payment;

import javax.persistence.EntityManagerFactory;

public class PaymentDao extends AbstractDAO<Payment>{
    public PaymentDao(EntityManagerFactory factory) {
        super(factory, Payment.class);
    }
}

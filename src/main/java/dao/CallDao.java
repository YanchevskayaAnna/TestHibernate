package dao;

import model.Call;

import javax.persistence.EntityManagerFactory;

public class CallDao extends AbstractDAO<Call>{
    public CallDao(EntityManagerFactory factory) {
        super(factory, Call.class);
    }
}

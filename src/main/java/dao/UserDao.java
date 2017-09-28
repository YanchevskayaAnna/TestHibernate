package dao;

import model.User;

import javax.persistence.EntityManagerFactory;

public class UserDao extends AbstractDAO<User> {

    public UserDao(EntityManagerFactory factory) {
        super(factory);
    }

}

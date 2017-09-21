package dao;

import model.User;

import javax.persistence.EntityManagerFactory;

/**
 * Created by IT-Univer004 on 21.09.2017.
 */
public class UserDao extends AbstractDAO<User> {

    public UserDao(EntityManagerFactory factory) {
        super(factory);
    }
}

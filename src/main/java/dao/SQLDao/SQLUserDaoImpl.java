package dao.SQLDao;

import dao.interfaces.UserDao;
import model.User;
import model.UserType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;

public class SQLUserDaoImpl extends SQLAbstractDAOImpl<User> implements UserDao {

    public SQLUserDaoImpl(EntityManagerFactory factory) {
        super(factory, User.class);
    }

    @Override
    public List<User> getAllUsersWithUserType(UserType usertype) {

        EntityManager em = factory.createEntityManager();
        String queryString = "SELECT u FROM User u where u.userType = :usertype";
        TypedQuery<User> query = em.createQuery(queryString, User.class);
        query.setParameter("usertype", usertype);
        return query.getResultList();
    }
}

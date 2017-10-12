package dao.SQLDao;

import dao.interfaces.UserDao;
import exception.TableIsEmptyException;
import model.Abonent;
import model.User;
import model.UserType;
import sun.awt.datatransfer.DataTransferer;

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

    @Override
    public List<Abonent> getAllAbonents(User user) throws TableIsEmptyException {
        List<Abonent> resultlist = user.getAbonentList();
        if (resultlist.size() == 0) {
            throw new TableIsEmptyException("Current table is empty");
        }
        return resultlist;
    }


}

package dao.SQLDao;

import dao.interfaces.UserDao;
import model.User;
import model.UserType;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class SQLUserDaoImpl extends SQLAbstractDAOImpl<User> implements UserDao {

    public SQLUserDaoImpl(EntityManagerFactory factory) {
        super(factory, User.class);
    }

    @Override
    public List<User> getAllUsersWithUserType(UserType usertype, int start, int end) {
        return null;
    }
}

package dao;

import dao.interfaces.iUserDao;
import model.User;
import model.UserType;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserDao extends AbstractDAO<User> implements iUserDao {

    public UserDao(EntityManagerFactory factory) {
        super(factory, User.class);
    }

    @Override
    public List<User> getAllUsersWithUserType(UserType usertype, int start, int end) {
        return null;
    }
}

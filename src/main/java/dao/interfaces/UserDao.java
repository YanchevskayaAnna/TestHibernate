package dao.interfaces;

import model.User;
import model.UserType;

import java.util.List;

public interface UserDao extends AbstractDAO<User> {

    public List<User> getAllUsersWithUserType(UserType usertype, int start, int end);
}

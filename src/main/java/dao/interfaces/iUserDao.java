package dao.interfaces;

import model.User;
import model.UserType;

import java.util.List;

public interface iUserDao extends iAbstractDAO<User>{

    public List<User> getAllUsersWithUserType(UserType usertype, int start, int end);
}

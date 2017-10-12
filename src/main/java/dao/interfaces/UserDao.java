package dao.interfaces;

import exception.TableIsEmptyException;
import model.Abonent;
import model.User;
import model.UserType;

import java.util.List;

public interface UserDao extends AbstractDAO<User> {

    public List<User> getAllUsersWithUserType(UserType usertype);

    public List<Abonent> getAllAbonents(User user) throws TableIsEmptyException;
}

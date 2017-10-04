package service.interfaces;

import model.User;
import model.UserType;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUserById(Integer id);

    public boolean createUser(User user);

    public boolean updateUsert(User user);

    public boolean deleteUser(User user);

    public List<User> getAllUsersWithUserType(UserType usertype, int start, int end);
}

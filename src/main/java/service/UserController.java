package service;


import dao.AbonentDao;
import dao.UserDao;
import model.Abonent;
import model.User;

import java.util.List;

public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    public User getUserById(Integer id)  {
        return userDao.getEntityById(id);
    }

    public boolean createUser(User user)   {
        return userDao.create(user);
    }

    public boolean updateUsert(User user)   {
        return userDao.update(user);
    }

    public boolean deleteUser(User user)   {
        return userDao.delete(user);
    }

}

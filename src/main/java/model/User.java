package model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="users")
@NamedQuery(name = "User.getAll", query = "SELECT c from User c")
public class User extends _IDEntity{

    @Column
    private String login;

    @Column
    private String pass;

    @Column(name = "usertype")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Abonent> abonentList;

    public User(String login, String pass, UserType userType) {
        this.login = login;
        this.pass = pass;
        this.userType = userType;
    }

    public User() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public UserType getUserType() {
        return userType;
    }
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (pass != null ? !pass.equals(user.pass) : user.pass != null) return false;
        return userType == user.userType;

    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", userType=" + userType +
                ", abonentList=" + abonentList.size() +
                '}';
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        return result;
    }

}

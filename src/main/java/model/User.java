package model;

import javax.persistence.*;


@Entity
@Table(name="users")
public class User extends _IdEntity{
    @Column
    private String login;

    @Column
    private String pass;

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

}

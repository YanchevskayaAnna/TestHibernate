package model.auxiliary;

import model.Abonent;
import model.Service;
import model.UserType;

import java.util.List;

public class AbonentInfo {

    private String abonentName;
    private UserType type;
    private List<Service> services;
    private Integer balance;

    public AbonentInfo() {
    }

    public String getAbonentName() {
        return abonentName;
    }

    public void setAbonentName(String abonentName) {
        this.abonentName = abonentName;
    }

    public AbonentInfo(String abonentName, UserType type, List<Service> services, Integer balance) {
        this.abonentName = abonentName;
        this.type = type;

        this.services = services;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AbonentInfo{" +
                "abonent=" + abonentName +
                ", type=" + type +
                ", services=" + services +
                ", balance=" + balance +
                '}';
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbonentInfo)) return false;

        AbonentInfo that = (AbonentInfo) o;

        if (abonentName != null ? !abonentName.equals(that.abonentName) : that.abonentName != null) return false;
        return false;

    }

    @Override
    public int hashCode() {
        int result = abonentName != null ? abonentName.hashCode() : 0;
        return result;
    }

}

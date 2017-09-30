package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="abonents")
@NamedQuery(name = "Abonent.getAll", query = "SELECT c from Abonent c")
public class Abonent extends _IDEntity{

    @Column
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id",
            referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "abonent", fetch = FetchType.LAZY)
    private List<ServiceAbonent> serviceList;

    @OneToMany(mappedBy = "abonent", fetch = FetchType.LAZY)
    private List<Payment> paymentList;

    public Abonent() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Abonent)) return false;
        if (!super.equals(o)) return false;

        Abonent abonent = (Abonent) o;

        if (name != null ? !name.equals(abonent.name) : abonent.name != null) return false;
        if (user != null ? !user.equals(abonent.user) : abonent.user != null) return false;
        if (serviceList != null ? !serviceList.equals(abonent.serviceList) : abonent.serviceList != null) return false;
        return paymentList != null ? paymentList.equals(abonent.paymentList) : abonent.paymentList == null;

    }

    @Override
    public String toString() {
        return "Abonent{" +
                "name='" + name + '\'' +
                ", user=" + user +
                ", serviceList=" + serviceList +
                ", paymentList=" + paymentList +
                '}';
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (serviceList != null ? serviceList.hashCode() : 0);
        result = 31 * result + (paymentList != null ? paymentList.hashCode() : 0);
        return result;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ServiceAbonent> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<ServiceAbonent> serviceList) {
        this.serviceList = serviceList;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}

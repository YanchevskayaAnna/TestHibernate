package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="service_abonents")
public class ServiceAbonent extends _IDEntity{

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "service_id",
            referencedColumnName = "id")
    private Service service;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "abonent_id",
            referencedColumnName = "id")
    private Abonent abonent;

    @Column
    private Date dateFrom;

    @Column
    private Date dateTo;

    public ServiceAbonent() {
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Abonent getAbonent() {
        return abonent;
    }

    public void setAbonent(Abonent abonent) {
        this.abonent = abonent;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceAbonent)) return false;
        if (!super.equals(o)) return false;

        ServiceAbonent that = (ServiceAbonent) o;

        if (service != null ? !service.equals(that.service) : that.service != null) return false;
        if (abonent != null ? !abonent.equals(that.abonent) : that.abonent != null) return false;
        if (dateFrom != null ? !dateFrom.equals(that.dateFrom) : that.dateFrom != null) return false;
        return dateTo != null ? dateTo.equals(that.dateTo) : that.dateTo == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (service != null ? service.hashCode() : 0);
        result = 31 * result + (abonent != null ? abonent.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ServiceAbonent{" +
                "service=" + service +
                ", abonent=" + abonent +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}

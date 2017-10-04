package dao.interfaces;

import model.Abonent;
import model.Call;
import model.User;

import java.util.Date;
import java.util.Map;

public interface iCallDao extends iAbstractDAO<Call>{

    public Double getAverageDuration(Abonent abonent);
    public Double getAverageDuration(Abonent abonent, Date dateFrom, Date dateTo);
    public Map<Abonent, Integer> getAverageDuration();
    public Map<Abonent, Integer> getAverageDuration(Date dateFrom, Date dateTo);
    public Map<User, Integer> getAverageDurationUser();
    public Map<User, Integer> getAverageDurationUser(Date dateFrom, Date dateTo);

}

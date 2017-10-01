package dao.interfaces;

import model.Abonent;
import model.Call;

import java.util.Date;

public interface iCallDao extends iAbstractDAO<Call>{

    public int getAverageDuration(Abonent abonent);
    public int getAverageDuration(Abonent abonent, Date dateFrom, Date dateTo);

}

package dao.interfaces;


import model.*;

import java.util.Date;
import java.util.List;

public interface iServiceDao extends iAbstractDAO<Service> {

    public List<Abonent> getAllAbonentsWithService(Service service, int start, int end);
    public List<Abonent> getAllAbonentsWithServiceOnDate(Service service, Date date, int start, int end);
}

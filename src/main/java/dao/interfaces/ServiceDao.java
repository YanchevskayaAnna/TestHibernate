package dao.interfaces;


import model.*;

import java.util.Date;
import java.util.List;

public interface ServiceDao extends AbstractDAO<Service> {

    public List<Abonent> getAllAbonentsWithService(Service service, int start, int end);
    public List<Abonent> getAllAbonentsWithServiceOnDate(Service service, Date date, int start, int end);
}

package dao.interfaces;

import model.Abonent;
import model.Service;
import model.ServiceAbonent;

import java.util.Date;
import java.util.List;

public interface iServiceAbonentDao extends iAbstractDAO<ServiceAbonent> {

    public List<Service> GetCurrentServices(Abonent abonent, Date date);
}

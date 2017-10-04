package dao.interfaces;

import model.Abonent;
import model.Service;
import model.ServiceAbonent;

import java.util.Date;
import java.util.List;

public interface ServiceAbonentDao extends AbstractDAO<ServiceAbonent> {

    public List<Service> GetCurrentServices(Abonent abonent, Date date);
}

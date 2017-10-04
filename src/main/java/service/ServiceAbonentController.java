package service;

import dao.interfaces.ServiceAbonentDao;
import model.ServiceAbonent;

import java.util.List;

public class ServiceAbonentController {

    private ServiceAbonentDao serviceAbonentDao;

    public ServiceAbonentController(ServiceAbonentDao serviceAbonentDao) {
        this.serviceAbonentDao = serviceAbonentDao;
    }

    public List<ServiceAbonent> getAllServiceAbonents() {
        return serviceAbonentDao.getAll();
    }

    public ServiceAbonent getServiceAbonentById(Integer id)  {
        return serviceAbonentDao.getEntityById(id);
    }

    public  boolean createServiceAbonent(ServiceAbonent serviceAbonent)   {
        return serviceAbonentDao.create(serviceAbonent);
    }

    public boolean updateServiceAbonent(ServiceAbonent serviceAbonent)   {
        return serviceAbonentDao.update(serviceAbonent);
}

    public boolean deleteServiceAbonent(ServiceAbonent serviceAbonent)   {
        return serviceAbonentDao.delete(serviceAbonent);
    }

}

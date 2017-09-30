package service;



import dao.ServiceDao;
import model.Service;

import java.util.List;

public class ServiceController {

    private ServiceDao serviceDao;

    public ServiceController(ServiceDao serviceDAO) {
        this.serviceDao = serviceDAO;
    }

    public List<Service> getAllAbonents() {
        return serviceDao.getAll();
    }

    public Service getAbonentById(Integer id)  {
        return serviceDao.getEntityById(id);
    }

    public  boolean createService(Service service)   {
        return serviceDao.create(service);
    }

    public boolean updateService(Service service)   {
        return serviceDao.update(service);
}

    public boolean deleteService(Service service)   {
        return serviceDao.delete(service);
    }

}

package service;


import dao.AbonentDao;
import model.Abonent;

import java.util.List;

public class AbonentController {

    private AbonentDao abonentDAO;

    public AbonentController(AbonentDao abonentDAO) {
        this.abonentDAO = abonentDAO;
    }

    public List<Abonent> getAllAbonents() {
        return abonentDAO.getAll();
    }

    public Abonent getAbonentById(Integer id)  {
        return abonentDAO.getEntityById(id);
    }

    public boolean createAbonent(Abonent abonent)   {
        return abonentDAO.create(abonent);
    }

    public boolean updateAbonent(Abonent abonent)   {
        return abonentDAO.update(abonent);
    }

    public boolean deleteAbonent(Abonent abonent)   {
        return abonentDAO.delete(abonent);
    }

}

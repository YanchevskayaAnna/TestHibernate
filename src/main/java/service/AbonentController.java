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

    public Abonent getEntityById(Integer id) throws Exception  {
        return abonentDAO.getEntityById(id);
    }

}

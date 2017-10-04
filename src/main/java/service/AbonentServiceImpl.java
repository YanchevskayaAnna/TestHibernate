package service;


import dao.interfaces.AbonentDao;
import model.Abonent;
import service.interfaces.AbonentService;

import java.util.Date;
import java.util.List;

public class AbonentServiceImpl implements AbonentService{

    private AbonentDao abonentDAO;

    public AbonentServiceImpl(AbonentDao abonentDAO) {
        this.abonentDAO = abonentDAO;
    }

    public List<Abonent> getAllAbonents()    {
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

    @Override
    public int CalculateBalance(Abonent abonent, Date date) {
        return 0;
    }

    @Override
    public int CalculateDabts(Abonent abonent, Date date) {
        return 0;
    }

}

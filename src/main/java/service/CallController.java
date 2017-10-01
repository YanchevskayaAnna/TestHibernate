package service;


import dao.AbonentDao;
import dao.CallDao;
import model.Abonent;
import model.Call;

import java.util.List;
import java.util.Map;

public class CallController {

    private CallDao callDAO;

    public CallController(CallDao callDAO) {
        this.callDAO = callDAO;
    }

    public List<Call> getAllCalls() {
        return callDAO.getAll();
    }

    public Call getCallById(Integer id)  {
        return callDAO.getEntityById(id);
    }

    public boolean createCall(Call call)   {
        return callDAO.create(call);
    }

    public boolean updateCall(Call call)   {
        return callDAO.update(call);
    }

    public boolean deleteCall(Call call)   {
        return callDAO.delete(call);
    }

    public Map<Abonent, Integer> getAverageDuration(){
        return callDAO.getAverageDuration();
    }

}

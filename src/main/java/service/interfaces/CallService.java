package service.interfaces;

import model.Abonent;
import model.Call;
import model.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CallService {

    public List<Call> getAllCalls();

    public Call getCallById(Integer id);

    public boolean createCall(Call call);

    public boolean updateCall(Call call);

    public boolean deleteCall(Call call);

    public Map<Abonent, Integer> getAverageDuration();

    public Map<Abonent, Integer> getAverageDuration(Date dateFrom, Date dateTo);

    public Map<User, Integer> getAverageDurationUser();

    public Map<User, Integer> getAverageDurationUser(Date dateFrom, Date dateTo);

    public Double getAverageDuration(Abonent abonent);
    public Double getAverageDuration(Abonent abonent, Date dateFrom, Date dateTo);
}

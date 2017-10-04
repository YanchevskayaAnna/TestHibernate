package dao.interfaces;

import model.Abonent;
import java.util.Date;

public interface AbonentDao extends AbstractDAO<Abonent> {
    int CalculateBalance (Abonent abonent, Date date);
    public int CalculateDabts(Abonent abonent, Date date);
}

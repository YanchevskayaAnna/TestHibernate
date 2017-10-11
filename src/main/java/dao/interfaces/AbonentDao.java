package dao.interfaces;

import model.Abonent;

import java.time.LocalDate;

public interface AbonentDao extends AbstractDAO<Abonent> {
    int CalculateBalance(Abonent abonent, LocalDate date);

    public int CalculateDebts(Abonent abonent, LocalDate date);
}

import dao.AbonentDao;
import dao.AbstractDAO;
import model.Abonent;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import service.AbonentController;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;


public class TestAbonent {

    private static AbonentController abonentController;
    private static EntityManagerFactory emFactory;

    @BeforeClass
    public static void beforeClass() throws IOException {

        emFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        abonentController = new AbonentController(new AbonentDao(emFactory));
    }

    @AfterClass
    public static void afterClass()  {
        emFactory.close();
    }

    @Test
    public void getAllAbonents() {
        List<Abonent> abonentList = abonentController.getAllAbonents();
        Assert.assertNotNull(abonentList);
    }

    @Test
    public void getAbonentByID() {
        Abonent abonent = abonentController.getAbonentById(1);
        Assert.assertNotNull(abonent);
    }


    @Test
    public void deleteAbonent() {

        Abonent testAbonent = new Abonent();
        testAbonent.setName("test abonent");
//        abonentController.createAbonent(testAbonent);

        Abonent deleteAbonent = abonentController.getAbonentById(3);
        abonentController.deleteAbonent(deleteAbonent);

        Assert.assertFalse(abonentController.getAllAbonents().contains(testAbonent));

    }

    @Test
    public void createAbonent() {

        Abonent abonent = new Abonent();
        abonent.setName("Test2390");

        Assert.assertTrue(abonentController.createAbonent(abonent));
        abonentController.deleteAbonent(abonent);
    }



}

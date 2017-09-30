import dao.*;
import model.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import service.AbonentController;
import service.ServiceAbonentController;
import service.ServiceController;
import service.UserController;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class TestAbonent {

    private static AbonentController abonentController;
    private static ServiceController serviceController;
    private static UserController userController;
    private static ServiceAbonentController serviceAbonentController;
    private static EntityManagerFactory emFactory;

    @BeforeClass
    public static void beforeClass() throws IOException {

        emFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        abonentController = new AbonentController(new AbonentDao(emFactory));
        serviceController = new ServiceController(new ServiceDao(emFactory));
        userController = new UserController(new UserDao(emFactory));
        serviceAbonentController = new ServiceAbonentController(new ServiceAbonentDao(emFactory));
        initDB();
    }

    public static void initDB(){
        List<Service> serviceList = new ArrayList<>(Arrays.asList(
                new Service("Call", 100),
                new Service("Inet", 50),
                new Service("Call&Inet", 110)));

        serviceList.stream().forEach(service -> {
            serviceController.createService(service);
        });

        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("user1", "1qaz2wsx3edc", UserType.USER),
                new User("user2", "1qaz2wsx3edc", UserType.USER),
                new User("admin", "1qaz2wsx3edc", UserType.ADMIN)));

        userList.stream().forEach(user -> {
            Abonent abonent = new Abonent("abonent_" + user.getLogin(), user);
            abonentController.createAbonent(abonent);
            serviceList.stream().forEach(service -> {
            ServiceAbonent serviceAbonent = new ServiceAbonent(service, abonent, new Date(55555), null);
            serviceAbonentController.createServiceAbonent(serviceAbonent);});
        });
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

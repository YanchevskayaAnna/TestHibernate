import dao.*;
import model.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import service.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.*;

public class TestAbonent {

    private static AbonentController abonentController;
    private static ServiceController serviceController;
    private static UserController userController;
    private static ServiceAbonentController serviceAbonentController;
    private static CallController callController;
    private static PaymentController paymentController;
    private static EntityManagerFactory emFactory;

    @BeforeClass
    public static void beforeClass() throws IOException {

        emFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        abonentController = new AbonentController(new AbonentDao(emFactory));
        serviceController = new ServiceController(new ServiceDao(emFactory));
        userController = new UserController(new UserDao(emFactory));
        serviceAbonentController = new ServiceAbonentController(new ServiceAbonentDao(emFactory));
        callController = new CallController(new CallDao(emFactory));
        paymentController = new PaymentController(new PaymentDao(emFactory));
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
            userController.createUser(user);
            //Abonent
            Abonent abonent = new Abonent("abonent_" + user.getLogin(), user);
            abonentController.createAbonent(abonent);

            //Calls
            Call call1 = new Call(abonent, CallType.IN, "+380672173946", 32, new Date(5000));
            callController.createCall(call1);
            Call call2 = new Call(abonent, CallType.OUT, "+380672173946", 32, new Date(5000));
            callController.createCall(call2);

            //Payments
            Payment payment1 = new Payment(abonent, new Date(90000), 100);
            paymentController.createPayment(payment1);

            Payment payment2 = new Payment(abonent, new Date(10000), 100);
            paymentController.createPayment(payment2);

            //Servises
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
    public void getAverageDuration() {
        Map<Abonent, Integer> averageDuration = callController.getAverageDuration();
        Assert.assertNotNull(averageDuration);
    }

    @Test
    public void getAverageDurationUser() {
        Map<User, Integer> averageDuration = callController.getAverageDurationUser();
        Assert.assertNotNull(averageDuration);
    }

    @Test
    public void getAverageDurationDate() {
        Map<Abonent, Integer> averageDuration = callController.getAverageDuration(new Date(1000), new Date(6000));
        Assert.assertNotNull(averageDuration);
    }

    @Test
    public void getAverageDurationUserDate() {
        Map<User, Integer> averageDuration = callController.getAverageDurationUser(new Date(1000), new Date(6000));
        Assert.assertNotNull(averageDuration);
    }

    @Test
    public void getAverageDurationAbonent() {
//     User user = new User("user1", "1qaz2wsx3edc", UserType.USER);
//     user.setid(????) Метода нет!!!
//     Abonent abonent = new Abonent("abonent_user1", user)
//     int averageDuration = callController.getAverageDuration(abonent);
//     Assert.assertNotNull(averageDuration);
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

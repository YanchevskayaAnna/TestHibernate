package integration;

import dao.SQLDao.*;
import model.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import service.*;
import service.interfaces.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.*;

public class TestAll {

    private static AbonentService abonentService;
    private static ServiceService serviceService;
    private static UserService userService;
    private static ServiceAbonentService serviceAbonentService;
    private static CallService callService;
    private static PaymentService paymentService;
    private static EntityManagerFactory emFactory;

    @BeforeClass
    public static void beforeClass() throws IOException {

        emFactory = Persistence.createEntityManagerFactory("hibernate-unit");
        abonentService = new AbonentServiceImpl(new SQLAbonentDaoImpl(emFactory));
        serviceService = new ServiceServiceImpl(new SQLServiceDaoImpl(emFactory));
        userService = new UserServiceImpl(new SQLUserDaoImpl(emFactory));
        serviceAbonentService = new ServiceAbonentServiceImpl(new SQLServiceAbonentDaoImpl(emFactory));
        callService = new CallServiceImpl(new SQLCallDaoImpl(emFactory));
        paymentService = new PaymentServiceImpl(new SQLPaymentDaoImpl(emFactory));
        initDB();
    }

    public static void initDB(){

        List<Service> serviceList = new ArrayList<>(Arrays.asList(
                new Service("Call", 100),
                new Service("Inet", 50),
                new Service("Call&Inet", 110)));

        serviceList.stream().forEach(service -> {
            serviceService.createService(service);
        });

        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("user1", "1qaz2wsx3edc", UserType.USER),
                new User("user2", "1qaz2wsx3edc", UserType.USER),
                new User("admin", "1qaz2wsx3edc", UserType.ADMIN)));

        userList.stream().forEach(user -> {
            userService.createUser(user);
            //Abonent
            Abonent abonent = new Abonent("abonent_" + user.getLogin(), user);
            abonentService.createAbonent(abonent);

            //Calls
            Call call1 = new Call(abonent, CallType.IN, "+380672173946", 32, new Date(5000));
            callService.createCall(call1);
            Call call2 = new Call(abonent, CallType.OUT, "+380672173946", 32, new Date(5000));
            callService.createCall(call2);

            //Payments
            Payment payment1 = new Payment(abonent, new Date(90000), 100);
            paymentService.createPayment(payment1);

            Payment payment2 = new Payment(abonent, new Date(10000), 100);
            paymentService.createPayment(payment2);

            //Servises
            serviceList.stream().forEach(service -> {
            ServiceAbonent serviceAbonent = new ServiceAbonent(service, abonent, new Date(55555), null);
            serviceAbonentService.createServiceAbonent(serviceAbonent);});

        });
    }

    @AfterClass
    public static void afterClass()  {
        emFactory.close();
    }

    @Test
    public void getAllAbonents() {
        List<Abonent> abonentList = abonentService.getAllAbonents();
        Assert.assertNotNull(abonentList);
    }

    @Test
    public void getAveragePayment() {
        Map<User, Integer> averagePayment = paymentService.getAveragePayment();
        Assert.assertNotNull(averagePayment);
    }

    @Test
    public void getAllPayments() {
        Double allPayment = paymentService.getAllPayments(new Date(1000), new Date(15000));
        Assert.assertNotNull(allPayment);
    }

    @Test
    public void getAverageDurationAbonent() {
       EntityManager em = emFactory.createEntityManager();
       Abonent abonent =  em.find(Abonent.class, 1);
       Double averageDuration = callService.getAverageDuration(abonent);
       Assert.assertNotNull(averageDuration);
    }

    @Test
    public void getAverageDurationAbonentDate() {
        EntityManager em = emFactory.createEntityManager();
        Abonent abonent =  em.find(Abonent.class, 1);
        Double averageDuration = callService.getAverageDuration(abonent, new Date(1000), new Date(6000));
        Assert.assertNotNull(averageDuration);
    }

    @Test
    public void getAverageDuration() {
        Map<Abonent, Integer> averageDuration = callService.getAverageDuration();
        Assert.assertNotNull(averageDuration);
    }

    @Test
    public void getAverageDurationDate() {
        Map<Abonent, Integer> averageDuration = callService.getAverageDuration(new Date(1000), new Date(6000));
        Assert.assertNotNull(averageDuration);
    }

    @Test
    public void getAverageDurationUser() {
        Map<User, Integer> averageDuration = callService.getAverageDurationUser();
        Assert.assertNotNull(averageDuration);
    }

    @Test
    public void getAverageDurationUserDate() {
        Map<User, Integer> averageDuration = callService.getAverageDurationUser(new Date(1000), new Date(6000));
        Assert.assertNotNull(averageDuration);
    }

    @Test
    public void getAbonentByID() {
        Abonent abonent = abonentService.getAbonentById(1);
        Assert.assertNotNull(abonent);
    }


    @Test
    public void deleteAbonent() {

        Abonent testAbonent = new Abonent();
        testAbonent.setName("test abonent");
        abonentService.createAbonent(testAbonent);

        Abonent deleteAbonent = abonentService.getAbonentById(4);
        abonentService.deleteAbonent(deleteAbonent);

        Assert.assertFalse(abonentService.getAllAbonents().contains(testAbonent));

    }

    @Test
    public void createAbonent() {

        Abonent abonent = new Abonent();
        abonent.setName("Test2390");

        Assert.assertTrue(abonentService.createAbonent(abonent));
        abonentService.deleteAbonent(abonent);
    }
}

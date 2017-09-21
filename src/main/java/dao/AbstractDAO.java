package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by IT-Univer004 on 21.09.2017.
 */
public class AbstractDAO<E> {

    private Class<E> entityClass;
    private String nameClass = entityClass.getSimpleName();
    private EntityManagerFactory factory;
    private static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    public AbstractDAO(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public List<E> getAll() {
        EntityManager em = factory.createEntityManager();
        TypedQuery<E> namedQuery = em.createNamedQuery(nameClass + ".getAll", entityClass);
        return namedQuery.getResultList();
    }

    E getEntityById(Integer id){
        EntityManager em = factory.createEntityManager();
        return em.find(entityClass, id);
    }

    boolean update(E entity){

        LOGGER.info("update " + entityClass.getSimpleName());

        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(entity);
            transaction.commit();
            LOGGER.info(nameClass + " was saved");
        } catch (Exception e) {
            LOGGER.error(nameClass + " was not saved", e);
            transaction.rollback();
        } finally {
            em.close();
        }

        return true;

    }

    boolean create(E entity){

        LOGGER.info("create new " + nameClass);

        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.merge(entity);
            transaction.commit();
            LOGGER.info(nameClass + " was saved");
        } catch (Exception e) {
            LOGGER.error(nameClass + " was not saved", e);
            transaction.rollback();
        } finally {
            em.close();
        }

        return true;

    }

    boolean delete(E entity){

        LOGGER.info("delete " + nameClass);
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        Class<E> group = em.find(entityClass, entity.getId());

        try {
            transaction.begin();
            em.remove(group);
            transaction.commit();
            LOGGER.info(nameClass + " was deleted");
        } catch (Exception e) {
            LOGGER.error(nameClass + " was not deleted", e);
            transaction.rollback();
        } finally {
            em.close();
        }
        return true;

    }


}

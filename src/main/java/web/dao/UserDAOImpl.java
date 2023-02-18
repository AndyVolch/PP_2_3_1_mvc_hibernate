package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    private final EntityManagerFactory emf;
    @Autowired
    public UserDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = emf.createEntityManager();
        List<User> userList = entityManager.createQuery("from User ",
                User.class).getResultList();
        return userList;
    }

    @Override
    public void addUser(User user) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(user);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            entityManager.close();
        }
    }

    @Override
    public User getUserById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUserById(int id) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(entityManager.getReference(User.class, id));
            transaction.commit();
        } catch (RuntimeException e) {
            System.out.println("Ошибка транзакции: " + e);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            entityManager.close();
        }
    }
}

package com.calculationservice.DAO;

import com.calculationservice.utils.HibernateSessionFactoryUtil;
import com.calculationservice.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;
import java.util.List;

public class UsersDAOImpl implements UsersDAO {
    @Override
    public void addUser(User user) {
        //remove getting session factory to the service and provide method with session factory as argument
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    @Override
    public User getUserById(int users_id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        User user = session.get(User.class, users_id);
        session.close();
        return user;
    }

    @Override
    public Collection getAllUsers() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaQuery<User> criteriaQuery = session.getCriteriaBuilder().createQuery(User.class);
        criteriaQuery.from(User.class);
        List<User> users = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return users;
    }

    @Override
    public void deleteUser(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
}

package com.calculationservice.DAO;

import com.calculationservice.models.Calculation;
import com.calculationservice.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;
import java.util.List;

public class CalculationsDAOImpl implements CalculationsDAO {
    @Override
    public void addCalculation(Calculation calculation) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(calculation);
        tx1.commit();
        session.close();
    }

    @Override
    public void updateCalculation(Calculation calculation) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(calculation);
        tx1.commit();
        session.close();
    }

    @Override
    public Calculation getCalculationById(int calculations_id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Calculation calculation = session.get(Calculation.class, calculations_id);
        session.close();
        return calculation;
    }

    @Override
    public Collection<Calculation> getAllCalculations() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaQuery<Calculation> criteriaQuery = session.getCriteriaBuilder().createQuery(Calculation.class);
        criteriaQuery.from(Calculation.class);
        List<Calculation> calculations = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return calculations;
    }

    @Override
    public Collection<Calculation> getAllCalculationsByUserId(int users_id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Collection<Calculation> list = session.createSQLQuery("select c.* from calculations as c where c.users_users_id="+users_id+"")
                .addEntity(Calculation.class)
                .list();
        session.close();
        return list;
    }

    @Override
    public void deleteCalculation(Calculation calculation) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(calculation);
        tx1.commit();
        session.close();
    }
}

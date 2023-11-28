package com.example.nguyengiahy20008341labweektuan2.repositories;

import com.example.nguyengiahy20008341labweektuan2.factory.MysessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

public class GenericCRUD <T>
{
    protected SessionFactory sessionFactory;

    public GenericCRUD() {
        this.sessionFactory = MysessionFactory.getInstance().getSessionFactory();
    }

    public boolean insert(T t) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.persist(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
//            logger.error(e.getMessage());
            transaction.rollback();
        }
        return false;
    }
    public boolean update(T t) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
//            logger.error(e.getMessage());
            transaction.rollback();
        }
        return false;
    }
    public Optional<T> findByID(Class<T> clazz, Object id) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        T t = session.find(clazz, id);
        transaction.commit();
        return t == null ? Optional.empty() : Optional.of(t);
    }
}

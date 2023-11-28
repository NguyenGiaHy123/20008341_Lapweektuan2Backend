package com.example.nguyengiahy20008341labweektuan2.repositories;

import com.example.nguyengiahy20008341labweektuan2.factory.MysessionFactory;
import com.example.nguyengiahy20008341labweektuan2.models.Customer;
import com.example.nguyengiahy20008341labweektuan2.models.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomerResporsitory extends GenericCRUD<Customer> {
    private SessionFactory sessionFactory;

    public CustomerResporsitory(){
        this.sessionFactory= MysessionFactory.getInstance().getSessionFactory();}


    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public List<Customer> getAll(){
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<Customer> employees = session.createNamedQuery("Customer.findAll", Customer.class).getResultList();
        transaction.commit();
        return employees;
    }

    public Customer getCustomerByNameAndPassword(String name, String password){
        Transaction tr=null;
        try(Session ss=sessionFactory.openSession()){
            tr = ss.beginTransaction();
            String sql = "SELECT * FROM customers AS e JOIN users AS u ON e.user = u.id_user WHERE NAME = :name AND PASSWORD = :password";
            List<Object[]> list = ss.createNativeQuery(sql, Object[].class)
                    .setParameter("name", name)
                    .setParameter("password", password)
                    .getResultList();System.out.println("demo");
            Customer e=findByID(Customer.class,list.get(0)).get();
            tr.commit();
            return e;
        }
        catch (Exception ex){
            tr.rollback();
        }
        return null;
    }

    public List<Order> getOrdersByCustomerID(long custID) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Order where customer.id = :custid");
        query.setParameter("custid",custID);
        List<Order> list = query.getResultList();
        transaction.commit();
        return list;
    }
}

package com.example.nguyengiahy20008341labweektuan2.repositories;

import com.example.nguyengiahy20008341labweektuan2.factory.MysessionFactory;
import com.example.nguyengiahy20008341labweektuan2.models.Employee;
import com.example.nguyengiahy20008341labweektuan2.models.Order;
import com.example.nguyengiahy20008341labweektuan2.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderRespository extends  GenericCRUD<Order> {
    private SessionFactory sessionFactory;

    public OrderRespository(){
        this.sessionFactory=this.sessionFactory= MysessionFactory.getInstance().getSessionFactory();}

    public List<Order> getAllOrders() {

        Transaction tr = null;
        List<Order> orders = null;
        try (Session ss = sessionFactory.openSession()) {
            tr = ss.beginTransaction();
            orders = ss.createNativeQuery("select * from orders ", Order.class).getResultList();
            System.out.println(orders);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace(); // Log the exception for debugging
        }
        return orders;
    }
    public List<Order> getAllOrdersByDate(Date date) {
        Transaction tr = null;
        try (Session session = sessionFactory.openSession()){
            tr = session.beginTransaction();
            String sql = "SELECT * from orders WHERE order_date LIKE '"+date+"%'";
            List<Object[]> list = session.createNativeQuery(sql, Object[].class).getResultList();
            List<Order> orders = new ArrayList<>();
            for(int i=0;i<list.size();i++){
                orders.add(findByID(Order.class,list.get(i)).get());
            }
            tr.commit();
            return orders;
        } catch (Exception e) {
            tr.rollback();
        }
        return null;
    }

    public List<Order> getAllOrderToDateFrom(Date fromDate,Date toDate){
        Transaction tr=null;


        try (Session session = sessionFactory.openSession()){
            tr = session.beginTransaction();
            String sql = "SELECT * FROM orders WHERE order_date BETWEEN '"+fromDate+"%' and '"+toDate+"%'";
            List<Object[]> list=session.createNativeQuery(sql,Object[].class).getResultList();
            List<Order> orders=new ArrayList<>();
            for(int i=0; i<list.size();i++){
               orders.add(findByID(Order.class,list.get(i)).get());
            }
            return orders;


    }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Order> OderSaleByEmp(long idEmp) {
        Transaction tr = null;
        try (Session session = sessionFactory.openSession()) {
            tr = session.beginTransaction();
            String sql = "SELECT * FROM orders  o JOIN employees e ON o.emp_id =e.emp_id WHERE e.emp_id='" + idEmp + "'";
            List<Object[]> listOrderObject = session.createNativeQuery(sql, Object[].class).getResultList();
            List<Order> orders = new ArrayList<>();
            for (Object or : listOrderObject
            ) {
                orders.add(findByID(Order.class, or).get());
            }
            return orders;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}





package com.example.nguyengiahy20008341labweektuan2.repositories;

import com.example.nguyengiahy20008341labweektuan2.factory.MysessionFactory;
import com.example.nguyengiahy20008341labweektuan2.models.Employee;
import com.example.nguyengiahy20008341labweektuan2.models.IEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmployeeRespository extends GenericCRUD<Employee> {
    private SessionFactory sessionFactory;

    public EmployeeRespository(){
        this.sessionFactory=this.sessionFactory= MysessionFactory.getInstance().getSessionFactory();}


    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public List<Employee> getAll(){
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        List<Employee> employees = session.createNamedQuery("Employee.findAll", Employee.class)

                .getResultList();
        transaction.commit();
        return employees;
    }

    public boolean InsertEmployee(Employee e){
        Transaction tr=null;
        try(Session ss=sessionFactory.openSession()){
            tr=ss.beginTransaction();
           ss.persist(e);
           tr.commit();
           return true;
        }
        catch (Exception ex){
            tr.rollback();
            ex.printStackTrace();

        }
        return false;
    }

    public  Employee getEmployeeByNameAndPassword(String name,String password){
        Transaction tr=null;

        try(Session ss=sessionFactory.openSession()){
            tr = ss.beginTransaction();
            String sql = "SELECT * FROM employees AS e JOIN users AS u ON e.user = u.id_user WHERE NAME = :name AND PASSWORD = :password";
//

                        List<Object[]> list = ss.createNativeQuery(sql, Object[].class)
                    .setParameter("name", name)
                    .setParameter("password", password)
                    .getResultList();System.out.println("demo");
                        Employee e=findByID(Employee.class,list.get(0)).get();
            tr.commit();
            return e;
        }
        catch (Exception ex){

            logger.error(ex.getMessage());
            tr.rollback();
        }
         return null;

    }
}

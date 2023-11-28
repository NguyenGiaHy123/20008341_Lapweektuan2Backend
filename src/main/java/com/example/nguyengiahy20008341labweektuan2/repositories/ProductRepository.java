package com.example.nguyengiahy20008341labweektuan2.repositories;

import com.example.nguyengiahy20008341labweektuan2.factory.MysessionFactory;
import com.example.nguyengiahy20008341labweektuan2.models.Customer;
import com.example.nguyengiahy20008341labweektuan2.models.Employee;
import com.example.nguyengiahy20008341labweektuan2.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepository extends  GenericCRUD<Product>{
    private SessionFactory sessionFactory;

    public ProductRepository(){
        this.sessionFactory=this.sessionFactory= MysessionFactory.getInstance().getSessionFactory();}

    public List<Product> getAllProduct() {
        Transaction tr = null;
        List<Product> customers = null;
        try (Session ss = sessionFactory.openSession()) {
            tr = ss.beginTransaction();
            customers = ss.createNativeQuery("select * from products ", Product.class).getResultList();
            System.out.println(customers);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace(); // Log the exception for debugging
        }
        return customers;
    }

    public List<Product> getProductsByKeyword(String keyword) {
        Transaction tr = null;
        try (Session session = sessionFactory.openSession()){
            tr = session.beginTransaction();
            String sql = "SELECT * from products WHERE NAME LIKE '%"+keyword+"%'";
            List<Object[]> list = session.createNativeQuery(sql, Object[].class).getResultList();

            List<Product> products = new ArrayList<>();
            for(int i=0;i<list.size();i++){
                products.add(findByID(Product.class,list.get(i)).get());
            }
            tr.commit();
            return products;
        } catch (Exception e) {
            // TODO: handle exception

            tr.rollback();
        }
        return null;
    }

    public List<Product> getProductByPriceNewst(){

        Transaction tr = null;
        try (Session session = sessionFactory.openSession()) {
            tr = session.beginTransaction();
            String sql = "SELECT p.product_id, p.name, pr.price, pr.price_date_time FROM products p JOIN ( SELECT product_id, MAX(price_date_time) as latest_time FROM product_prices GROUP BY product_id) pr_max ON p.product_id = pr_max.product_id JOIN product_prices pr ON pr.product_id = pr_max.product_id AND pr.price_date_time = pr_max.latest_time";

            List<Object[]> list = session.createNativeQuery(sql, Object[].class).getResultList();
            System.out.println(list);
            List<Product> products = new ArrayList<>();
            for(int i=0;i<list.size();i++){
                products.add(findByID(Product.class,list.get(i)).get());
            }
            return products;
        }
        catch (Exception e) {
            tr.rollback();
        }
        return null;
    }
}

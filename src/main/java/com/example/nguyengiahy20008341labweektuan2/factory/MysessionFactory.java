package com.example.nguyengiahy20008341labweektuan2.factory;

import com.example.nguyengiahy20008341labweektuan2.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class MysessionFactory {
    private static MysessionFactory instance;
    private SessionFactory sessionFactory;

    private MysessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(ProductImage.class)
                .addAnnotatedClass(ProductPrice.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(OrderDetail.class)
                .getMetadataBuilder().build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
    public static MysessionFactory getInstance() {
        if(instance == null)
            instance = new MysessionFactory();
        return instance;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}


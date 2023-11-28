package com.example.nguyengiahy20008341labweektuan2.services;

import com.example.nguyengiahy20008341labweektuan2.models.Order;
import com.example.nguyengiahy20008341labweektuan2.repositories.OrderRespository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class OrderService {
    public OrderRespository orderRespository;
    public OrderService(){
        this.orderRespository=new OrderRespository();
    }
    public List<Order> getAllOrder(){
        return orderRespository.getAllOrders();
    }

    public List<Order> getOrderByDate(Date date){
        return orderRespository.getAllOrdersByDate(date);
    }

    public List<Order> getAllOrderToDateFrom(Date fromdate,Date todate){
        return orderRespository.getAllOrderToDateFrom(fromdate,todate);
    }

    public boolean updateOrder(Order order){
        return orderRespository.update(order);
    }

    public Optional<Order> getOrderById(long id){
        return orderRespository.findByID(Order.class,id);
    }

    public  boolean insertOrder(Order order){
        return orderRespository.insert(order);
    }





    public List<Order> getOderSaleByEmp(long idEmp){
        return orderRespository.OderSaleByEmp(idEmp);
    }
}

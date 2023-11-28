package com.example.nguyengiahy20008341labweektuan2.services;

import com.example.nguyengiahy20008341labweektuan2.models.Customer;
import com.example.nguyengiahy20008341labweektuan2.models.Order;
import com.example.nguyengiahy20008341labweektuan2.repositories.CustomerResporsitory;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    public CustomerResporsitory customerResporsitory;
    public CustomerService(){
        this.customerResporsitory=new CustomerResporsitory();
    }
    public List<Customer> getAllCustomer(){
        return customerResporsitory.getAll();
    }

    public Customer getCustomerByNameAndPassword(String name,String password){
        return customerResporsitory.getCustomerByNameAndPassword( name, password);
    }

    public boolean insertCustomer(Customer c){
        return customerResporsitory.insert(c);
    }

    public List<Order> getCustByOrer(long custID){
        return customerResporsitory.getOrdersByCustomerID(custID);
    }
    public Optional<Customer> getCustomerById(long id){
        return customerResporsitory.findByID(Customer.class,id);
    }

}

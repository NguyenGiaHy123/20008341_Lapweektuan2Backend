package com.example.nguyengiahy20008341labweektuan2;

import com.example.nguyengiahy20008341labweektuan2.factory.MysessionFactory;
import com.example.nguyengiahy20008341labweektuan2.models.*;
import com.example.nguyengiahy20008341labweektuan2.repositories.*;

import java.util.List;

public class App {
    public static void main(String[] args) {
     MysessionFactory.getInstance();
//       EmployeeRespository employeeRepository = new EmployeeRespository();
//        CustomerResporsitory c=new CustomerResporsitory();
//        ProductRepository productRepository=new ProductRepository();
//        OrderRespository order=new OrderRespository();
      CustomerResporsitory cus=new CustomerResporsitory();
//     boolean employinsert=employeeRepository.insert(new Employee("hyhocbai",LocalDateTime.now(),"giahy23@gmail.com","0493903939","124@sdfa",IEmployee.ACTIVE));
//        if(employinsert==true){
//            System.out.println("insert thanh cong");
//        }
//        List<Employee> employees = employeeRepository.getAll();
//
//
//       employees.forEach(System.out::println);

//     List<Customer> customers=c.getAll();
//        customers.forEach(System.out::println)
         List<Customer> cuss=cus.getAll();
        cuss.forEach(System.out::println);
}
}

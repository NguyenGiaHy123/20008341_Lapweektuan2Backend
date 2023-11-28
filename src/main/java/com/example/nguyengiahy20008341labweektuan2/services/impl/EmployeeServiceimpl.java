package com.example.nguyengiahy20008341labweektuan2.services.impl;

import com.example.nguyengiahy20008341labweektuan2.models.Employee;
import com.example.nguyengiahy20008341labweektuan2.repositories.EmployeeRespository;
import com.example.nguyengiahy20008341labweektuan2.services.EmployeeService;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceimpl implements EmployeeService {
    private EmployeeRespository employeeRespository;

    public EmployeeServiceimpl() {
        employeeRespository=new EmployeeRespository();
    }

    @Override
    public boolean insert(Employee employee) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    public boolean activeEmployee(long id) {
        return false;
    }

    @Override
    public Optional<Employee> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> getAll() {
        return  employeeRespository.getAll();
    }

    @Override
    public List<Employee> getEmployeeByUsernameAndPassword(String username, String passowrd) {
        return null;
    }
}

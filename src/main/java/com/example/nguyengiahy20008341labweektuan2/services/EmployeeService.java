package com.example.nguyengiahy20008341labweektuan2.services;

import com.example.nguyengiahy20008341labweektuan2.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public boolean insert(Employee employee);
    public boolean delete(long id);
    public boolean update(Employee employee);
    public boolean activeEmployee(long id);
    public Optional<Employee> findById(long id);
    public List<Employee> getAll();

    public List<Employee> getEmployeeByUsernameAndPassword(String username,String passowrd);
}

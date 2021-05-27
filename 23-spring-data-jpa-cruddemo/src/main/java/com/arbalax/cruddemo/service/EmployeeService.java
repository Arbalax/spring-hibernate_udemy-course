package com.arbalax.cruddemo.service;

import com.arbalax.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List <Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);

}

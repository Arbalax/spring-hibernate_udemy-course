package com.arbalax.springdemo.thymeleafdemo.service;


import com.arbalax.springdemo.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List <Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);

}

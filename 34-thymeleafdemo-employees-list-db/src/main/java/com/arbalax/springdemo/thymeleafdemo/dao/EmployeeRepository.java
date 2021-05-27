package com.arbalax.springdemo.thymeleafdemo.dao;


import com.arbalax.springdemo.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

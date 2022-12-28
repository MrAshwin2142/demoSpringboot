package com.newspring.demo1.reposetory;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.newspring.demo1.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
    public Optional<Employee> findById(int id);
}

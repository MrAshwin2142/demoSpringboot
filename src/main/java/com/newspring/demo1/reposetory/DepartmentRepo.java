package com.newspring.demo1.reposetory;

import org.springframework.data.repository.CrudRepository;

import com.newspring.demo1.entity.Department;

public interface DepartmentRepo extends CrudRepository<Department,Integer>{
    
}

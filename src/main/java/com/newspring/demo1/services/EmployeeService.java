package com.newspring.demo1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newspring.demo1.entity.Employee;
import com.newspring.demo1.reposetory.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    // add employee
    public Employee  saveEmployee(Employee e){
        employeeRepo.save(e);
        return e;
    }

    //get all employee
    public List<Employee> getAllEmployees(){
        return (List<Employee>) employeeRepo.findAll();
    }

    // get employee by id
    public Employee getEmployeeById(int id){
        Optional<Employee> e=employeeRepo.findById(id);
        if(e.isPresent()){
            return e.get();
        }else{
            return null;
        }
    }

    // update employee
    public Optional<Employee> updateEmployee(Employee e,int emp_id){
        Optional<Employee> temprary= employeeRepo.findById(emp_id);
        if(temprary.isPresent() ){
            e.setEmp_id(emp_id);
            employeeRepo.save(e);
            return employeeRepo.findById(emp_id);
        }
        return null;
    }

    //delete employee
    public void deleteEmployee(int id){
        employeeRepo.deleteById(id);
    }
}

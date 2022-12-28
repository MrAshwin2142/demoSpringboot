package com.newspring.demo1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newspring.demo1.entity.Employee;
import com.newspring.demo1.services.EmployeeService;

@RestController
public class EmployeeController {
   
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/emp")
    public ResponseEntity<Object> saveEmployee(@RequestBody Employee e){
        Employee temprarory=employeeService.saveEmployee(e);
        return new ResponseEntity<>(temprarory, HttpStatus.CREATED);
    }



    @GetMapping("/emp")
    public ResponseEntity<List<Employee>> bok(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/emp/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")  int id){
        Employee temp=employeeService.getEmployeeById(id);
        if(temp==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ResponseEntity<Employee> empResponseEntity = new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
        return empResponseEntity;
    }

    @PutMapping("emp/{eid}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e, @PathVariable("eid") int id){
        Optional<Employee> temp=employeeService.updateEmployee(e,id);
        if(temp.isPresent()){
            return ResponseEntity.of(Optional.of(temp.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
    }
}

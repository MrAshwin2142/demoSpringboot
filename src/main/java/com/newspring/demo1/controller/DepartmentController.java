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

import com.newspring.demo1.entity.Department;
import com.newspring.demo1.services.DepartmentService;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //get all departments
    @GetMapping("/dept")
    public List<Department> getDepartment(){
        return departmentService.getAllDepartments();
    }

    // get department by id
    @GetMapping("dept/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable("id") int id){
        return ResponseEntity.of(Optional.of(departmentService.getDepartmentById(id)));
    }

    // add department
    @PostMapping("/dept")
    public ResponseEntity<Department> addDepartment(@RequestBody Department d){
        return ResponseEntity.of(Optional.of(departmentService.addDepartment(d)));
    }

        //  update department 
    @PutMapping("/dept/{id}")        
    public ResponseEntity<Department> updateDepartment(@RequestBody Department d, @PathVariable("id") int id){
        Department temp=departmentService.updateDepartment(d,id);
        if(temp==null){
        return   ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return ResponseEntity.of(Optional.of(temp));
        }
    }
    // delete department by id
    @DeleteMapping("/dept")
    public ResponseEntity<String> deleteAllDepartment(){
        departmentService.deleteAllDepartment();
        return new ResponseEntity<>("All Department deleted successfully!", HttpStatus.OK);
    }
    // delete department by id
    @DeleteMapping("/Dept/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") int id){
        departmentService.deleteDepartmentbyId(id);
        return new ResponseEntity<>("Department deleted successfully!", HttpStatus.OK);
    }
}

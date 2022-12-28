package com.newspring.demo1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newspring.demo1.entity.Department;
import com.newspring.demo1.reposetory.DepartmentRepo;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    //get all departments
    public List<Department> getAllDepartments(){
        return (List<Department>) departmentRepo.findAll();
    }

    // get department by id
    public Department getDepartmentById(int id){
        Optional<Department>temp=departmentRepo.findById(id);
        if(temp.isPresent()){
            return temp.get();
        }else{
            return null;
        }
    }

    //add department 
    public Department addDepartment(Department dept){
        departmentRepo.save(dept);
        return dept;
    }

    //update deparrtment 
    public Department updateDepartment(Department dept,int id){
        Optional<Department> dept1=departmentRepo.findById(id);

        if(dept1.isPresent()) {
            dept.setDept_id(id);
            departmentRepo.save(dept);
            return dept;
        }
       return dept1.get();
    }

    // delete all
    public void deleteAllDepartment(){
        departmentRepo.deleteAll();
    }

    //delete by id
    public void deleteDepartmentbyId(int id){
        departmentRepo.deleteById(id);
    }







}

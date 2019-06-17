package com.crud.controllers;

import com.com.crud.sessions.DepartmentSession;
import com.crud.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentControlelr {

    @Autowired
    private DepartmentSession departmentSession;

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return departmentSession.findAll();
    }

    @GetMapping("/department/{id}")
    public Optional<Department> getDepartment(@PathVariable int id){
        return departmentSession.findById(id);
    }

    @DeleteMapping("/department/{id}")
    public void deleteDepartment(@PathVariable int id){
        departmentSession.delete(id);
    }

}

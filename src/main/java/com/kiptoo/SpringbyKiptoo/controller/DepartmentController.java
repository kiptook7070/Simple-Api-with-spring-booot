package com.kiptoo.SpringbyKiptoo.controller;

import com.kiptoo.SpringbyKiptoo.entity.Department;
import com.kiptoo.SpringbyKiptoo.service.DepartmentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v2/departments")
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentServiceInterface departmentServiceInterface;

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department) {
        return departmentServiceInterface.addDepartment(department);
    }

    @GetMapping("/all")
    public List<Department> getAllDepartments() {
        return departmentServiceInterface.getAllDepartments();
    }

    @GetMapping("/find/{id}")
    public Department findDepartmnetById(@PathVariable("id") Long departmentId) {
        return departmentServiceInterface.findDepartmnetById(departmentId);
    }

    @DeleteMapping("/delete{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentServiceInterface.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully";
    }

    @PutMapping("/update{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentServiceInterface.updateDepartment(departmentId, department);
    }
    @GetMapping("/get/department/name{name}")
    public Department getByDepartmentName(@PathVariable("name") String departmentName){
        return departmentServiceInterface.getByDepartmentName(departmentName);
    }

}

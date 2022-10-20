package com.kiptoo.SpringbyKiptoo.controller;

import com.kiptoo.SpringbyKiptoo.entity.Department;
import com.kiptoo.SpringbyKiptoo.error.DepartmentNotFoundException;
import com.kiptoo.SpringbyKiptoo.service.DepartmentServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v2/departments")
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentServiceInterface departmentServiceInterface;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/add")
    public Department addDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Department Added Successfully.");
        return departmentServiceInterface.addDepartment(department);
    }

    @GetMapping("/all")
    public List<Department> getAllDepartments() {
        return departmentServiceInterface.getAllDepartments();
    }

    @GetMapping("/find/{id}")
    public Department findDepartmnetById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
//        LOGGER.info("Department with ID Found.");
        return departmentServiceInterface.findDepartmnetById(departmentId);
    }

    @DeleteMapping("/delete{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentServiceInterface.deleteDepartmentById(departmentId);
        LOGGER.info("Department Deleted Successfully.");
        return "Department Deleted Successfully";
    }

    @PutMapping("/update{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        LOGGER.info("Department Details Updated Successfully.");
        return departmentServiceInterface.updateDepartment(departmentId, department);
    }
    @GetMapping("/get/department/name{name}")
    public Department getByDepartmentName(@PathVariable("name") String departmentName){
        return departmentServiceInterface.getByDepartmentName(departmentName);
    }

}

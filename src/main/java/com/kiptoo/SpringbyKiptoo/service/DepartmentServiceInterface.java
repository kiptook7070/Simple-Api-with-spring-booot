package com.kiptoo.SpringbyKiptoo.service;

import com.kiptoo.SpringbyKiptoo.entity.Department;
import com.kiptoo.SpringbyKiptoo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentServiceInterface {
    Department addDepartment(Department department);

    List<Department> getAllDepartments();

    Department findDepartmnetById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department getByDepartmentName(String departmentName);

}

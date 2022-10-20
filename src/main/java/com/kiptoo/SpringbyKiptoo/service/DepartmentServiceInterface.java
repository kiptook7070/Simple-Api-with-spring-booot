package com.kiptoo.SpringbyKiptoo.service;

import com.kiptoo.SpringbyKiptoo.entity.Department;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DepartmentServiceInterface {
   public Department addDepartment(Department department);

 public List<Department> getAllDepartments();

    public Department findDepartmnetById(Long departmentId);

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

  public Department getByDepartmentName(String departmentName);

}

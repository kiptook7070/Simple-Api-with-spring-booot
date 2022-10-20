package com.kiptoo.SpringbyKiptoo.service;

import com.kiptoo.SpringbyKiptoo.entity.Department;
import com.kiptoo.SpringbyKiptoo.repository.DepartmentRepositoryInterface;
import com.kiptoo.SpringbyKiptoo.service.DepartmentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImplementation implements DepartmentServiceInterface {
   @Autowired
    private DepartmentRepositoryInterface departmentRepositoryInterface;
    @Override
    public Department addDepartment(Department department) {
        return departmentRepositoryInterface.save(department);

    }
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepositoryInterface.findAll();
    }
    @Override
    public Department findDepartmnetById(Long departmentId) {
        return departmentRepositoryInterface.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepositoryInterface.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
       Department departmentFound = departmentRepositoryInterface.findById(departmentId).get();
       if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
           departmentFound.setDepartmentCode(department.getDepartmentCode());
       }
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            departmentFound.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentFound.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepositoryInterface.save(departmentFound);
    }

    @Override
    public Department getByDepartmentName(String departmentName) {
        return departmentRepositoryInterface.getByDepartmentNameIgnoreCase(departmentName);
    }

}

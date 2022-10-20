package com.kiptoo.SpringbyKiptoo.repository;

import com.kiptoo.SpringbyKiptoo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepositoryInterface extends JpaRepository<Department, Long> {
    public Department getByDepartmentName(String departmentName);
    public Department getByDepartmentNameIgnoreCase(String departmentName);
}

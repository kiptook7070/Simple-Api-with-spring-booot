package com.kiptoo.SpringbyKiptoo.employee;

import com.kiptoo.SpringbyKiptoo.entity.Department;
import com.kiptoo.SpringbyKiptoo.exception.DataNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);


    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        try {
            Employee saveEmployee = employeeRepo.save(employee);
            LOGGER.info("EMPLOYEE SAVED SUCCESSFULLY!!");
            return saveEmployee;

        } catch (Exception exception) {
            LOGGER.info("CAN NOT SAVE EMPLOYEE!!" + exception);
            return null;
        }

    }

    public List<Employee> findAllEmployees() {
        try {
            LOGGER.info("EMPLOYEES RECORDS FOUND SUCCESSFULLY!!");
            return employeeRepo.findAll();

        } catch (Exception exception) {
            LOGGER.info("CAN NOT FIND EMPLOYEE RECORD!!" + exception);
            return null;
        }
    }

    public Employee findEmployeeById(Long empId) throws DataNotFoundException {
        try {
            Optional<Employee> optionalEmployee = employeeRepo.findById(empId);
            if (!optionalEmployee.isPresent()) {
                throw new DataNotFoundException("EMPLOYEE RECORD NOT FOUND");
            }
            return optionalEmployee.get();

        } catch (Exception exception) {
            return null;
        }
    }
    public Employee updateEmployee(Long empId, Employee employee) {
        try {
            Employee employeeFound = employeeRepo.findById(empId).get();
            if (Objects.nonNull(employee.getEmpCode()) && !"".equalsIgnoreCase(employee.getEmpCode())){
                employeeFound.setEmpCode(employee.getEmpCode());
            }
            if (Objects.nonNull(employee.getEmpName()) && !"".equalsIgnoreCase(employee.getEmpName())){
                employeeFound.setEmpName(employee.getEmpName());
            }
            LOGGER.info("EMPLOYEE RECORDS Updated Successfully.");
            return employeeRepo.save(employeeFound);
        } catch (Exception exception){
            LOGGER.info("CAN NOT UPDATE EMPLOYEE RECORD!!" + exception);
            return null;
        }

    }

    public void deleteEmployeeById(Long empId) {
        employeeRepo.deleteById(empId);
    }
}

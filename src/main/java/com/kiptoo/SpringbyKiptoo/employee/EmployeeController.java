package com.kiptoo.SpringbyKiptoo.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.zip.DataFormatException;

@RequestMapping("ap1/v1/employee")
@RestController
public class EmployeeController {
    public final EmployeeRepo employeeRepo;
    public final EmployeeService employeeService;
    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeRepo employeeRepo, EmployeeService employeeService) {
        this.employeeRepo = employeeRepo;
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        try {
            Employee employee1 = employeeService.addEmployee(employee);
            LOGGER.info("EMPLOYEE SAVED SUCCESSFULLY!!");
            return new ResponseEntity<>(employee1, HttpStatus.CREATED);
        } catch (Exception exception) {
            LOGGER.info("CAN NOT SAVE EMPLOYEE!!" + exception);
            return null;
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        try {
            List<Employee> employeeList = employeeService.findAllEmployees();
            LOGGER.info("EMPLOYEES RECORDS FOUND SUCCESSFULLY!!");
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        } catch (Exception exception) {
            LOGGER.info("CAN NOT FIND EMPLOYEE RECORD!!" + exception);
            return null;
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long empId) throws DataFormatException {
        try {
            Employee employee = employeeService.findEmployeeById(empId);
            LOGGER.info("EMPLOYEES RECORD FOUND SUCCESSFULLY!!");
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception exception) {
            LOGGER.info("CAN NOT FIND EMPLOYEE RECORD!!" + exception);
            return null;
        }
    }
    @PutMapping("/update{id}")
    public ResponseEntity<Employee>  updateEmployee(@PathVariable("id") Long empId,
                                   @RequestBody Employee employee) {
        try {
            LOGGER.info("EMPLOYEE RECORDS Updated Successfully.");
            return new ResponseEntity<>(employeeService.updateEmployee(empId, employee), HttpStatus.OK) ;
        } catch (Exception exception) {
            LOGGER.info("CAN NOT UPDATE EMPLOYEE RECORD!!" + exception);
            return null;
        }

    }

    @DeleteMapping("delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long empId) {
        employeeService.deleteEmployeeById(empId);
        LOGGER.info("EMPLOYEE RECORD Deleted Successfully.");
        return "EMPLOYEE RECORD Deleted Successfully";
    }
}

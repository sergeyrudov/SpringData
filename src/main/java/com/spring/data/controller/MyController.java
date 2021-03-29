package com.spring.data.controller;


import com.spring.data.entity.Employee;
import com.spring.data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    // return list of employees
    @GetMapping("/employees")
    public List<Employee> showAllCompanies() {
        return employeeService.getAllEmployees();
    }

    // return employee with id parameter
    @GetMapping("/employees/{id}")
    public Employee showEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    // save employee to DB
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    // edit employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    // delete employee from DB
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "Employee with id: " + id + " was successfully removed!";
    }

    // search by name
    @GetMapping("/employees/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name) {
        List<Employee> employees = employeeService.findAllByName(name);
        return employees;
    }
}


package com.barack.employeeservice.controller;

import com.barack.employeeservice.model.Employee;
import com.barack.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static  final Logger LOGGER =  LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeRepository repository;

    @PostMapping
    public Employee add(@RequestBody Employee Employee){
        LOGGER.info("Employee add: {}", Employee);
        return repository.addEmployee(Employee);
    }
    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("Employee findAll");
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        LOGGER.info("Employee find: id = {}", id);
        return repository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId){
        LOGGER.info("Employee find: departmentId = {}", departmentId);
        return repository.findByDepartment(departmentId);
    }
}

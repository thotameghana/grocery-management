package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.business.EmployeeService;
import com.project.model.Employees;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired private EmployeeService employeeService;
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(employeeService.login(email, password));
    }


    @PostMapping("/add")
    public ResponseEntity<Employees> addEmployee(@RequestBody Employees employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable Long id, @RequestBody Employees updatedEmployee) {

        return ResponseEntity.ok(employeeService.updateEmployee(id, updatedEmployee));
    }
}

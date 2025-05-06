package com.project.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.EmployeeRepository;
import com.project.model.Employees;

@Service
public class EmployeeService {
    @Autowired 
    private EmployeeRepository employeeRepo;
    
    public String login(String email, String password) {
        Employees employee = employeeRepo.findByEmail(email);
        if (employee == null || !employee.getPassword().equals(password)) {
            return "Invalid credentials";
        }
        return "Login successful";
    }


    public Employees addEmployee(Employees employee) {
        employee.setPassword("welcome123"); // Default password
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
    
    public Employees updateEmployee(Long id, Employees updatedEmployee) {
        Employees existing = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

        existing.setName(updatedEmployee.getName());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setPassword(updatedEmployee.getPassword()); 
        existing.setRole(updatedEmployee.getRole());

        return employeeRepo.save(existing);
    }
    
}

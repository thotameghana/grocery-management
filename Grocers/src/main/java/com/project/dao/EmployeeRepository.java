package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {
    Employees findByEmail(String email);
}

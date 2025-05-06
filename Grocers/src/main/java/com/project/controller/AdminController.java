package com.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.business.AdminService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")

public class AdminController {
    @Autowired 
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials, HttpSession session) {
        boolean isAuthenticated = adminService.authenticateAdmin(credentials.get("name"), credentials.get("password"));
        
        if (isAuthenticated) {
            session.setAttribute("admin", credentials.get("name"));
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}

package com.project.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.AdminRepository;
import com.project.model.Admin;


@Service
public class AdminService {
    @Autowired 
    private AdminRepository adminRepo;

    public boolean authenticateAdmin(String name, String password) {
        Admin admin = adminRepo.findByName(name);
        return admin != null && admin.getPassword().equals(password);
    }
}

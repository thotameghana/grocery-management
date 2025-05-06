package com.project.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

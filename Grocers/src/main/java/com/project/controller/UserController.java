package com.project.controller;


import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.business.UserService;
import com.project.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        return ResponseEntity.ok(userService.login(credentials.get("email"), credentials.get("password")));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProfile(@PathVariable Long id, @RequestBody User user) {
        userService.updateProfile(id, user);
        return ResponseEntity.ok("Profile updated successfully");
    }

    @PostMapping("/raise-ticket/{id}")
    public ResponseEntity<String> raiseTicket(@PathVariable Long id, @RequestParam String reason) {
        userService.raiseTicket(id, reason);
        return ResponseEntity.ok("Ticket raised successfully");
    }
}

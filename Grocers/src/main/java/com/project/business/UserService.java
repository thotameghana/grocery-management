package com.project.business;


import org.springframework.stereotype.Service;

import com.project.dao.UserRepository;
import com.project.model.User;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final TicketService ticketService;

    public UserService(UserRepository userRepository, TicketService ticketService) {
        this.userRepository = userRepository;
        this.ticketService = ticketService;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            return "Invalid credentials";
        }

        if (user.isLocked()) {
            return "Account locked. Please raise a ticket to unlock.";
        }

        user.setLoginAttempts(0); // Reset attempts after successful login
        userRepository.save(user);
        return "Login successful";
    }

    public void updateProfile(Long userId, User updatedUser) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setPhoneNo(updatedUser.getPhoneNo());
        user.setAddress(updatedUser.getAddress());
        user.setPassword(updatedUser.getPassword());
        userRepository.save(user);
    }

    public void raiseTicket(Long userId, String reason) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setLocked(true);
        userRepository.save(user);
        System.out.println("Ticket raised for user ID: " + userId + " - Reason: " + reason);
        
        ticketService.createTicket(userId, reason);
    }
}


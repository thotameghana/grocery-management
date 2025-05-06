package com.project.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.business.TicketService;
import com.project.model.Ticket;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/raise/{userId}")
    public ResponseEntity<Ticket> raiseTicket(@PathVariable Long userId, @RequestParam String issueDescription) {
        return ResponseEntity.ok(ticketService.raiseTicket(userId, issueDescription));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ticket>> getUserTickets(@PathVariable Long userId) {
        return ResponseEntity.ok(ticketService.getUserTickets(userId));
    }

    @PutMapping("/resolve/{ticketId}")
    public ResponseEntity<Ticket> resolveTicket(@PathVariable Long ticketId) {
        return ResponseEntity.ok(ticketService.resolveTicket(ticketId));
    }
}


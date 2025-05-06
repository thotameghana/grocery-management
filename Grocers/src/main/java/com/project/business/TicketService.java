package com.project.business;


import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dao.TicketRepository;
import com.project.dao.UserRepository;
import com.project.model.Ticket;
import com.project.model.User;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public TicketService(TicketRepository ticketRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    public Ticket raiseTicket(Long userId, String issueDescription) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Ticket ticket = new Ticket(user, issueDescription);
        return ticketRepository.save(ticket);
    }
    

    public List<Ticket> getUserTickets(Long userId) {
        return ticketRepository.findByUser_UserId(userId);
    }

    public Ticket resolveTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticket.resolve();
        return ticketRepository.save(ticket);
    }
    
    public void createTicket(Long userId, String issueDescription) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Ticket ticket = new Ticket(user, issueDescription);

        // ✅ Persist the ticket in the `tickets` table
        ticketRepository.save(ticket);
    }
}

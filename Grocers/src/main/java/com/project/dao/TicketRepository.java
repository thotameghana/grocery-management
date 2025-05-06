package com.project.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUser_UserId(Long userId);
}

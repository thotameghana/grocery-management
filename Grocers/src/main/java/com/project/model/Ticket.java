package com.project.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "issue_description", nullable = false, columnDefinition = "TEXT")
    private String issueDescription;

    @Column(name = "status", length = 30, nullable = false)
    private String status = "open";

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "resolved_at")
    private LocalDateTime resolvedAt;

    public Ticket() {}

    public Ticket(User user, String issueDescription) {
        this.user = user;
        this.issueDescription = issueDescription;
        this.createdAt = LocalDateTime.now();
        this.status = "open";
    }

    public void resolve() {
        this.status = "resolved";
        this.resolvedAt = LocalDateTime.now();
    }

    // Getters & Setters
}

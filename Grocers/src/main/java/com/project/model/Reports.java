package com.project.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reports {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long reportId;

    @Enumerated(EnumType.STRING)
    @Column(name = "report_type", nullable = false)
    private ReportType reportType;

    @ManyToOne
    @JoinColumn(name = "generated_by", nullable = false)
    private Employees generatedBy;

    @Column(name = "generated_at", nullable = false, updatable = false)
    private LocalDateTime generatedAt;

    public Reports() {
        this.generatedAt = LocalDateTime.now(); // Automatically set timestamp
    }

    public Reports(ReportType reportType, Employees generatedBy) {
        this.reportType = reportType;
        this.generatedBy = generatedBy;
        this.generatedAt = LocalDateTime.now();
    }

    public Long getReportId() {
        return reportId;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public Employees getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Employees generatedBy) {
        this.generatedBy = generatedBy;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }
}

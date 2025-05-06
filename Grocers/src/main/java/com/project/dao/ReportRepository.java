package com.project.dao;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.ReportType;
import com.project.model.Reports;

public interface ReportRepository extends JpaRepository<Reports, Long> {
    List<Reports> findAllByReportType(ReportType reportType);
    List<Reports> findAllByGeneratedAtBetween(LocalDateTime start, LocalDateTime end);
}

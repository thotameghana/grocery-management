package com.project.business;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dao.ReportRepository;
import com.project.model.Employees;
import com.project.model.ReportType;
import com.project.model.Reports;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Reports generateReport(ReportType reportType, Employees generatedBy) {
        Reports report = new Reports(reportType, generatedBy);
        return reportRepository.save(report);
    }

    public List<Reports> getReportsByType(ReportType reportType) {
        return reportRepository.findAllByReportType(reportType);
    }

    public List<Reports> getReportsWithinDateRange(LocalDateTime start, LocalDateTime end) {
        return reportRepository.findAllByGeneratedAtBetween(start, end);
    }
}

package com.project.controller;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.business.ReportService;
import com.project.model.Employees;
import com.project.model.ReportType;
import com.project.model.Reports;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/generate")
    public Reports generateReport(@RequestBody Map<String, String> requestData) {
        ReportType reportType = ReportType.valueOf(requestData.get("reportType")); // Convert string to enum
        Long employeeId = Long.valueOf(requestData.get("employeeId"));
        
        Employees employee = new Employees();
        employee.setEmployeeId(employeeId);
        
        return reportService.generateReport(reportType, employee);
    }


    @GetMapping("/type/{type}")
    public List<Reports> getReportsByType(@PathVariable ReportType type) {
        return reportService.getReportsByType(type);
    }

    @GetMapping("/date-range")
    public List<Reports> getReportsByDateRange(@RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
        return reportService.getReportsWithinDateRange(start, end);
    }
}

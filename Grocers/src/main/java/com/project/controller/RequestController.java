package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.business.RequestService;
import com.project.model.Requests;

@RestController
@RequestMapping("/requests")
public class RequestController {
    @Autowired 
    private RequestService requestService;

    @GetMapping("/view")
    public ResponseEntity<List<Requests>> viewRequests() {
        return ResponseEntity.ok(requestService.getAllRequests());
    }
}

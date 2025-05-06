package com.project.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.RequestRepository;
import com.project.model.Requests;

@Service
public class RequestService {
    @Autowired 
    private RequestRepository requestRepo;

    public List<Requests> getAllRequests() {
        return requestRepo.findAll();
    }
}

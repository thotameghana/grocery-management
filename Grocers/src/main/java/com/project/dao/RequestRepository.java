package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Requests;

@Repository
public interface RequestRepository extends JpaRepository<Requests, Long> {
	List<Requests> findByEmployeeId(Long employeeId);

}

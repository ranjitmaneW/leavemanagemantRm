package com.example.demo.LeaveApplicationRepository.com;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.LeaveApplication.com.LeaveApplication;
@Repository
public interface LeaveApplicationRepository   extends JpaRepository<LeaveApplication, Long>{
    List<LeaveApplication> findByEmployeeId(Long employeeId);
    // Correctly reference LeaveStatus as LeaveApplication.LeaveStatus
    List<LeaveApplication> findByStatus(LeaveApplication.LeaveStatus status);
}


package com.example.demo.LeaveApplicationService.com;
import java.util.Optional;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.LeaveApplication.com.LeaveApplication;
import com.example.demo.LeaveApplication.com.LeaveApplication.LeaveStatus;
import com.example.demo.LeaveApplicationRepository.com.LeaveApplicationRepository;

@Service
public class LeaveApplicationService {
	
	@Autowired
	LeaveApplicationRepository leaveApplicationRepository;

	
	
	

    public LeaveApplication applyForLeave(LeaveApplication leaveApplication) {
        leaveApplication.setStatus(LeaveStatus.PENDING);
        return leaveApplicationRepository.save(leaveApplication);
    }

    public List<LeaveApplication> getLeaveByEmployee(Long employeeId) {
        return leaveApplicationRepository.findByEmployeeId(employeeId);
    }

    public List<LeaveApplication> getPendingLeaves() {
        return leaveApplicationRepository.findByStatus(LeaveStatus.PENDING);
    }
    public LeaveApplication updateLeaveStatus(Long applicationId, LeaveApplication.LeaveStatus newStatus) {
        Optional<LeaveApplication> leaveApplicationOpt = leaveApplicationRepository.findById(applicationId);

        if (leaveApplicationOpt.isPresent()) {
            LeaveApplication leaveApplication = leaveApplicationOpt.get();
            leaveApplication.setStatus(newStatus);
            
            // Save the updated leave application and return it
            return leaveApplicationRepository.save(leaveApplication);
        } else {
            // Handle case when leave application is not found
            throw new RuntimeException("Leave application not found for id " + applicationId);
        }
    }



        
    public List<LeaveApplication> getAllLeaves() {
        return leaveApplicationRepository.findAll();
    }
	
	
    
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.example.demo.LeaveApplicationController.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.LeaveApplication.com.LeaveApplication;
import com.example.demo.LeaveApplication.com.LeaveApplication.LeaveStatus;
import com.example.demo.LeaveApplicationService.com.LeaveApplicationService;

@RestController
@RequestMapping("/api/leaves")
public class LeaveApplicationController {
	 
	
	@Autowired
	    private LeaveApplicationService leaveApplicationService;



    @PostMapping("/apply")
    public LeaveApplication applyForLeave(@RequestBody LeaveApplication leaveApplication) {
        return leaveApplicationService.applyForLeave(leaveApplication);
    }

    @GetMapping("/employee/{employeeId}")
    public List<LeaveApplication> getLeaveByEmployee(@PathVariable Long employeeId) {
        return leaveApplicationService.getLeaveByEmployee(employeeId);
    }

    @GetMapping("/pending")
    public List<LeaveApplication> getPendingLeaves() {
        return leaveApplicationService.getPendingLeaves();
    }

    @PutMapping("/status/{leaveId}")
    public LeaveApplication updateLeaveStatus(@PathVariable Long leaveId, @RequestParam LeaveStatus status) {
        return leaveApplicationService.updateLeaveStatus(leaveId, status);
    }

    @GetMapping("/all")
    public List<LeaveApplication> getAllLeaves() {
        return leaveApplicationService.getAllLeaves();
    }

}

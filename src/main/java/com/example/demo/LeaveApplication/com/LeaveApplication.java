package com.example.demo.LeaveApplication.com;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "leave_application")
public class LeaveApplication {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long employeeId;

	    private String employeeName;

	    private LocalDate leaveApplayDateCurrent;

	    @Enumerated(EnumType.STRING)
	    private LeaveType leaveType; // Annual, Sick, etc.

	    private String shiftTime; // "Morning", "Afternoon", "Evening"

	    private String leaveTypeDay; // "Half Day" or "Full Day"

	    private LocalDate startLeaveDate;

	    private LocalDate endLeaveDate;

	    private String reason;

	    @Enumerated(EnumType.STRING)
	    private LeaveStatus status; // PENDING, APPROVED, REJECTED

	    private LocalDate appliedDate = LocalDate.now();

enum LeaveType {
    ANNUAL_LEAVE, SICK_LEAVE, UNPAID_LEAVE
}

public enum LeaveStatus {
    PENDING, APPROVED, REJECTED
}}
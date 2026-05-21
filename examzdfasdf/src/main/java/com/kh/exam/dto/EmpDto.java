package com.kh.exam.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class EmpDto {
	private int empId;
	private String empDept;
	private String empName;
	private String empEmail;
	private String empPhone;
	private String empPosition;
	private String empHireDate;
	private String empUseYN;
	private Timestamp empCreatedAt;

}

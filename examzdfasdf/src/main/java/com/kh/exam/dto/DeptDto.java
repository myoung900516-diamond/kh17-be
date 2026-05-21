package com.kh.exam.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class DeptDto {
	private String deptId;
	private String deptName;
	private String deptUseYN;
	private Timestamp deptCreateAt;

}

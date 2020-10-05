package com.dxctraining.onlinetestmanagement.dto;

import java.time.LocalDate;


public class AssignExamDto {
	
	
	private int id;   //
	
	
	private String status;
	
	private LocalDate dateOfExam;
	
	private int userId;
	
	private int examId;
	
	public AssignExamDto() {	}
	public AssignExamDto(int id, String status, LocalDate dateOfExam, Integer userId, Integer examId) {
		this.id = id;
		this.status = status;
		this.dateOfExam = dateOfExam;
		this.userId = userId;
		this.examId = examId;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDateOfExam() {
		return dateOfExam;
	}

	public void setDateOfExam(LocalDate dateOfExam) {
		this.dateOfExam = dateOfExam;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}
	
	
}

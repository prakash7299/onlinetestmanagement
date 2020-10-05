package com.dxctraining.onlinetestmanagement.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="assign_exam_to_user")
public class AssignExamToUser {
	
	@Id
	@Column(name="assigned_id")
	@GeneratedValue
	private int id;   //
	
	
	@Column(name="status")
	private String status;
	
	@Column(name="date_of_exam")
	private LocalDate dateOfExam;
	

	private Integer userId ;
	
	private Integer examId ;

	
	
	public AssignExamToUser() {	}
	public AssignExamToUser(int id, String status, LocalDate dateOfExam, Integer userId, Integer examId) {
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	@Override
	public String toString() {
		return "AssignExamToUser [assignedId=" + id + " status=" + status
				+ ", dateOfExam=" + dateOfExam + ", user=" + userId + ", exam=" + examId + "]";
	}
	
}

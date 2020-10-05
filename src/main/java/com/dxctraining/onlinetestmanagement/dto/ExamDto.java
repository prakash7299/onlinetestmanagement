package com.dxctraining.onlinetestmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class ExamDto {
	private int examId;
	private String examName;
	private int minutes;
	public int getExamId() {
		return examId;
	}
	public ExamDto() {	}
	public ExamDto(int examId, String examName, int minutes) {
		this.examId = examId;
		this.examName = examName;
		this.minutes = minutes;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	
}

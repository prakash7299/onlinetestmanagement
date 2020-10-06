package com.dxctraining.onlinetestmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="online_test")
public class Exam {
	
	@Id
	@Column(name="exam_id")
	@GeneratedValue
	private int examId;
	@Column(name="exam_name", length=20)
	private String examName;
	@Column(name="minutes")
	private int minutes;
	
	
	public Exam() {	}
	public Exam(int examId, String examName, int minutes) {
		this.examId = examId;
		this.examName = examName;
		this.minutes = minutes;
	}
	
	public int getExamId() {
		return examId;
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
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Exam that = (Exam) o;
        return examId == that.examId;
    }

    @Override
    public int hashCode() {
        return examId;
    }
	
	
	
	
}


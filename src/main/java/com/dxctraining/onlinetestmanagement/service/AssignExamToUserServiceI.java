package com.dxctraining.onlinetestmanagement.service;

import java.util.List;
import java.util.Optional;
import com.dxctraining.onlinetestmanagement.entity.AssignExamToUser;
import com.dxctraining.onlinetestmanagement.entity.Exam;
import com.dxctraining.onlinetestmanagement.entity.User;

public interface AssignExamToUserServiceI {
	
		public User addUser(User user);
		public User getUserById(int userId);
		public List<User> getAllUsers();
		
		
		
		public Exam addExam(Exam exam);
		public List<Exam> viewExams();
		public Exam getExamById(int examId);
		
		public Boolean deleteAssignedExam(int assignedId);
		public AssignExamToUser getAssignExamById(int assignedId);
		public AssignExamToUser assignExam(AssignExamToUser assign);
		public Optional<AssignExamToUser> viewAssignExamById(int assignedId);
		public List<AssignExamToUser> allAssignExamToUser();
}

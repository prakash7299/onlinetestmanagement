package com.dxctraining.onlinetestmanagement.service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dxctraining.onlinetestmanagement.dao.AssignExamToUserDaoI;
import com.dxctraining.onlinetestmanagement.dao.ExamDaoI;
import com.dxctraining.onlinetestmanagement.dao.UserDaoI;
import com.dxctraining.onlinetestmanagement.entity.AssignExamToUser;
import com.dxctraining.onlinetestmanagement.entity.Exam;
import com.dxctraining.onlinetestmanagement.entity.User;
import com.dxctraining.onlinetestmanagement.exceptions.AssignExamToUserNotFoundException;
import com.dxctraining.onlinetestmanagement.exceptions.ExamNotFoundException;
import com.dxctraining.onlinetestmanagement.exceptions.UserNotFoundException;

@Service
@Transactional
public class AssignExamToUserServiceImpl implements AssignExamToUserServiceI{
 
	LocalDate datee;
	
	@Autowired
	private AssignExamToUserDaoI assignExamToUserDaoI;
	
	@Autowired
	private ExamDaoI examDaoI;
	
	@Autowired
	private UserDaoI userDaoI;
	
	

	@Override
	public User addUser(User user) {
		userDaoI.save(user);
		return user;
	}

	@Override
	public User editUser(User user) {
		userDaoI.saveAndFlush(user);
		return user;
	}
	@Override
	public Boolean deleteAssignedExam(int id) {
		assignExamToUserDaoI.deleteById(id);
		return null;
		
	}
	@Override
	public AssignExamToUser assignExam(AssignExamToUser assign) {
		assignExamToUserDaoI.save(assign);
		return assign;
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> user = userDaoI.findById(userId);
		boolean check=user.isPresent();
		if(check=false) {
			throw new UserNotFoundException("User not available"+userId);
		}
		if(user.isPresent())
		{
			User userobj = user.get();
			return userobj;
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> user =userDaoI.findAll();
		return user;
	}

	@Override
	public Exam addExam(Exam exam) {
		examDaoI.save(exam);
		return exam;
	}

	@Override
	public Exam editExam(Exam exam) {
		examDaoI.saveAndFlush(exam);
		return exam;
	}

	@Override
	public List<Exam> viewExams() {
		List<Exam> obj = examDaoI.findAll();
		return obj;
	}

	@Override
	public Exam getExamById(int examId) {
		Optional<Exam> exam = examDaoI.findById(examId);
		boolean check=exam.isPresent();
		if(check=false) {
			throw new ExamNotFoundException("Exam not fount at"+examId);
		}
		if(exam.isPresent())
		{
			Exam examobj = exam.get();
			return examobj;
		}
		return null;
	}
	
	@Override
	public AssignExamToUser getAssignExamById(int id) {
		Optional<AssignExamToUser> assign = assignExamToUserDaoI.findById(id);
		boolean check=assign.isPresent();
		if(check=false) {
			throw new AssignExamToUserNotFoundException("Assign Exam not fount at"+id);
		}
		if(assign.isPresent())
		{
			AssignExamToUser examobj = assign.get();
			return examobj;
		}
		return null;
	}



	
	@Override
	public Optional<AssignExamToUser> viewAssignExamById(int id) {
		Optional<AssignExamToUser> assignExamToUserObj = assignExamToUserDaoI.findById(id);
		return assignExamToUserObj;
	}
	

	

	
	@Override
    public List<AssignExamToUser> allAssignExamToUser(){
        List<AssignExamToUser> assign=assignExamToUserDaoI.findAll();
        return assign;
    }



	
}

package com.dxctraining.onlinetestmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;



import com.dxctraining.onlinetestmanagement.dao.AssignExamToUserDaoI;
//import com.capgemini.onlinetestmanagement.dao.ExamDaoI;
//import com.capgemini.onlinetestmanagement.dao.UserDaoI;
import com.dxctraining.onlinetestmanagement.entity.AssignExamToUser;
import com.dxctraining.onlinetestmanagement.entity.User;
import com.dxctraining.onlinetestmanagement.service.AssignExamToUserServiceImpl;
import com.sun.el.stream.Optional;

@SpringBootTest
@Import(AssignExamToUserServiceImpl.class)
class OnlineTestManagementApplicationTests {

	@Autowired
	private AssignExamToUserServiceImpl assignExamToUserServiceImpl;

	
	@Test
	void addUserTest() {
		User userObjTest=new User(1,"prakash","abcde","user");
		User userObj=assignExamToUserServiceImpl.addUser(userObjTest);
		System.out.println("id"+userObjTest.getUserId());
		User userObjById = assignExamToUserServiceImpl.getUserById(1);
		System.out.println("userObjId "+userObjById.getUserId());
		Assertions.assertEquals(userObjTest.getUserName(),userObjById.getUserName());
		
	}
	@Test
	void getUserByIdInValidCreditsTest() {
		User userObjTest = new User(55,"vijay","passs","user");
		User userObj = assignExamToUserServiceImpl.getUserById(userObjTest.getUserId());
		System.out.println(" Hello i am from Test :"+userObj);
		Assertions.assertEquals(null,userObj);
	}
	
	
	
	
	
	
	
			

	
	
	
}

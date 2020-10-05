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
	void getUserByIdValidCreditsTest() {
		User userObjTest = new User(1,"vijay","passs","user");
		User userObj = assignExamToUserServiceImpl.getUserById(userObjTest.getUserId());
		System.out.println(" Hello i am from Test :"+userObj.getRole());
		Assertions.assertEquals(userObjTest.getRole(),userObj.getRole());
	}

	@Test
	void getUserByIdInValidCreditsTest() {
		User userObjTest = new User(55,"vijay","passs","user");
		User userObj = assignExamToUserServiceImpl.getUserById(userObjTest.getUserId());
		System.out.println(" Hello i am from Test :"+userObj);
		Assertions.assertEquals(null,userObj);
	}
	
	@Test
	void getAllUsersForNonEmptyListTest() {
		List<User> userList = assignExamToUserServiceImpl.getAllUsers();
		System.out.println("The UserList Size is :"+userList.size());
		int excpectedSize  = 3;
		Assertions.assertEquals(excpectedSize,userList.size());
	}
	
	
	@Test
	void getAllUsersForEmptyListTest() {
		List<User> userList = assignExamToUserServiceImpl.getAllUsers();
		System.out.println("The UserList Size is :"+userList.size());
		int excepectedSize =0;
		if(userList.size() !=0) 
		{
			excepectedSize = 3;
			Assertions.assertEquals(excepectedSize,userList.size());
		}
		else
		{
			System.out.println("UserList size is Zero: 0");
			Assertions.assertEquals(excepectedSize,userList.size());
		}
	}
	
	
	
			

	
	
	
}

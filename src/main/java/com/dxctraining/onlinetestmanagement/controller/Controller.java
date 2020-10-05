package com.dxctraining.onlinetestmanagement.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.dxctraining.onlinetestmanagement.dto.AssignExamDto;
import com.dxctraining.onlinetestmanagement.dto.CreateAssignExamDto;
import com.dxctraining.onlinetestmanagement.dto.CreateExamRequest;
import com.dxctraining.onlinetestmanagement.dto.CreateUserRequest;
import com.dxctraining.onlinetestmanagement.dto.ExamDto;
import com.dxctraining.onlinetestmanagement.dto.UserDto;
import com.dxctraining.onlinetestmanagement.entity.AssignExamToUser;
import com.dxctraining.onlinetestmanagement.entity.Exam;
import com.dxctraining.onlinetestmanagement.entity.User;
import com.dxctraining.onlinetestmanagement.service.AssignExamToUserServiceI;
import com.dxctraining.onlinetestmanagement.util.AssignExamUtil;


@RestController
@RequestMapping("/onlinetestmanagement")
public class Controller {
	
	@Autowired
	private AssignExamToUserServiceI service;
	
	@Autowired
	private AssignExamUtil assignExamUtil;
	
	@PostMapping("/user/add")
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto create(@RequestBody CreateUserRequest data) {
		User user= new User(data.getUserId(),data.getUserName(),data.getPassword(),data.getRole());
		user = service.addUser(user);
		UserDto response = toDto(user);
		return response;
	}
	
	@GetMapping("/user/get/{id}")
	public UserDto findById(@PathVariable("id") Integer id) {
		User user = service.getUserById(id);
		UserDto dto = toDto(user);
		return dto;
	}
	
	
	
	@PostMapping("/exam/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ExamDto create(@RequestBody CreateExamRequest data) {
		Exam exam= new Exam(data.getExamId(),data.getExamName(),data.getMinutes());
		exam = service.addExam(exam);
		ExamDto response = toDtoExam(exam);
		return response;
	}
	
	@GetMapping("/exam/get/{id}")
	public ExamDto findByExamId(@PathVariable("id") Integer id) {
		Exam user = service.getExamById(id);
		ExamDto dto = toDtoExam(user);
		return dto;
	}
	@PostMapping("/admin/assignexam")
	@ResponseStatus(HttpStatus.CREATED)
	public AssignExamDto assign(@RequestBody CreateAssignExamDto data) {
		AssignExamToUser assign= new AssignExamToUser(data.getId(),data.getStatus(),data.getDateOfExam(),data.getUserId(), data.getExamId());
		assign = service.assignExam(assign);
		AssignExamDto response = toDtoAssignExam(assign);
		return response;
	}
	@GetMapping("/admin/assignExamList")
    public List<AssignExamDto> fetchAll() {
        List<AssignExamToUser> list = service.allAssignExamToUser();
        List<AssignExamDto>response=new ArrayList<>();
        for (AssignExamToUser assign:list){
            AssignExamDto dto=assignExamUtil.AssignExamDto(assign);
            response.add(dto);
        }
        return response;
    }
	@GetMapping("/admin/assignedexam/get/{id}")
	public AssignExamDto findByAssignedExamId(@PathVariable("id") Integer id) {
		AssignExamToUser assign = service.getAssignExamById(id);
		AssignExamDto dto = toDtoAssignExam(assign);
		return dto;
	}
	
	@DeleteMapping("/admin/delete/{id}")
	public ResponseEntity<Object> deleteAssignedExam(@PathVariable("id") int id)
	{
		service.deleteAssignedExam(id);
		return new ResponseEntity<>("Deleted",HttpStatus.OK);
	}
	public UserDto toDto(User user) {
		UserDto dto = new UserDto();
		dto.setUserId(user.getUserId());
		dto.setUserName(user.getUserName());
		dto.setPassword(user.getPassword());
		dto.setRole(user.getRole());
		return dto;
	}
	public ExamDto toDtoExam(Exam exam) {
		ExamDto dto = new ExamDto();
		dto.setExamId(exam.getExamId());
		dto.setExamName(exam.getExamName());
		dto.setMinutes(exam.getMinutes());
		return dto;
	}
	public AssignExamDto toDtoAssignExam(AssignExamToUser assign) {
		AssignExamDto dto = new AssignExamDto();
		dto.setId(assign.getId());
		dto.setStatus(assign.getStatus());
		dto.setDateOfExam(assign.getDateOfExam());
		dto.setUserId(assign.getUserId());
		dto.setExamId(assign.getExamId());
		return dto;
	}
	
}

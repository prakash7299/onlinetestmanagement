package com.dxctraining.onlinetestmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dxctraining.onlinetestmanagement.entity.AssignExamToUser;

@Repository
public interface AssignExamToUserDaoI extends JpaRepository<AssignExamToUser,Integer> {
	
}

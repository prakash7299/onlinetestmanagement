package com.dxctraining.onlinetestmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxctraining.onlinetestmanagement.entity.User;


@Repository
public interface UserDaoI extends JpaRepository<User,Integer>{
	
}

package com.dxctraining.onlinetestmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_table")
public class User {

	@Id
	@Column(name="user_id")
	@GeneratedValue
	private int userId;
	@Column(name="user_name", length=25)
	private String userName;
	@Column(name="password", length=10)
	private  String password;
	@Column(name="role", length=10)
	private String role;
	
	
	public User() {	}
	public User(int userId, String userName, String password, String role) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User that = (User) o;
        return userId == that.userId;
    }

    @Override
    public int hashCode() {
        return userId;
    }

	
}

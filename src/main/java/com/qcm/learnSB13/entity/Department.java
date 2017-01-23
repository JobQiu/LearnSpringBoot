package com.qcm.learnSB13.entity;

import java.util.List;

/**
 * 
 * @author Congmin Qiu 
 */
public class Department {

	private Integer id;
	private String name;
	private List<User> users;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}


}

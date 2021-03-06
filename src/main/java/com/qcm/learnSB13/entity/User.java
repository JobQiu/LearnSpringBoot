package com.qcm.learnSB13.entity;


/**
 * 
 * @author Congmin Qiu 
 */
public class User {

	private Long id;
	private String name;
	private Integer age;
	private Department department;


	public Long getId() {
		return id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

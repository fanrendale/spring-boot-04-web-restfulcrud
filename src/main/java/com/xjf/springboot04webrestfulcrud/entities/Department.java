package com.xjf.springboot04webrestfulcrud.entities;


import lombok.Data;

@Data
public class Department {

	private Integer id;
	private String departmentName;

	public Department() {
		}

	public Department(int i, String string) {
		this.id = i;
		this.departmentName = string;
	}


}

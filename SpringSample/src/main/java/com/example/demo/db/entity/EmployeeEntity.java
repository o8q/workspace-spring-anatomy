package com.example.demo.db.entity;

import java.util.Map;

import lombok.Data;

@Data
public class EmployeeEntity {
	private Integer id;
	private String name;
	private Integer age;

	public EmployeeEntity() {
		super();
	}
	public EmployeeEntity(Map<String, Object> map) {
		this();
		this.id = Integer.valueOf(map.get("id").toString());
		this.name = map.get("name").toString();
		this.age = Integer.valueOf(map.get("age").toString());
	}
}

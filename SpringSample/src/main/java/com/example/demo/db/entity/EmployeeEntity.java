package com.example.demo.db.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "employee")
public class EmployeeEntity {
	@Id
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
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

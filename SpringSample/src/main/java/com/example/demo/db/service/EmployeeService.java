package com.example.demo.db.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.db.entity.EmployeeEntity;
import com.example.demo.db.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public EmployeeEntity findOne(Integer id) {
		Map<String, Object> map = repository.findOne(id);
		if (map == null) return null;
		return new EmployeeEntity(map);
	}
}

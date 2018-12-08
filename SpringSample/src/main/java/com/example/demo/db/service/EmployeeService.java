package com.example.demo.db.service;

import static com.example.demo.db.service.specification.EmployeeSpecification.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.db.entity.EmployeeEntity;
import com.example.demo.db.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public List<EmployeeEntity> getAll() {
		return repository.findAll();
	}

	public EmployeeEntity update(EmployeeEntity entity) {
		return repository.save(entity);
	}

	public List<EmployeeEntity> listGroups(EmployeeEntity entity) {
		return repository.findAll(Specification.where(idEquals(entity.getId()))
				.and(nameContains(entity.getName())).and(ageEquals(entity.getAge())));
	}

	public Optional<EmployeeEntity> findOne(Integer id) {
		return repository.findById(id);
	}
}

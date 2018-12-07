package com.example.demo.db.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String, Object> findOne(Integer id) {
		try {
			String query = "SELECT "
					+ "id, name, age "
					+ "FROM employee "
					+ "WHERE id = ?";
			return jdbcTemplate.queryForMap(query, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}

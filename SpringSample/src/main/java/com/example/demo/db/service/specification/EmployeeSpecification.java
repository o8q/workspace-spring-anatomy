package com.example.demo.db.service.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.db.entity.EmployeeEntity;

public class EmployeeSpecification {

	@SuppressWarnings("serial")
	public static Specification<EmployeeEntity> idEquals(Integer value) {
		return value == null ? null : new Specification<EmployeeEntity>() {
			@Override
			public Predicate toPredicate(Root<EmployeeEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("id"), value);
			}
		};
	}

	@SuppressWarnings("serial")
	public static Specification<EmployeeEntity> nameContains(String value) {
		return isEmpty(value) ? null : new Specification<EmployeeEntity>() {
			@Override
			public Predicate toPredicate(Root<EmployeeEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.get("name"), "%" + value + "%");
			}
		};
	}

	@SuppressWarnings("serial")
	public static Specification<EmployeeEntity> ageEquals(Integer value) {
		return value == null ? null : new Specification<EmployeeEntity>() {
			@Override
			public Predicate toPredicate(Root<EmployeeEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("age"), value);
			}
		};
	}

	private static boolean isEmpty(String value) {
		if (value == null || value.isEmpty()) return true;
		return false;
	}
}

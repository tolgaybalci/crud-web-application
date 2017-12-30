package com.example.webapp.webapplication.repository;

import com.example.webapp.webapplication.domain.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}

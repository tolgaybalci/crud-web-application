package com.example.webapp.webapplication.repository;

import com.example.webapp.webapplication.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long>{
}

package com.luv4code.springdatajpa.repository;

import com.luv4code.springdatajpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

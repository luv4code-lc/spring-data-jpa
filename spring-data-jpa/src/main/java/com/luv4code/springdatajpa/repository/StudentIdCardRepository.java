package com.luv4code.springdatajpa.repository;

import com.luv4code.springdatajpa.domain.StudentIdCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentIdCardRepository extends JpaRepository<StudentIdCard, Long> {
    
}

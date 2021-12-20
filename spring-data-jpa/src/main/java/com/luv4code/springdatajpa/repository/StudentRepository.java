package com.luv4code.springdatajpa.repository;

import com.luv4code.springdatajpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    @Query("SELECT s FROM Student  s WHERE s.email=?1")
    Optional<Student> findStudentByEmail(String email);

    @Query("select s from Student s where  s.firstName=?1 and  s.age>=?2")
    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEqual(String firstName, int age);

    @Query(value = "select *from student where first_name= :firstName and  age >= :age",
            nativeQuery = true)
    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEqualNative(@Param("firstName") String firstName, @Param("age") int age);

    @Transactional
    @Modifying
    @Query("delete  from Student s where s.id=?1")
    int deleteStudentsById(Long id);
}

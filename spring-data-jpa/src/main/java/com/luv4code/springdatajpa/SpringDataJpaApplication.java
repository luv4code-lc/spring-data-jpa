package com.luv4code.springdatajpa;

import com.luv4code.springdatajpa.domain.Student;
import com.luv4code.springdatajpa.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student madhav = new Student("Madhav", "Ponnana", "madhav@gmail.com", 27);
            Student rohit = new Student("Rohit", "Sharma", "rohit@gmail.com", 35);
            Student yuvraj = new Student("Yuvraj", "Singh", "yuvrajsingh@gmail.com", 40);

            studentRepository.saveAll(List.of(madhav, rohit, yuvraj));

            studentRepository.findStudentByEmail("madhav@gmail.com").ifPresentOrElse(System.out::println, () -> System.out.println("Student with email madhav@gmail.com  not found"));

            studentRepository.selectStudentWhereFirstNameAndAgeGreaterOrEqual("Madhav", 27).forEach(System.out::println);

            studentRepository.selectStudentWhereFirstNameAndAgeGreaterOrEqualNative("Madhav", 27).forEach(System.out::println);

            System.out.println("Deleting yuvraj 3");
            System.out.println(studentRepository.deleteStudentsById(3L));

        };
    }

}

package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {


    public List<Student> getAllStudents(){
        return List.of(
                new Student(
                        2L,
                        "Ahmed Tiger",
                        "engahmedhegazy2025@gmail.com",
                        LocalDate.of(2020, Month.JANUARY, 20),
                        25
                )
        );
    }

}

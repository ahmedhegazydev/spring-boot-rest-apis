package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


//    public List<Student> getAllStudents(){
//        return List.of(
//                new Student(
//                        2L,
//                        "Ahmed Tiger",
//                        "engahmedhegazy2025@gmail.com",
//                        LocalDate.of(2020, Month.JANUARY, 20),
//                        25
//                )
//        );
//    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public void addNewStudent(Student student) {
        Optional<Student> optionalStudent =
                studentRepository.findStudentByEmail(student.getEmail());
        if (optionalStudent.isPresent()) {
            throw new IllegalStateException("Email taken");
        } else {
            System.out.println(student);
            studentRepository.save(student);
        }
    }
}

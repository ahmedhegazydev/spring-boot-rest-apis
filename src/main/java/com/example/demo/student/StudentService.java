package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
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


    public void deleteStudent(Long studentId) {
        boolean exist =
                studentRepository.existsById(studentId);
        if (!exist){
            throw new IllegalStateException(
                    "the student with " + studentId +  " doesn't exists."
            );
        }else {
            studentRepository.deleteById(studentId);
        }
    }


    @Transactional
    public void updateStudent(Long studentId, String name,
                              String email
    ) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "the student with " + studentId +  " doesn't exists."
                ));
        if (name != null && name.length() > 0 && !Objects.equals(
                student.getName(), name
        )){
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(
                student.getEmail(), email
        )){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Email taked");
            }else {
                student.setEmail(email);
            }
        }
    }
}

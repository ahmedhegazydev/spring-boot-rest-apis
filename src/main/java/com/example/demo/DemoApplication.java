package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


//    @GetMapping
//    public String hello(){
//        return "hello world";
//    }

//    @GetMapping
//    public List<String> hello(){
//        return List.of("Hello", "World");
//    }

    @GetMapping
    public List<Student> helle(){
        return List.of(new Student(
                "Ahmed",
                "engahmedhegazy2025@gmail.com",
                LocalDate.of(2025, Month.JANUARY, 20),
                25
        ));
    }


}

package com.example.demo.student;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {


    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student studentAhmed = new Student(
                    "Ahmed",
                    "engahmedhegazy2025@gmail.com",
                    LocalDate.of(2020, Month.JANUARY, 20)
//                    29
            );

            Student studentMona =  new Student(
              "Mona Emad",
              "engahmedali2022@gmail.com",
              LocalDate.of(3939, Month.DECEMBER, 49)
//              48
            );

            studentRepository.saveAll(List.of(
                    studentAhmed, studentMona
            ));


        };
    }

}

package com.example.courseSelector.config;

import com.example.courseSelector.entity.Course;
import com.example.courseSelector.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {

        Course course1 = new Course();
        course1.setTitle("Математика");
        course1.setCapacity(30);
        course1.setEnrolled(0);
        course1.setEnrollmentStart(LocalDateTime.of(2024, 9, 1, 9, 0));
        course1.setEnrollmentEnd(LocalDateTime.of(2024, 11, 30, 18, 0));

        Course course2 = new Course();
        course2.setTitle("Физика");
        course2.setCapacity(25);
        course2.setEnrolled(0);
        course2.setEnrollmentStart(LocalDateTime.of(2025, 1, 1, 9, 0));
        course2.setEnrollmentEnd(LocalDateTime.of(2025, 3, 31, 18, 0));

        Course course3 = new Course();
        course3.setTitle("Английский язык");
        course3.setCapacity(20);
        course3.setEnrolled(5);
        course3.setEnrollmentStart(LocalDateTime.of(2024, 9, 1, 9, 0));
        course3.setEnrollmentEnd(LocalDateTime.of(2024, 11, 30, 18, 0));

        courseRepository.saveAll(Arrays.asList(course1, course2, course3));
    }
}

package com.example.courseSelector.service;

import com.example.courseSelector.dto.CourseDto;
import com.example.courseSelector.entity.Course;
import com.example.courseSelector.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public String EnrollStudent(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

        if (LocalDateTime.now().isBefore(course.getEnrollmentStart()) ||
                LocalDateTime.now().isAfter(course.getEnrollmentEnd())) {
            return "Enrollment is not currently available for this course";
        }

        synchronized (course) {
            if (course.getEnrolled() < course.getCapacity()) {
                course.setEnrolled(course.getEnrolled() + 1);
                courseRepository.save(course);
                return "Successfully enrolled";
            } else {
                return "All spots are already taken";
            }
        }
    }

    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(CourseDto::new)
                .collect(Collectors.toList());
    }
}

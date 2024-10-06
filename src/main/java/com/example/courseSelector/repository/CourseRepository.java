package com.example.courseSelector.repository;

import com.example.courseSelector.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}

package com.example.courseSelector.controller;

import com.example.courseSelector.dto.CourseDto;
import com.example.courseSelector.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollStudent(@RequestParam long id) {
        String result = courseService.EnrollStudent(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        List<CourseDto> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

}

package com.example.courseSelector.dto;

import com.example.courseSelector.entity.Course;
import lombok.Data;

@Data
public class CourseDto {
    private Long id;
    private String title;
    private int capacity;
    private int enrolled;

    public CourseDto(Course course) {
        this.id = course.getId();
        this.title = course.getTitle();
        this.capacity = course.getCapacity();
        this.enrolled = course.getEnrolled();
    }

    public int getAvailableSpaces() {
        return capacity - enrolled;
    }
}

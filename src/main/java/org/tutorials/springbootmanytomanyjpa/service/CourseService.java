package org.tutorials.springbootmanytomanyjpa.service;

import org.tutorials.springbootmanytomanyjpa.dto.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto createCourse(CourseDto courseDto);
    CourseDto getCourse(Long id);
    List<CourseDto> getAllCourses();
    CourseDto updateCourse(Long id, CourseDto courseDto);
    void deleteCourse(Long id);
}
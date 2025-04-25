package org.tutorials.springbootmanytomanyjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tutorials.springbootmanytomanyjpa.dto.CourseDto;
import org.tutorials.springbootmanytomanyjpa.entity.Course;
import org.tutorials.springbootmanytomanyjpa.mapper.CourseMapper;
import org.tutorials.springbootmanytomanyjpa.repository.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    public CourseDto createCourse(CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        return courseMapper.toDto(courseRepository.save(course));
    }

    public CourseDto getCourse(Long id) {
        return courseMapper.toDto(courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found")));
    }

    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setTitle(courseDto.getTitle());
        return courseMapper.toDto(courseRepository.save(course));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}

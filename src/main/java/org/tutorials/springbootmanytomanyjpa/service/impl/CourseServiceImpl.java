package org.tutorials.springbootmanytomanyjpa.service.impl;

import org.springframework.stereotype.Service;
import org.tutorials.springbootmanytomanyjpa.dto.CourseDto;
import org.tutorials.springbootmanytomanyjpa.entity.Course;
import org.tutorials.springbootmanytomanyjpa.mapper.CourseMapper;
import org.tutorials.springbootmanytomanyjpa.repository.CourseRepository;
import org.tutorials.springbootmanytomanyjpa.service.CourseService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        return courseMapper.toDto(courseRepository.save(course));
    }

    @Override
    public CourseDto getCourse(Long id) {
        return courseMapper.toDto(courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found")));
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto updateCourse(Long id, CourseDto courseDto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setTitle(courseDto.getTitle());
        return courseMapper.toDto(courseRepository.save(course));
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
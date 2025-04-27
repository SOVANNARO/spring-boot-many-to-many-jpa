package org.tutorials.springbootmanytomanyjpa.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.tutorials.springbootmanytomanyjpa.dto.StudentDto;
import org.tutorials.springbootmanytomanyjpa.entity.Course;
import org.tutorials.springbootmanytomanyjpa.entity.Student;
import org.tutorials.springbootmanytomanyjpa.mapper.StudentMapper;
import org.tutorials.springbootmanytomanyjpa.repository.CourseRepository;
import org.tutorials.springbootmanytomanyjpa.repository.StudentRepository;
import org.tutorials.springbootmanytomanyjpa.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        return studentMapper.toDto(studentRepository.save(student));
    }

    @Override
    public StudentDto getStudent(Long id) {
        return studentMapper.toDto(studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found")));
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(studentDto.getName());
        return studentMapper.toDto(studentRepository.save(student));
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentDto enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        student.addCourse(course);
        return studentMapper.toDto(studentRepository.save(student));
    }

    @Override
    @Transactional
    public StudentDto unenrollStudentFromCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        student.removeCourse(course);
        return studentMapper.toDto(studentRepository.save(student));
    }
}
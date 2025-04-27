package org.tutorials.springbootmanytomanyjpa.service;

import org.tutorials.springbootmanytomanyjpa.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudent(Long id);
    List<StudentDto> getAllStudents();
    StudentDto updateStudent(Long id, StudentDto studentDto);
    void deleteStudent(Long id);
    StudentDto enrollStudentInCourse(Long studentId, Long courseId);
    StudentDto unenrollStudentFromCourse(Long studentId, Long courseId);
}
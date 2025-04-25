package org.tutorials.springbootmanytomanyjpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tutorials.springbootmanytomanyjpa.dto.StudentDto;
import org.tutorials.springbootmanytomanyjpa.entity.Student;
import org.tutorials.springbootmanytomanyjpa.entity.Course;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {CourseMapper.class})
public interface StudentMapper {

    @Mapping(target = "courseNames", source = "courses")
    StudentDto toDto(Student student);

    @Mapping(target = "courses", ignore = true)
    Student toEntity(StudentDto studentDto);

    default Set<String> mapCoursesToNames(Set<Course> courses) {
        if (courses == null) {
            return null;
        }
        return courses.stream()
                .map(Course::getTitle)
                .collect(Collectors.toSet());
    }
}
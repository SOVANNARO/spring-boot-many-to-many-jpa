package org.tutorials.springbootmanytomanyjpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.tutorials.springbootmanytomanyjpa.dto.CourseDto;
import org.tutorials.springbootmanytomanyjpa.entity.Course;
import org.tutorials.springbootmanytomanyjpa.entity.Student;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {StudentMapper.class})
public interface CourseMapper {

    @Mapping(target = "studentNames", source = "students")
    CourseDto toDto(Course course);

    @Mapping(target = "students", ignore = true)
    Course toEntity(CourseDto courseDto);

    default Set<String> mapStudentsToNames(Set<Student> students) {
        if (students == null) {
            return null;
        }
        return students.stream()
                .map(Student::getName)
                .collect(Collectors.toSet());
    }
}
package org.tutorials.springbootmanytomanyjpa.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CourseDto {
    private Long id;
    private String title;
    private Set<String> studentNames;
}

package org.tutorials.springbootmanytomanyjpa.dto;

import lombok.Data;

import java.util.Set;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private Set<String> courseNames;
}

package org.tutorials.springbootmanytomanyjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutorials.springbootmanytomanyjpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

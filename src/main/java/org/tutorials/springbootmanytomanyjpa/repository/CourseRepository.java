package org.tutorials.springbootmanytomanyjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutorials.springbootmanytomanyjpa.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

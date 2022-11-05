package com.MainApp.JPALearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MainApp.JPALearn.Entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}

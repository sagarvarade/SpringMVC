package com.MainApp.JPALearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MainApp.JPALearn.Entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}

package com.MainApp.JPALearn.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.MainApp.JPALearn.Entities.Course;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void printCourses() {
		for (Course course : courseRepository.findAll()) {
			System.out.println(course);
		}
	}
}

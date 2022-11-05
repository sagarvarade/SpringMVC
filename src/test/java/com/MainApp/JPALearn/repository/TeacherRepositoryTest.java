package com.MainApp.JPALearn.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.MainApp.JPALearn.Entities.Course;
import com.MainApp.JPALearn.Entities.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;

	@Test
	public void saveTeacher() {
		Course course = Course.builder().title("DSaA").credit(4).build();
		Course courseDBA = Course.builder().title("DBA").credit(1).build();
		Teacher teacher = Teacher.builder().firstName("mahech").lastName("bagrechh").courses(List.of(course,courseDBA)).build();
		teacherRepository.save(teacher);
	}
}

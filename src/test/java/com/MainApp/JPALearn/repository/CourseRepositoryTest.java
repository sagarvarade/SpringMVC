package com.MainApp.JPALearn.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.MainApp.JPALearn.Entities.Course;
import com.MainApp.JPALearn.Entities.Student;
import com.MainApp.JPALearn.Entities.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;

	//@Test
	public void printCourses() {
		for (Course course : courseRepository.findAll()) {
			System.out.println(course);
		}
	}

	// @Test
	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder().firstName("nihil").lastName("patil").build();
		Course course = Course.builder().title("Java").credit(4).teacher(teacher).build();

		courseRepository.save(course);
	}

	//@Test
	public void findAllPagination() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		Pageable secondPageWithThreeRecords = PageRequest.of(1, 2);

		List<Course> course = courseRepository.findAll(firstPageWithThreeRecords).getContent();
		System.out.println(" 1Page " + course);

		List<Course> course2 = courseRepository.findAll(secondPageWithThreeRecords).getContent();
		System.out.println(" 2Page " + course2);

	}

	// @Test
	public void findBySorting() {
		Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
		Pageable sortByDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
		Pageable sortByTitleAndCredidDesc = PageRequest.of(0, 2, Sort.by("title", "credit").descending());
	}

	//@Test
	public void saveCourseWithStudentAndTeacher() {
		Teacher teacher = Teacher.builder().firstName("khhs").lastName("sfd").build();

		Student student = Student.builder().emailId("xx@gmilc.om").firstName("Shabir").lastName("lastneme").build();

		Course course = Course.builder().title("AIMI").credit(14).teacher(teacher).build();
		course.addStudents(student);
		courseRepository.save(course);
	}
	
	
	//@Test
	public void saveCourseWithStudent() {
		Student student = Student.builder().emailId("akash@gmilc.om").firstName("akash").lastName("chaudhari").build();
		Teacher teacher = Teacher.builder().firstName("khhs").lastName("sfd").build();
		Course course = Course.builder().title("Math").credit(14).teacher(teacher).build();
		course.addStudents(student);
		courseRepository.save(course);
	}
	//@Test
	public void getcourseAndAddStudent() {
		Long id = 2l;
		Course course = courseRepository.findById(id).get();
		Student student = Student.builder().emailId("rahul@gmilc.om").firstName("rahul").lastName("pande").build();
		course.addStudents(student);
		courseRepository.save(course);
	}
	@Test
	public void getcourseAndAddStudentList() {
		Long id = 2l;
		Course course = courseRepository.findById(id).get();
		List<Student> slist= course.getStudents();
		
		Student student = Student.builder().emailId("mahesh@gmilc.om").firstName("amhesg").lastName("dhjh").build();
		slist.add(student);
		course.setStudents(slist);
		courseRepository.save(course);
		
	}
}

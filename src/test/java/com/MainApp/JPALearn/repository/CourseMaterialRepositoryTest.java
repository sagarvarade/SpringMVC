package com.MainApp.JPALearn.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.MainApp.JPALearn.Entities.Course;
import com.MainApp.JPALearn.Entities.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRepo;

	//@Test
	public void SaveCourseMaterial() {

		Course course = Course.builder().title("DSA").credit(6).build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder().url("http://ggoll.com").credit(10).course(course).build();
		courseMaterialRepo.save(courseMaterial);
	}
	
	@Test
	public void printAllCourseMaterials() {
		for (CourseMaterial courseMaterial : courseMaterialRepo.findAll()) {
			System.out.println(courseMaterial);
		}
	}
	
}

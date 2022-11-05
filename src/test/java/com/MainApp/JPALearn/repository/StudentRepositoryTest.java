package com.MainApp.JPALearn.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.MainApp.JPALearn.Entities.Guardian;
import com.MainApp.JPALearn.Entities.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	/*
	 * @Test public void saveStudent() { Student student=Student.builder()
	 * .emailId("xx@gmilc.om") .firstName("Shabir") .lastName("lastneme")
	 * .guardianName("varade") .guardianMobile("333333333")
	 * .guardianEmail("vds@fd.com") .build(); studentRepository.save(student); }
	 */

	@Test
	public void saveStudent() {

		Guardian guardian = Guardian.builder().email("guard@d.com").name("ganes").mobile("232").build();

		Student student = Student.builder().emailId("xx@gmilc.om").firstName("Shabir").lastName("lastneme")
				.guadian(guardian).build();
		studentRepository.save(student);
	}

	@Test
	public void saveStudent2() {

		Guardian guardian = Guardian.builder().email("abc@d.com").name("akas").mobile("121").build();

		Student student = Student.builder().emailId("acd@gmilc.om").firstName("asjd").lastName("lastneme")
				.guadian(guardian).build();
		studentRepository.save(student);
	}

	@Test
	public void printAllStudet() {
		var sList = studentRepository.findAll();
		for (var x : sList) {
			System.out.println(x);
		}
	}

	@Test
	public void printByFirstName() {
		System.out.println(">>>>>>>> printByFirstName");
		var sList = studentRepository.findByFirstName("Shabir");
		for (var x : sList) {
			System.out.println(x);
		}

		System.out.println(">>>>>>>> getStudentByEmailAddress");
		var sList1 = studentRepository.getStudentByEmailAddress("guard@d.com");
		for (var x : sList1) {
			System.out.println(x);
		}

		System.out.println(">>>>>>>> getStudentByEmailAddressNative");
		var sList2 = studentRepository.getStudentByEmailAddressNative("abc@d.com");
		System.out.println(sList2);
	}

	/*
	 * @Test public void printByGuardianContaining() {
	 * System.out.println(">>>>>>>> printByGuardianContaining"); var
	 * sList=studentRepository.findByGuardianName("an"); for(var x:sList) {
	 * System.out.println(x); } }
	 */
	@Test
	public void updateRow() {
		int res = studentRepository.updateStudentNameByEmailId("akash1", "abc@d.com");
		System.out.println(">>>>>>> update " + res);
	}

}

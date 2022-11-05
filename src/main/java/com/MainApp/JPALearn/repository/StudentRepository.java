package com.MainApp.JPALearn.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MainApp.JPALearn.Entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findByFirstName(String firstName);
	List<Student> findByFirstNameContaining(String str);
	List<Student> findByLastNameNotNull();
	
	//Not Working 
	//List<Student> findByGuardianName(String guardianName);
	//JPQL
	@Query("select s from Student s where s.emailId=?1")
	List<Student> getStudentByEmailAddress(String EmailId);
	
	/*@Query(
		value="select * from tbl_student s where s.email_address=?1",
		nativeQuery=true
	)*/
	// Native Query with named parameter
	@Query(
			value="select * from tbl_student s where s.email_address= :emailId",
			nativeQuery=true
		)
	Student getStudentByEmailAddressNative(@Param("emailId") String emailId);
	
	// Update 
	@Modifying
	@Transactional
	@Query(
			value="update tbl_student set first_name=?1 where email_address=?2",
			nativeQuery=true
	)
	int updateStudentNameByEmailId(String firstName,String emailId);
	
	
	
}

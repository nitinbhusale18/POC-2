package com.neosoft.poctask;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.neosoft.poctask.model.Projects;
import com.neosoft.poctask.model.Student;
import com.neosoft.poctask.model.User;
import com.neosoft.poctask.repository.HomeRepository;
import com.neosoft.poctask.repository.UserRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class Poctask2springbootsecurityjwtApplicationTests {

	@Autowired
	private  HomeRepository hr;
	
	
	@Test
	@Order(1)
	public void testPost()
	
	{
		Student s= new Student();
		s.setId(1);
		s.setFirstName("poonam");
		s.setLastName("chougule");
		s.setEmailAddress("p@gmail.com");
		s.setMobileNumber("67843218");
		Projects p= new Projects();
		p.setProjId(1);
		p.setProjName("ecommerce");
		p.setProjDuration("12months");
		s.setProj((Set<Projects>) p);
		hr.save(s);
		assertNotNull(hr.findById(1));
		
		}

	
	
	@Test
	@Order(2)
	public void testGetAll () {
		List list = (List) hr.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	
	@Test
	@Order(3)
	public void testgetSingle () {
		Student s = hr.findById(1).get();
		assertEquals("poonam", s.getFirstName());
	}

	
	

}

package com.neosoft.poctask.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.poctask.model.Projects;
import com.neosoft.poctask.model.Student;
import com.neosoft.poctask.model.User;
import com.neosoft.poctask.service.HomeService;
import com.neosoft.poctask.service.UserServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

public class HomeController {

	@Autowired
	private HomeService hs;

	@Autowired
	private UserServiceImpl us;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getAll")
	
	public List<Student> getAll() {
		return hs.listAll();
	}

	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	@PostMapping("/saveall")
	public void saveStudent(@RequestBody Student student) {
		hs.saveAll(student);

	}
	
	@PostMapping("/saveuser")
	public User saveUser(@RequestBody User u)
	{
		return us.SaveUser(u);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/getsingle/{id}")
	public Student getSingle(@PathVariable int id) {
		return hs.get(id);

	}

	
}

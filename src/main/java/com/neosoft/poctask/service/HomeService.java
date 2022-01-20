package com.neosoft.poctask.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neosoft.poctask.model.Student;

public interface HomeService {
	
	public List<Student> listAll();
        
    public void saveAll(Student student);
     
    public Student get(int id);

}

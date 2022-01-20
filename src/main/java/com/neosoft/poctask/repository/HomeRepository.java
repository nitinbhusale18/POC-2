package com.neosoft.poctask.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.poctask.model.Student;
@Repository
public interface HomeRepository extends CrudRepository<Student, Integer> {

}

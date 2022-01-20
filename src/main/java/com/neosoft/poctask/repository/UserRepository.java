package com.neosoft.poctask.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.poctask.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	
	@Query("SELECT u FROM User u WHERE u.username = :username")
    public User findByUsername(String username);

}
